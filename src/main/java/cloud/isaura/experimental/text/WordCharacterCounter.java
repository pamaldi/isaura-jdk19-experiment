package cloud.isaura.experimental.text;

import java.util.HashMap;

public class WordCharacterCounter
{
    private final Channel<String> channel;

    private HashMap<String, Integer> counter;

    public WordCharacterCounter(Channel<String> channel)
    {
        this.channel = channel;
        this.counter = new HashMap<>();
    }

    private void run() {

        System.out.println("Counter : Start virtual thread "+Thread.currentThread());
        while(true)
        {
            String take = this.channel.take();
            if(this.counter.get(take) == null)
            {
                this.counter.put(take,0);
            }
            this.counter.put(take,counter.get(take) + 1);
            //System.out.println("Counter  "+Thread.currentThread()+" token "+this.counter.size());
            //System.out.println("Counter  "+Thread.currentThread()+" token "+this.counter.toString());
        }

    }

    public void start() {
        Thread.startVirtualThread(this::run);
    }
}
