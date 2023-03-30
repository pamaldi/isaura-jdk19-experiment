package cloud.isaura.experimental.dining.philosophers;

public class StandardPhilosopher implements Philosopher
{

    protected StandardPhilosopher(){}

    private PhilosopherAttribute philosopherAttribute;

    private SynchroNotBufferedChannel channelWithLeftFork;

    private SynchroNotBufferedChannel channelWithRightFork;
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
        Thread.sleep(((int) (Math.random() * philosopherAttribute.eatTime())));
        System.out.println(
                descr() + " end eating ");

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

    @Override
    public void setPos(Integer pos)
    {
        this.pos=pos;
    }

    private String descr()
    {
        return "Phil number "+pos+ " thread"+Thread.currentThread();
    }

    @Override
    public void run()
    {
            System.out.println(descr());
            while(true)
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
                    while(!this.channelWithLeftFork.take() || !this.channelWithRightFork.take())
                    {
                        System.out.println(
                                descr() + " wait for fork");
                        Thread.sleep(((int) (Math.random() * philosopherAttribute.eatTime())));
                    }
                    eat();
                    this.channelWithLeftFork.put();
                    this.channelWithRightFork.put();
                } catch (InterruptedException e)
                {
                    throw new RuntimeException(e);
                }
            }
    }
}
