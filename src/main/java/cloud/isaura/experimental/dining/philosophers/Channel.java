package cloud.isaura.experimental.dining.philosophers;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Channel
{
    private Boolean taken;

    private final Integer pos;

    public Channel(Integer pos)
    {
        this.taken = Boolean.FALSE;
        this.pos=pos;
    }

    public synchronized Boolean take() {
        if(taken)
        {
            return false;
        }else{
            this.taken=true;
            return true;
        }
    }

    public  synchronized void put() {
       this.taken=false;
    }

    public Integer getPos()
    {
        return pos;
    }

    @Override
    public String toString()
    {
        return "Channel{" +
                "taken=" + taken +
                ", pos=" + pos +
                '}';
    }
}
