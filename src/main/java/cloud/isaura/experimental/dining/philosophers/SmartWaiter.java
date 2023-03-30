package cloud.isaura.experimental.dining.philosophers;

import java.util.List;

public class SmartWaiter implements Waiter
{

    private final List<SynchroNotBufferedChannel> channels;

    public SmartWaiter(List<SynchroNotBufferedChannel> channels)
    {
        this.channels = channels;
    }

    @Override
    public void ensurePleasantDinner()
    {

    }
}
