package cloud.isaura.experimental.dining.philosophers;

import cloud.isaura.experimental.channels.Channel;



public class StandardWaiter implements  Runnable
{


    private BlockingQueueChannel requestChannel;
    private BlockingQueueChannel responseChannel;


    public StandardWaiter(BlockingQueueChannel requestChannel, BlockingQueueChannel responseChannel)
    {
        this.requestChannel = requestChannel;
        this.responseChannel = responseChannel;
    }



    @Override
    public void run()
    {
        while(true)
        {
            Integer receive = this.requestChannel.receive();
            this.responseChannel.receive();
        }
    }
}
