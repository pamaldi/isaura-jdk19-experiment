package cloud.isaura.experimental.text;




import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class Tokenizer
{


    private HashMap<String, Integer> tokens;
    private Channel<String> channel;

    private Channel<Boolean>[] closeChannels;

    private List<LineByLineReader> lineByLineReaders;

    public Tokenizer()
    {
        this.tokens = new HashMap<>();
        this.channel = new Channel<>();

    }

    public void tokens(TokenizerOption tokenizerOption) throws IOException, URISyntaxException
    {
       TokenizerParamsValidator tokenizerParamsValidator = new TokenizerParamsValidator();
       tokenizerParamsValidator.isValid(tokenizerOption);
       this.lineByLineReaders = new ArrayList<>(tokenizerOption.numberOfReader());
       String resourcePath = FileUtils.getResourcePath();
        long start = System.currentTimeMillis();
        List<File> files = FileSplitter.splitBySize(tokenizerOption.is(), tokenizerOption.numberOfReader(), resourcePath);
        long end = System.currentTimeMillis();
        long diff = end - start;
        System.out.println(" elapsed split "+diff);
        this.closeChannels = new Channel[tokenizerOption.numberOfReader()];

       for(int i = 0; i < files.size(); i++)
       {

           File file = files.get(i);
           this.closeChannels[i] = new Channel<>();
           this.closeChannels[i].put(Boolean.FALSE);
           LineByLineReader lineByLineReader = new LineByLineReader(file.getAbsolutePath(), channel, this.closeChannels[i]);
           this.lineByLineReaders.add(lineByLineReader);

       }

        Thread.startVirtualThread(this::run);
        this.lineByLineReaders.forEach(LineByLineReader::start);






    }

    private void run() {
        System.out.println("Start virtual thread for tokenizer "+Thread.currentThread());
        while (true) {
            int numberOfClose = 0;
            for (int i = 0; i < this.closeChannels.length; i++)
            {
                Boolean closed = this.closeChannels[i].take().booleanValue() == true;
                numberOfClose = closed ? numberOfClose + 1 : numberOfClose;
            }
            Boolean areAllClosed = numberOfClose == this.closeChannels.length;
            System.out.println("areAllClosed  " + areAllClosed);


            String take = this.channel.take();
            putLine(take);
            System.out.println("areAllClosed exit "+areAllClosed );
        }


    }

    private void sleep() {
        try {
            Thread.sleep(1);
        } catch (InterruptedException ignore) {

        }
    }

    private void putLine(String line)
    {
        String regexNumber = "[0-9]+";

        StringTokenizer sTokenize = new StringTokenizer(line.toLowerCase().replaceAll("\\p{Punct}", " "));
        while (sTokenize.hasMoreTokens())
        {
            String word = sTokenize.nextToken();
            Boolean isValid = word.length() > 1 && !word.matches(regexNumber);
            if (isValid)
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

    public Integer numberOfTokens()
    {
        return this.tokens.size();
    }

}
