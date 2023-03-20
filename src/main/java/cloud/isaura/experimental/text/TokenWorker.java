package cloud.isaura.experimental.text;


import java.util.HashMap;
import java.util.StringTokenizer;

public class TokenWorker
{

    private HashMap<String, Integer> tokens;

    private final Channel<String> channel;

    public TokenWorker(Channel<String> channel)
    {
        this.channel = channel;
        this.tokens = new HashMap<>();
    }

    private void run() {

        System.out.println("Worker : Start virtual thread "+Thread.currentThread());
        while(true)
        {
            String take = this.channel.take();
            putLine(take);
        }

    }

    public void start() {
        Thread.startVirtualThread(this::run);
    }

    private void putLine(String line)
    {
        //System.out.println("Worker  "+Thread.currentThread()+ " put line "+line);
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
}
