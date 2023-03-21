package cloud.isaura.experimental.dining.philosophers;

public class StandardPhilosopher implements Philosopher
{

    protected StandardPhilosopher(){}

    private PhilosopherAttribute philosopherAttribute;

    private Channel left;

    private Channel right;

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

    @Override
    public void setChannelLeft(Channel channel)
    {
      this.left=channel;
    }

    @Override
    public void setChannelRight(Channel channel)
    {
        this.right=channel;
    }

    @Override
    public void setPos(Integer pos)
    {
        this.pos=pos;
    }

    private String descr()
    {
        return "Phil number "+pos+ " thread"+Thread.currentThread()+" with left channel "+this.left+ "and rigth channel "+this.right;
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
                    while(!this.left.take() || !this.right.take())
                    {
                        System.out.println(
                                descr() + " wait for fork");
                        Thread.sleep(((int) (Math.random() * philosopherAttribute.eatTime())));
                    }
                    eat();
                    this.left.put();
                    this.right.put();
                } catch (InterruptedException e)
                {
                    throw new RuntimeException(e);
                }
            }
    }
}
