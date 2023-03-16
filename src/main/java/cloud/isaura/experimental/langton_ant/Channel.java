package cloud.isaura.experimental.langton_ant;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Channel<T> {
    private final BlockingQueue<T> queue = new LinkedBlockingQueue<>();

    public T take() {
        try {
            T take = queue.take();
            System.out.println("Get from queue value "+take);
            return take;
        } catch (InterruptedException e) {
            return null;
        }
    }

    public void put(T value) {
        try {
            System.out.println("Put in queue value "+value);
            queue.put(value);
        } catch (InterruptedException e) {
            // abort
        }
    }
}
