package cloud.isaura.experimental.dining.philosophers;

public interface Philosopher extends Runnable
{
    void think() throws InterruptedException;

    void eat() throws InterruptedException;






}
