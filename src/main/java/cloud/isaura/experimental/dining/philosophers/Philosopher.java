package cloud.isaura.experimental.dining.philosophers;

public interface Philosopher extends Runnable
{
    void think() throws InterruptedException;

    void eat() throws InterruptedException;

    void setPhilosopherAttribute(PhilosopherAttribute philosopherAttribute);

    void setChannelLeft(Channel channel);

    void setChannelRight(Channel channel);

    void setPos(Integer pos);


}
