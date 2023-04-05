package cloud.isaura.experimental.dining.philosophers;

import cloud.isaura.experimental.channels.Channel;

import java.util.stream.IntStream;

public class DiningPhilosophers
{
    private Philosopher[] philosophers;

    private Fork[]        forks;

    private Channel[] channelsBetweenPhilosopherAndFork;

    private Waiter waiter;

    public void agorazein(DiningPhilosophersParams diningPhilosophersParams)
    {
        DiningPhilosopherMonitor diningPhilosopherMonitor = new DiningPhilosopherMonitor(diningPhilosophersParams.numberOfPhilosophers());
        DiningPhilosopherMonitorLog diningPhilosopherMonitorLog = new DiningPhilosopherMonitorLog(diningPhilosopherMonitor);
        Thread t = new Thread(diningPhilosopherMonitorLog);
        t.start();

        initChannelsBetweenPhilosopherAndFork(diningPhilosophersParams);
        initPhilosophers(diningPhilosophersParams, diningPhilosopherMonitor);
        initForks(diningPhilosophersParams);
        startPhilosophers(diningPhilosophersParams);
        startForks(diningPhilosophersParams);



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

    private void initChannelsBetweenPhilosopherAndFork(DiningPhilosophersParams diningPhilosophersParams)
    {
        this.channelsBetweenPhilosopherAndFork = new Channel[diningPhilosophersParams.numberOfPhilosophers()];
        IntStream.range(0, diningPhilosophersParams.numberOfPhilosophers())
                .forEach(
                        i -> this.channelsBetweenPhilosopherAndFork[i] = new Channel(Integer.valueOf(i).longValue())
                );
    }

    private void initPhilosophers(DiningPhilosophersParams diningPhilosophersParams, DiningPhilosopherMonitor diningPhilosopherMonitor)
    {
        Integer numberOfPhilosophers = diningPhilosophersParams.numberOfPhilosophers();
        this.philosophers= new Philosopher[numberOfPhilosophers];
        IntStream.range(0, diningPhilosophersParams.numberOfPhilosophers())
                .forEach(i ->
                        {
                            PhilosopherAttribute philosopherAttribute = new PhilosopherAttribute(diningPhilosophersParams.eatTime(), diningPhilosophersParams.thinkingTime(), diningPhilosophersParams.cycles(), diningPhilosopherMonitor,i);
                            int leftIndex = i;
                            int rightIndex = (i+1)%diningPhilosophersParams.numberOfPhilosophers();
                            System.out.println(" Phil "+i+" l "+leftIndex+" r "+rightIndex);
                            this.philosophers[i]= PhilosopherFactory.build(diningPhilosophersParams.philosopherType(),philosopherAttribute,this.channelsBetweenPhilosopherAndFork[leftIndex],this.channelsBetweenPhilosopherAndFork[rightIndex],i);

                        }
                );

    }

    private void initForks(DiningPhilosophersParams diningPhilosophersParams)
    {
        Integer numberOfPhilosophers = diningPhilosophersParams.numberOfPhilosophers();
        this.forks= new Fork[numberOfPhilosophers];
        IntStream.range(0, diningPhilosophersParams.numberOfPhilosophers())
                .forEach(i ->
                        {
                            this.forks[i]= new Fork(this.channelsBetweenPhilosopherAndFork[i]);

                        }
                );

    }


    private void startForks(DiningPhilosophersParams diningPhilosophersParams)
    {
        IntStream.range(0, diningPhilosophersParams.numberOfPhilosophers())
                .forEach(i ->
                        {
                            Thread t = new Thread(this.forks[i]);
                            t.start();
                        }
                );
    }

}
