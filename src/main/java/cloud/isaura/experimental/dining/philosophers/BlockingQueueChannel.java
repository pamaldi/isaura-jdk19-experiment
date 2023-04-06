package cloud.isaura.experimental.dining.philosophers;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class BlockingQueueChannel
{
    private BlockingQueue<Integer> queue = null;

    public BlockingQueueChannel(int size) {
        this.queue = new LinkedBlockingQueue<>(size);
    }


    public Integer receive() {
        try {
            Integer take = queue.take();
            System.out.println("Get from queue value "+take);
            return take;
        } catch (InterruptedException e) {
            return null;
        }
    }

    public void send(Integer pos) {
        try {
            System.out.println("Send in queue value "+pos);
            queue.put(pos);
        } catch (InterruptedException e) {
            // abort
        }
    }
}
