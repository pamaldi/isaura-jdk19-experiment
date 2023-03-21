package cloud.isaura.experimental.dining.philosophers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class DiningPhilosophers
{
    private Philosopher[] philosophers;

    private Channel[] channels;

    public void agorazein(DiningPhilosophersParams diningPhilosophersParams)
    {
        Integer numberOfPhilosophers = diningPhilosophersParams.numberOfPhilosophers();
        this.philosophers= new Philosopher[numberOfPhilosophers];
        this.channels = new Channel[numberOfPhilosophers];
        IntStream.range(0,numberOfPhilosophers)
                .forEach(
                        i -> this.channels[i] = new Channel(i)
                );
        PhilosopherAttribute philosopherAttribute = new PhilosopherAttribute(diningPhilosophersParams.eatTime(), diningPhilosophersParams.thinkingTime());
        IntStream.range(0,numberOfPhilosophers)
                .forEach(i ->
                    {
                        this.philosophers[i]= PhilosopherFactory.build(diningPhilosophersParams.philosopherType(),philosopherAttribute,this.channels[i%numberOfPhilosophers], this.channels[(i+1)%numberOfPhilosophers],i);
                        Thread t = new Thread(this.philosophers[i]);
                        t.start();
                    }
                );

    }

}
