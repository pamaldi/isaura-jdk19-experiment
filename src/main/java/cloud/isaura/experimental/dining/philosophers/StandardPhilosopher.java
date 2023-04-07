package cloud.isaura.experimental.dining.philosophers;


import cloud.isaura.experimental.channels.Channel;
import cloud.isaura.experimental.channels.InPort;
import cloud.isaura.experimental.channels.OutPort;

public class StandardPhilosopher implements Philosopher
{



    private final Channel leftPickUpChannel;

    private final Channel rightPickUpChannel;

    private final Channel leftPutDownChannel ;

    private final Channel rightPutDownChannel ;

    private Long thinkTime;

    private Long eatTime;

    private Integer cycles;

    private DiningPhilosopherMonitor diningPhilosopherMonitor;

    private OutPort leftPickUpChannelOut = null;
    private OutPort rightPickUpChannelOut = null;
    private InPort leftPutDownChannelIn = null;
    private InPort rightPutDownChannelIn = null;

    public StandardPhilosopher(Channel leftPickUpChannel, Channel rightPickUpChannel, Channel leftPutDownChannel, Channel rightPutDownChannel, Integer pos, Long thinkTime, Long eatTime, Integer cycles, DiningPhilosopherMonitor diningPhilosopherMonitor)
    {
        this.leftPickUpChannel = leftPickUpChannel;
        this.rightPickUpChannel = rightPickUpChannel;
        this.leftPutDownChannel = leftPutDownChannel;
        this.rightPutDownChannel = rightPutDownChannel;
        this.leftPickUpChannelOut = this.leftPickUpChannel.senderConnection();
        this.rightPickUpChannelOut = this.rightPickUpChannel.senderConnection();
        this.leftPutDownChannelIn = this.leftPutDownChannel.receiverConnection();
        this.rightPutDownChannelIn = this.rightPutDownChannel.receiverConnection();
        this.pos = pos;
        this.thinkTime = thinkTime;
        this.eatTime = eatTime;
        this.cycles = cycles;
        this.diningPhilosopherMonitor = diningPhilosopherMonitor;
    }



    private Integer pos;

    @Override
    public void think() throws InterruptedException
    {
        System.out.println(
                descr() + " start thinking");
        Thread.sleep(((int) (Math.random() * thinkTime)));
        System.out.println(
                descr() + " end thinking");

    }

    @Override
    public void eat() throws InterruptedException
    {

        System.out.println(
                descr() + " start eating ");
        this.diningPhilosopherMonitor.startEating();
        Thread.sleep(((int) (Math.random() * eatTime)));
        this.diningPhilosopherMonitor.endEating();
        System.out.println(
                descr() + " end eating ");
        this.diningPhilosopherMonitor.addEatInfo(this.pos);

    }





    private String descr()
    {
        return "Phil number "+this.pos+ " thread"+Thread.currentThread();
    }

    @Override
    public void run()
    {
            System.out.println(descr());

            for(int i = 0; i < cycles;i++)
            {
                try
                {
                    think();
                } catch (InterruptedException e)
                {
                    throw new RuntimeException(e);
                }
                try
                {

                    this.leftPickUpChannelOut.send(pos);
                    this.rightPickUpChannelOut.send(pos);
                    eat();
                    this.leftPutDownChannelIn.receive();
                    this.rightPutDownChannelIn.receive();


                } catch (InterruptedException e)
                {
                    throw new RuntimeException(e);
                }
            }
    }

    public void setPos(Integer pos)
    {
        this.pos = pos;
    }


}
