package cloud.isaura.experimental.dining.philosophers;



import java.util.stream.IntStream;

public class DiningPhilosophers
{
    private Philosopher[] philosophers;
    private BlockingQueueChannel requestChannel;

    private BlockingQueueChannel releaseChannel;

    private StandardWaiter waiter;

    public void agorazein(DiningPhilosophersParams diningPhilosophersParams)
    {
        DiningPhilosopherMonitor diningPhilosopherMonitor = new DiningPhilosopherMonitor(diningPhilosophersParams.numberOfPhilosophers());
        DiningPhilosopherMonitorLog diningPhilosopherMonitorLog = new DiningPhilosopherMonitorLog(diningPhilosopherMonitor);
        Thread t = new Thread(diningPhilosopherMonitorLog);
        t.start();

        initChannelsBetweenPhilosopherAndWaiter(diningPhilosophersParams);
        initPhilosophers(diningPhilosophersParams, diningPhilosopherMonitor);
        startPhilosophers(diningPhilosophersParams);
        initWaiter(diningPhilosophersParams);



    }

    private void startPhilosophers(DiningPhilosophersParams diningPhilosophersParams)
    {
        IntStream.range(0, diningPhilosophersParams.numberOfPhilosophers())
                .forEach(i ->
                    {
                        Thread t = new Thread(this.philosophers[i]);
                        t.start();
                    }
                );
    }

    private void initChannelsBetweenPhilosopherAndWaiter(DiningPhilosophersParams diningPhilosophersParams)
    {
        this.requestChannel = new BlockingQueueChannel(diningPhilosophersParams.numberOfPhilosophers());
        this.releaseChannel = new BlockingQueueChannel(diningPhilosophersParams.numberOfPhilosophers());

    }

    private void initPhilosophers(DiningPhilosophersParams diningPhilosophersParams, DiningPhilosopherMonitor diningPhilosopherMonitor)
    {
        Integer numberOfPhilosophers = diningPhilosophersParams.numberOfPhilosophers();
        this.philosophers= new Philosopher[numberOfPhilosophers];
        IntStream.range(0, diningPhilosophersParams.numberOfPhilosophers())
                .forEach(i ->
                        {
                            PhilosopherAttribute philosopherAttribute = new PhilosopherAttribute(diningPhilosophersParams.eatTime(), diningPhilosophersParams.thinkingTime(), diningPhilosophersParams.cycles(), diningPhilosopherMonitor);
                            int leftIndex = i;
                            int rightIndex = (i+1)%diningPhilosophersParams.numberOfPhilosophers();
                            System.out.println(" Phil "+i+" l "+leftIndex+" r "+rightIndex);
                            this.philosophers[i]= PhilosopherFactory.build(diningPhilosophersParams.philosopherType(),philosopherAttribute,this.requestChannel,this.releaseChannel,i);

                        }
                );

    }






    private void initWaiter(DiningPhilosophersParams diningPhilosophersParams)
    {
        this.waiter = new StandardWaiter(this.requestChannel,this.releaseChannel);
        Thread t = new Thread(this.waiter);
        t.start();
    }

}
