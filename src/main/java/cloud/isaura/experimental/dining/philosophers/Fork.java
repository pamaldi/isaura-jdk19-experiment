package cloud.isaura.experimental.dining.philosophers;

public class Fork implements Runnable
{

    private final SynchroNotBufferedChannel channel;


    public Fork(SynchroNotBufferedChannel channel)
    {
        this.channel = channel;
    }

    @Override
    public void run()
    {
        while (true)
        {
            this.channel.put();
            this.channel.take();
        }
    }
}
