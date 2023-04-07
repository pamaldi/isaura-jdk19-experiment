package cloud.isaura.experimental.dining.philosophers;



import cloud.isaura.experimental.channels.Channel;

import java.util.stream.IntStream;

public class DiningPhilosophers
{
    private Philosopher[] philosophers;

    private Fork[] forks;

    private StandardWaiter waiter;

    private Channel[] pickUpForksChannels;

    private Channel[] putDownForksChannels;

    public void agorazein(DiningPhilosophersParams diningPhilosophersParams)
    {
        DiningPhilosopherMonitor diningPhilosopherMonitor = new DiningPhilosopherMonitor(diningPhilosophersParams.numberOfPhilosophers());
        DiningPhilosopherMonitorLog diningPhilosopherMonitorLog = new DiningPhilosopherMonitorLog(diningPhilosopherMonitor);
        Thread t = new Thread(diningPhilosopherMonitorLog);
        t.start();

        initForksChannels(diningPhilosophersParams);
        initPhilosophers(diningPhilosophersParams, diningPhilosopherMonitor);
        startPhilosophers(diningPhilosophersParams);
        initForks(diningPhilosophersParams);
        startForks(diningPhilosophersParams);



    }

    private void startPhilosophers(DiningPhilosophersParams diningPhilosophersParams)
    {
        IntStream.range(0, diningPhilosophersParams.numberOfPhilosophers())
                .forEach(i ->
                    {
                        if(diningPhilosophersParams.philosopherType().equals(PhilosopherType.GREEK))
                        {
                            Thread t = new Thread(this.philosophers[i]);
                            t.start();
                        }
                        else if(diningPhilosophersParams.philosopherType().equals(PhilosopherType.GERMAN))
                        {
                            Thread.startVirtualThread(this.philosophers[i]::run);
                        }

                    }
                );
    }

    private void startForks(DiningPhilosophersParams diningPhilosophersParams)
    {
        IntStream.range(0, diningPhilosophersParams.numberOfPhilosophers())
                .forEach(i ->
                        {
                            if(diningPhilosophersParams.philosopherType().equals(PhilosopherType.GREEK))
                            {
                                Thread t = new Thread(this.forks[i]);
                                t.start();
                            }
                            else if(diningPhilosophersParams.philosopherType().equals(PhilosopherType.GERMAN))
                            {
                                Thread.startVirtualThread(this.forks[i]::run);
                            }

                        }
                );
    }


    private void initPhilosophers(DiningPhilosophersParams diningPhilosophersParams, DiningPhilosopherMonitor diningPhilosopherMonitor)
    {
        Integer numberOfPhilosophers = diningPhilosophersParams.numberOfPhilosophers();
        this.philosophers= new Philosopher[numberOfPhilosophers];
        int current = 0;
        for(int i = 0; i < numberOfPhilosophers; i++)

                        {
                            int leftIndex = current++;
                            int rightIndex = ( (current++) %(diningPhilosophersParams.numberOfPhilosophers()*2));

                            System.out.println(" Phil "+i+" l "+leftIndex+" r "+rightIndex);
                            this.philosophers[i]=
                                    new StandardPhilosopher(this.pickUpForksChannels[leftIndex],this.pickUpForksChannels[rightIndex],
                                            this.putDownForksChannels[leftIndex],this.putDownForksChannels[rightIndex],i,
                                            diningPhilosophersParams.eatTime(),diningPhilosophersParams.thinkingTime(),diningPhilosophersParams.cycles(),diningPhilosopherMonitor);
                        }


    }

    /*
    private void initWaiter(DiningPhilosophersParams diningPhilosophersParams)
    {
        this.waiter = new StandardWaiter(this.requestChannel,this.releaseChannel);
        Thread t = new Thread(this.waiter);
        t.start();
    }

     */

    private void initForks(DiningPhilosophersParams diningPhilosophersParams)
    {
        this.forks = new Fork[diningPhilosophersParams.numberOfPhilosophers()];
        IntStream.range(0, diningPhilosophersParams.numberOfPhilosophers())
                .forEach(i ->
                        {
                            int rightIndex = i+diningPhilosophersParams.numberOfPhilosophers();
                            this.forks[i]= new Fork(this.pickUpForksChannels[i],this.putDownForksChannels[i], this.pickUpForksChannels[rightIndex],this.putDownForksChannels[rightIndex],i);
                        }
                );
    }


    private void initForksChannels(DiningPhilosophersParams diningPhilosophersParams)
    {
        this.pickUpForksChannels = new Channel[diningPhilosophersParams.numberOfPhilosophers()*2];
        this.putDownForksChannels = new Channel[diningPhilosophersParams.numberOfPhilosophers()*2];
        IntStream.range(0, diningPhilosophersParams.numberOfPhilosophers()*2)
                .forEach(i ->
                        {
                            this.pickUpForksChannels[i] = new Channel(Integer.valueOf(i).longValue());
                            this.putDownForksChannels[i] = new Channel(Integer.valueOf(i).longValue());
                        }
                );
    }

}
