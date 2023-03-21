package cloud.isaura.experimental.dining.philosophers;

public class PhilosopherFactory
{

    public static Philosopher build(PhilosopherType philosopherType, PhilosopherAttribute philosopherAttribute, Channel left, Channel right, Integer pos)
    {


        if(philosopherType.equals(PhilosopherType.GREEK))
        {
            StandardPhilosopher standardPhilosopher = new StandardPhilosopher();
            standardPhilosopher.setPhilosopherAttribute(philosopherAttribute);
            standardPhilosopher.setChannelLeft(left);
            standardPhilosopher.setChannelRight(right);
            standardPhilosopher.setPos(pos);
            return standardPhilosopher;
        }else
        {
            throw  new IllegalArgumentException("Tipologia filosofo non riconosciuta");
        }
    }
}
