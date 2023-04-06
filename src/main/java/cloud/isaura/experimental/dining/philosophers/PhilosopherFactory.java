package cloud.isaura.experimental.dining.philosophers;

import cloud.isaura.experimental.channels.Channel;

public class PhilosopherFactory
{

    public static Philosopher build(PhilosopherType philosopherType, PhilosopherAttribute philosopherAttribute, BlockingQueueChannel waiterChannel, BlockingQueueChannel waiterChannelRelease, Integer pos)
    {


        if(philosopherType.equals(PhilosopherType.GREEK))
        {
            StandardPhilosopher standardPhilosopher = new StandardPhilosopher();
            standardPhilosopher.setPhilosopherAttribute(philosopherAttribute);
            standardPhilosopher.setChannelRequestWaiter(waiterChannel);
            standardPhilosopher.setChannelReleaseWaiter(waiterChannelRelease);
            standardPhilosopher.setPos(pos);

            return standardPhilosopher;
        }else
        {
            throw  new IllegalArgumentException("Tipologia filosofo non riconosciuta");
        }
    }
}
