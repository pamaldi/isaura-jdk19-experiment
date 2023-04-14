package cloud.isaura.experimental.channels;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public final class Channel  {

    private final Lock lock = new ReentrantLock();
    private final Condition notFull  = lock.newCondition();
    private final Condition notEmpty = lock.newCondition();

    private Object value;


    public void send(Object x) throws InterruptedException {
        lock.lock();
        try {
            if (value != null) {
                notFull.await();
            }
            value = x;
            notEmpty.signal();
        } finally {
            lock.unlock();
        }
    }


    public Object receive() throws InterruptedException {
        lock.lock();
        try {
            if (value == null) {
                notEmpty.await();
            }
            Object x = value;
            value = null;
            notFull.signal();
            return x;
        } finally {
            lock.unlock();
        }
    }
}
