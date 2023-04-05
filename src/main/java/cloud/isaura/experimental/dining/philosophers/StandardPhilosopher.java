package cloud.isaura.experimental.dining.philosophers;

import cloud.isaura.experimental.channels.Channel;

public class StandardPhilosopher implements Philosopher
{

    protected StandardPhilosopher(){}

    private PhilosopherAttribute philosopherAttribute;

    private Channel channelWithLeftFork;

    private Channel channelWithRightFork;


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

    public void setChannelWithLeftFork(Channel channelWithLeftFork)
    {
        this.channelWithLeftFork = channelWithLeftFork;
    }

    public void setChannelWithRightFork(Channel channelWithRightFork)
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
                    this.channelWithLeftFork.senderConnection().send(descr());
                    this.channelWithRightFork.senderConnection().send(descr());
                    eat();
                    this.channelWithLeftFork.receiverConnection().receive();
                    this.channelWithRightFork.receiverConnection().receive();
                } catch (InterruptedException e)
                {
                    throw new RuntimeException(e);
                }
            }
    }
}
