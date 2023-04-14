package cloud.isaura.experimental.dining.philosophers;

import cloud.isaura.experimental.channels.Channel;
import cloud.isaura.experimental.channels.InPort;

public class Fork implements    Runnable
{

    private final Channel leftPickUpChannel;

    private final Channel leftPutDownChannel;

    private final Channel rigthPickUpChannel;

    private final Channel rightPutDownChannel;



    private Integer pos;

    public Fork(Channel leftPickUpChannel, Channel leftPutDownChannel, Channel rigthPickUpChannel, Channel rightPutDownChannel, Integer pos)
    {
        this.leftPickUpChannel = leftPickUpChannel;
        this.leftPutDownChannel = leftPutDownChannel;
        this.rigthPickUpChannel = rigthPickUpChannel;
        this.rightPutDownChannel = rightPutDownChannel;

        this.pos = pos;
    }



    @Override
    public void run()
    {


        while (true)
        {
            try{
            //System.out.println("Fork "+pos+ ": waiting for leftPickUpChannel "+this.leftPickUpChannel);
            this.leftPickUpChannel.receive();
            //System.out.println("Fork "+pos+ ": waiting for leftPutDownChannel "+this.leftPutDownChannel);
            this.leftPutDownChannel.receive();

            //System.out.println("Fork "+pos+ ": waiting for rightPickUpChannel "+this.rigthPickUpChannel);
            this.rigthPickUpChannel.receive();
            //System.out.println("Fork "+pos+ ": waiting for rightPutDownChannel "+this.rightPutDownChannel);
            this.rightPutDownChannel.receive();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
}
