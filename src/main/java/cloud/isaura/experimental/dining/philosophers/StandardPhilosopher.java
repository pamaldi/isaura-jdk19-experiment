package cloud.isaura.experimental.dining.philosophers;


public class StandardPhilosopher implements Philosopher
{

    protected StandardPhilosopher(){}

    private PhilosopherAttribute philosopherAttribute;

    private BlockingQueueChannel channelRequestWaiter;

    private BlockingQueueChannel channelReleaseWaiter;

    private Integer pos;

    @Override
    public void think() throws InterruptedException
    {
        System.out.println(
                descr() + " start thinking");
        Thread.sleep(((int) (Math.random() * philosopherAttribute.thinkTime())));
        System.out.println(
                descr() + " end thinking");

    }

    @Override
    public void eat() throws InterruptedException
    {

        System.out.println(
                descr() + " start eating ");
        this.philosopherAttribute.diningPhilosopherMonitor().startEating();
        Thread.sleep(((int) (Math.random() * philosopherAttribute.eatTime())));
        this.philosopherAttribute.diningPhilosopherMonitor().endEating();
        System.out.println(
                descr() + " end eating ");
        this.philosopherAttribute.diningPhilosopherMonitor().addEatInfo(this.pos);

    }

    @Override
    public void setPhilosopherAttribute(PhilosopherAttribute philosopherAttribute)
    {
        this.philosopherAttribute=philosopherAttribute;
    }

    public void setChannelRequestWaiter(BlockingQueueChannel channelRequestWaiter)
    {
        this.channelRequestWaiter = channelRequestWaiter;
    }

    private String descr()
    {
        return "Phil number "+this.pos+ " thread"+Thread.currentThread();
    }

    @Override
    public void run()
    {
            System.out.println(descr());

            for(int i = 0; i < philosopherAttribute.cycles();i++)
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

                    this.channelRequestWaiter.send(this.pos);
                    eat();
                    this.channelReleaseWaiter.send(pos);

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

    public void setChannelReleaseWaiter(BlockingQueueChannel channelReleaseWaiter)
    {
        this.channelReleaseWaiter = channelReleaseWaiter;
    }
}
