package cloud.isaura.experimental.dining.philosophers;

import cloud.isaura.experimental.channels.Channel;

public class Fork implements Runnable
{

    private final Channel channel;


    public Fork(Channel channel)
    {
        this.channel = channel;
    }

    @Override
    public void run()
    {
        while (true)
        {


        }
    }
}
