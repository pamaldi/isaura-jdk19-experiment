package cloud.isaura.experimental.readers_writers;

import cloud.isaura.experimental.channels.Channel;

public class ReadersAndWritersOrchestra
{
    private ReadersWritersArgs readersWritersArgs;

    public ReadersAndWritersOrchestra(ReadersWritersArgs readersWritersArgs)
    {
        this.readersWritersArgs = readersWritersArgs;
    }

    public void orchestrate()
    {
        for(int i = 0; i < 1000; i++)
        {
            Channel channel = new Channel(Integer.valueOf(i).longValue());
            Reader reader = new Reader(channel.receiverConnection());
            Writer writer = new Writer(channel.senderConnection());
            if(readersWritersArgs.useVirtualThreads())
            {
                Thread.startVirtualThread(writer);
                Thread.startVirtualThread(reader);
            }
            else
            {
                Thread readerThread = new Thread(reader);
                readerThread.start();
                Thread writerThread = new Thread(writer);
                writerThread.start();
            }


        }
        while (true){

        }


    }

}
