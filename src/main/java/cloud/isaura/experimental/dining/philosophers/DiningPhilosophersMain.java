package cloud.isaura.experimental.dining.philosophers;

public class DiningPhilosophersMain
{



    public static void main(String[] args)
    {

        DiningPhilosophersParams diningPhilosophersParams = new DiningPhilosophersParams(PhilosopherType.GREEK,1000,2000L,1000L,5);
        DiningPhilosophers diningPhilosophers = new DiningPhilosophers();
        diningPhilosophers.agorazein(diningPhilosophersParams);

    }
}
