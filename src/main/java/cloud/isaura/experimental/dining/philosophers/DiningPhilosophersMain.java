package cloud.isaura.experimental.dining.philosophers;

public class DiningPhilosophersMain
{



    public static void main(String[] args)
    {

        DiningPhilosophersParams diningPhilosophersParams = new DiningPhilosophersParams(PhilosopherType.GERMAN,1000000,4000L,1000L,100);
        DiningPhilosophers diningPhilosophers = new DiningPhilosophers();
        diningPhilosophers.agorazein(diningPhilosophersParams);

    }
}
