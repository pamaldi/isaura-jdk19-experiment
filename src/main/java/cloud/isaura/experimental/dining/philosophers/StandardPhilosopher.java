package cloud.isaura.experimental.dining.philosophers;

public class StandardPhilosopher implements Philosopher
{

    protected StandardPhilosopher(){}

    private PhilosopherAttribute philosopherAttribute;

    private SynchroNotBufferedChannel channelWithLeftFork;

    private SynchroNotBufferedChannel channelWithRightFork;


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
        this.philosopherAttribute.diningPhilosopherMonitor().addEatInfo(philosopherAttribute.index());

    }

    @Override
    public void setPhilosopherAttribute(PhilosopherAttribute philosopherAttribute)
    {
        this.philosopherAttribute=philosopherAttribute;
    }

    public void setChannelWithLeftFork(SynchroNotBufferedChannel channelWithLeftFork)
    {
        this.channelWithLeftFork = channelWithLeftFork;
    }

    public void setChannelWithRightFork(SynchroNotBufferedChannel channelWithRightFork)
    {
        this.channelWithRightFork = channelWithRightFork;
    }



    private String descr()
    {
        return "Phil number "+this.philosopherAttribute.index()+ " thread"+Thread.currentThread();
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
                    this.channelWithLeftFork.put();
                    this.channelWithRightFork.put();
                    eat();
                    this.channelWithLeftFork.take();
                    this.channelWithRightFork.take();
                } catch (InterruptedException e)
                {
                    throw new RuntimeException(e);
                }
            }
    }
}
