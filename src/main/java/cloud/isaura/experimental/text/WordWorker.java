package cloud.isaura.experimental.text;


import java.util.HashMap;
import java.util.StringTokenizer;

public class WordWorker
{

    private HashMap<String, Integer> tokens;

    private final Channel<String> channel;



    private HashMap<Character, Channel<String>> letterChannels;

    public WordWorker(Channel<String> channel,  HashMap<Character, Channel<String>> letterChannels)
    {
        this.channel = channel;
        this.tokens = new HashMap<>();
        this.letterChannels=letterChannels;
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
                Character c = word.charAt(0);
                Channel<String> channel = this.letterChannels.get(c);
                if(channel != null)
                {
                    channel.put(word);
                }
            }
        }
    }
}
