package cloud.isaura.experimental.dining.philosophers;

import cloud.isaura.experimental.channels.Channel;
import cloud.isaura.experimental.channels.InPort;
import cloud.isaura.experimental.channels.OutPort;

public class Fork implements    Runnable
{

    private final Channel leftPickUpChannel;

    private final Channel leftPutDownChannel;

    private final Channel rigthPickUpChannel;

    private final Channel rightPutDownChannel;

    private final InPort leftPickUpChannelIn;

    private final InPort leftPutDownChannelIn;

    private final InPort rigthPickUpChannelIn;

    private final InPort rightPutDownChannelIn;

    private Integer pos;

    public Fork(Channel leftPickUpChannel, Channel leftPutDownChannel, Channel rigthPickUpChannel, Channel rightPutDownChannel, Integer pos)
    {
        this.leftPickUpChannel = leftPickUpChannel;
        this.leftPutDownChannel = leftPutDownChannel;
        this.rigthPickUpChannel = rigthPickUpChannel;
        this.rightPutDownChannel = rightPutDownChannel;
        this.leftPickUpChannelIn = this.leftPickUpChannel.receiverConnection();
        this.leftPutDownChannelIn = this.leftPutDownChannel.receiverConnection();
        this.rigthPickUpChannelIn = this.rigthPickUpChannel.receiverConnection();
        this.rightPutDownChannelIn = this.rightPutDownChannel.receiverConnection();
        this.pos = pos;
    }



    @Override
    public void run()
    {

        System.out.println("Fork "+pos+ ": leftPickUpChannel "+this.leftPickUpChannel+" rightPickUpChannel "+this.rigthPickUpChannel+" leftPutDownChannel "+this.leftPutDownChannel+" rightPutDownChannel "+this.rightPutDownChannel);

        while (true)
        {
            //System.out.println("Fork "+pos+ ": waiting for leftPickUpChannel "+this.leftPickUpChannel);
            this.leftPickUpChannelIn.receive();
            //System.out.println("Fork "+pos+ ": waiting for leftPutDownChannel "+this.leftPutDownChannel);
            this.leftPutDownChannelIn.receive();

            //System.out.println("Fork "+pos+ ": waiting for rightPickUpChannel "+this.rigthPickUpChannel);
            this.rigthPickUpChannelIn.receive();
            //System.out.println("Fork "+pos+ ": waiting for rightPutDownChannel "+this.rightPutDownChannel);
            this.rightPutDownChannelIn.receive();
        }
    }
}
