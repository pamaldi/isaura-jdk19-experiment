package cloud.isaura.experimental.readers_writers;

import cloud.isaura.experimental.channels.OutPort;

public class Writer implements Runnable
{
    private final OutPort outPort;

    public Writer(OutPort outPort)
    {
        this.outPort = outPort;
    }

    public void write(String msg)
    {
        outPort.send(msg);
        System.out.println("Writer " + Thread.currentThread() + " wrote " + msg);
    }

    @Override
    public void run()
    {
        for(int i = 0; i < 50; i++)
        {
            write( + i + " ");
            try
            {
                Thread.sleep(((int) (Math.random() * 1000)));
            } catch (InterruptedException e)
            {
                throw new RuntimeException(e);
            }

        }
    }
}


