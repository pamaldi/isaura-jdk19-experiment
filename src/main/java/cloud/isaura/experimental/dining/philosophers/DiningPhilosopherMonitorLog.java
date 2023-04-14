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
        Long start = System.currentTimeMillis();
        while(true)
        {
            this.diningPhilosopherMonitor.print();
            try
            {
                Thread.sleep(1000);
            } catch (InterruptedException e)
            {
                throw new RuntimeException(e);
            }

            System.out.println("Elapsed time: " + (System.currentTimeMillis() - start));
        }
    }
}
