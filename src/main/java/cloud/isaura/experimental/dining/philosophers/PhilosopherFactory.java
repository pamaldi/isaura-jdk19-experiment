package cloud.isaura.experimental.dining.philosophers;

public class PhilosopherFactory
{

    public static Philosopher build(PhilosopherType philosopherType, PhilosopherAttribute philosopherAttribute, SynchroNotBufferedChannel leftChannel, SynchroNotBufferedChannel rightChannel, Integer pos)
    {


        if(philosopherType.equals(PhilosopherType.GREEK))
        {
            StandardPhilosopher standardPhilosopher = new StandardPhilosopher();
            standardPhilosopher.setPhilosopherAttribute(philosopherAttribute);
            standardPhilosopher.setChannelWithLeftFork(leftChannel);
            standardPhilosopher.setChannelWithRightFork(rightChannel);

            return standardPhilosopher;
        }else
        {
            throw  new IllegalArgumentException("Tipologia filosofo non riconosciuta");
        }
    }
}
