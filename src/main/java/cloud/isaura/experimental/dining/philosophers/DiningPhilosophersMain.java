package cloud.isaura.experimental.dining.philosophers;

public class DiningPhilosophersMain
{



    public static void main(String[] args)
    {

        DiningPhilosophersParams diningPhilosophersParams = new DiningPhilosophersParams(PhilosopherType.GREEK,80000,1000L,1000L,10);
        DiningPhilosophers diningPhilosophers = new DiningPhilosophers();
        diningPhilosophers.agorazein(diningPhilosophersParams);

    }
}
