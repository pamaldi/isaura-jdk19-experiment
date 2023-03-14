package cloud.isaura.experimental.text;


import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Tokenizer implements TokenLineParser
{


    private HashMap<String, Integer> tokens;

    public Tokenizer()
    {
        this.tokens = new HashMap<>();
    }

    public void tokens(TokenizerOption tokenizerOption) throws IOException, URISyntaxException
    {
       TokenizerParamsValidator tokenizerParamsValidator = new TokenizerParamsValidator();
       tokenizerParamsValidator.isValid(tokenizerOption);
       if(tokenizerOption.parseFileStrategy().equals(ParseFileStrategy.DEFAULT))
        {
            LineByLineReader lineByLineReader = new LineByLineReader();
            lineByLineReader.read(tokenizerOption.url(), this);
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
