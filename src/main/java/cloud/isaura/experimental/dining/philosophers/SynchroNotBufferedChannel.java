package cloud.isaura.experimental.dining.philosophers;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class SynchroNotBufferedChannel
{
    private final BlockingQueue<Boolean> queue = new LinkedBlockingQueue<>(1);

    public Boolean take() {
        try {
            Boolean take = queue.take();
            //System.out.println("Get from queue value "+take);
            return take;
        } catch (InterruptedException e) {
            return null;
        }
    }

    public void put() {
        try {
            Boolean value = Boolean.TRUE;
            //System.out.println("Put in queue value "+ value);
            queue.put(value);
        } catch (InterruptedException e) {

        }
    }
}
