package cloud.isaura.experimental.readers_writers;

import cloud.isaura.experimental.channels.InPort;

public class Reader implements Runnable
{
    private final InPort inPort;

    public Reader(InPort inPort)
    {
        this.inPort = inPort;
    }

    public void read()
    {

        Object receive = inPort.receive();
        System.out.println("Reader " + Thread.currentThread() + " read " + receive);
    }

    @Override
    public void run()
    {
        for(int i = 0; i < 50; i++)
        {
            read();
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
