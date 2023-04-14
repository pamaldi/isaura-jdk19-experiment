package cloud.isaura.experimental.dining.philosophers;

import java.util.concurrent.locks.ReentrantLock;

public class DiningPhilosopherMonitor
{


    private  Integer numberOfPhilosophers = null;
    private int[] numberOfEat = null;

    private int concurrentEating = 0;

    private ReentrantLock lock = new ReentrantLock();

    public DiningPhilosopherMonitor(Integer numberOfPhilosophers)
    {
        this.numberOfPhilosophers = numberOfPhilosophers;
        this.numberOfEat= new int[numberOfPhilosophers];
    }

    public void addEatInfo(int i)
    {
        this.numberOfEat[i]= this.numberOfEat[i]+1;
    }

    public void startEating()
    {
        this.lock.lock();
        this.concurrentEating=this.concurrentEating+1;
        this.lock.unlock();
    }

    public void endEating()
    {
        this.lock.lock();
        this.concurrentEating=this.concurrentEating-1;
        this.lock.unlock();
    }

    public void print()
    {

        System.out.println("Concurrent eating:" + this.concurrentEating);
    }
}
