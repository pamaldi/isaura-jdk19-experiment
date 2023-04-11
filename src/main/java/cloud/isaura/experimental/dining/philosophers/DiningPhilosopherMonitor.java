package cloud.isaura.experimental.dining.philosophers;

public class DiningPhilosopherMonitor
{


    private  Integer numberOfPhilosophers = null;
    private int[] numberOfEat = null;

    private int concurrentEating = 0;


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
        this.concurrentEating=this.concurrentEating+1;
    }

    public void endEating()
    {
        this.concurrentEating=this.concurrentEating-1;
    }

    public void print()
    {
        if(concurrentEating == 0)
        {

            for (int i = 0; i < numberOfPhilosophers; i++)
            {
                System.out.println("Phil "+i+" eat "+numberOfEat[i]);
            }
        }
        System.out.println("Concurrent eating:" + this.concurrentEating);
    }
}
