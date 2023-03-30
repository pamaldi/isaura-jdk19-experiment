package cloud.isaura.experimental.dining.philosophers;

import java.util.stream.IntStream;

public class DiningPhilosophers
{
    private Philosopher[] philosophers;

    private Fork[]        forks;

    private SynchroNotBufferedChannel[] channelsBetweenPhilosopherAndFork;

    private Waiter waiter;

    public void agorazein(DiningPhilosophersParams diningPhilosophersParams)
    {

        initChannelsBetweenPhilosopherAndFork(diningPhilosophersParams);
        initPhilosophers(diningPhilosophersParams);
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
        this.channelsBetweenPhilosopherAndFork = new SynchroNotBufferedChannel[diningPhilosophersParams.numberOfPhilosophers()];
        IntStream.range(0, diningPhilosophersParams.numberOfPhilosophers())
                .forEach(
                        i -> this.channelsBetweenPhilosopherAndFork[i] = new SynchroNotBufferedChannel()
                );
    }

    private void initPhilosophers(DiningPhilosophersParams diningPhilosophersParams)
    {
        Integer numberOfPhilosophers = diningPhilosophersParams.numberOfPhilosophers();
        this.philosophers= new Philosopher[numberOfPhilosophers];
        PhilosopherAttribute philosopherAttribute = new PhilosopherAttribute(diningPhilosophersParams.eatTime(), diningPhilosophersParams.thinkingTime());
        IntStream.range(0, diningPhilosophersParams.numberOfPhilosophers())
                .forEach(i ->
                        {
                            this.philosophers[i]= PhilosopherFactory.build(diningPhilosophersParams.philosopherType(),philosopherAttribute,this.channelsBetweenPhilosopherAndFork[i],this.channelsBetweenPhilosopherAndFork[(i+1)%diningPhilosophersParams.numberOfPhilosophers()],i);

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
