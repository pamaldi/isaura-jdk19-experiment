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

    private final OutPort leftPutDownChannelOut;

    private final InPort rigthPickUpChannelIn;

    private final OutPort rightPutDownChannelOut;

    public Fork(Channel leftPickUpChannel, Channel leftPutDownChannel, Channel rigthPickUpChannel, Channel rightPutDownChannel)
    {
        this.leftPickUpChannel = leftPickUpChannel;
        this.leftPutDownChannel = leftPutDownChannel;
        this.rigthPickUpChannel = rigthPickUpChannel;
        this.rightPutDownChannel = rightPutDownChannel;
        this.leftPickUpChannelIn = this.leftPickUpChannel.receiverConnection();
        this.leftPutDownChannelOut = this.leftPutDownChannel.senderConnection();
        this.rigthPickUpChannelIn = this.rigthPickUpChannel.receiverConnection();
        this.rightPutDownChannelOut = this.rightPutDownChannel.senderConnection();
    }



    @Override
    public void run()
    {
        while (true)
        {
            this.leftPickUpChannelIn.receive();
            this.rigthPickUpChannelIn.receive();
            this.leftPutDownChannelOut.send(1);
            this.rightPutDownChannelOut.send(1);
        }
    }
}
