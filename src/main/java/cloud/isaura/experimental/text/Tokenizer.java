package cloud.isaura.experimental.text;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Tokenizer implements LineReader
{


    private HashMap<String, Integer> tokens;

    public void tokens(TokenizerOption tokenizerOption) throws IOException
    {
        if(tokenizerOption.absoluteFileName()==null)
        {
            throw new IllegalArgumentException("File name mandatory");
        }

        Path path = Paths.get(tokenizerOption.absoluteFileName());
        boolean exists = Files.exists(path);
        if(!exists)
        {
            throw new FileNotFoundException("File does not exists");
        }

        this.tokens = new HashMap<>();

        if(tokenizerOption.parseFileStrategy().equals(ParseFileStrategy.DEFAULT))
        {
            LineByLineReader lineByLineReader = new LineByLineReader();
            lineByLineReader.read(tokenizerOption.absoluteFileName(), this);
        }
        System.out.println("lines "+this.tokens.entrySet().size());

    }

    @Override
    public void accept(String line)
    {

        String regexNumber = "[0-9]+";


        StringTokenizer sTokenize = new StringTokenizer(line.toLowerCase().replaceAll("\\p{Punct}", " "));
        while (sTokenize.hasMoreTokens())
        {
            String word = sTokenize.nextToken();
            Boolean isValid = word.length()>1 && !word.matches(regexNumber);
            if(isValid)
            {
                if (tokens.containsKey(word))
                {
                    tokens.put(word, tokens.get(word) + 1);
                } else
                {
                    tokens.put(word, 1);
                }
            }
        }


    }
}
