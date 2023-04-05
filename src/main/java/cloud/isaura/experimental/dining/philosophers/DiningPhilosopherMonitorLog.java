package cloud.isaura.experimental.dining.philosophers;

public class DiningPhilosopherMonitorLog implements Runnable
{

    private DiningPhilosopherMonitor diningPhilosopherMonitor;

    public DiningPhilosopherMonitorLog(DiningPhilosopherMonitor diningPhilosopherMonitor)
    {
        this.diningPhilosopherMonitor = diningPhilosopherMonitor;
    }

    @Override
    public void run()
    {
        while(true)
        {
            this.diningPhilosopherMonitor.print();
            try
            {
                Thread.sleep(2000);
            } catch (InterruptedException e)
            {
                throw new RuntimeException(e);
            }


        }
    }
}
