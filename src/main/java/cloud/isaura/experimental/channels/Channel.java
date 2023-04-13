package cloud.isaura.experimental.channels;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Channel
{
    protected boolean senderOk = false, receiverOk = false;
    protected Object message;
    protected boolean senderConnected = false, receiverConnected = false;

    private final Lock lock = new ReentrantLock();
    private final Condition notReceiver = lock.newCondition();
    private final Condition notSender = lock.newCondition();

    private final Long id;

    public Channel(Long id)
    {
        this.id = id;
    }


    private InputPort ip = new InputPort();
    private OutputPort op = new OutputPort();

    private class InputPort implements InPort
    {
        public Object receive()
        {
            lock.lock();
            Object msg;
            receiverOk = true;
            while (!senderOk)
                try
                {
                    //System.out.println(Thread.currentThread()+" Receiver  waiting for sender on channel " + id);
                    notSender.await();
                } catch (InterruptedException e)
                {
                }
            //System.out.println("Receiver  received message on channel " + id);
            msg = message;
            senderOk = false;
            receiverOk = false;
            notReceiver.signal();
            lock.unlock();
            return msg;

        }//receive
    }//InputPort

    private class OutputPort implements OutPort
    {
        public void send(Object msg)
        {
            lock.lock();
            message = msg;
            senderOk = true;
            if (receiverOk)
            {
                notSender.signal();
            }
            while (senderOk)
                try
                {
                    //System.out.println("Sender with message" + msg  + " waiting for receiver on channel " + id);
                    notReceiver.await();
                } catch (InterruptedException e)
                {
                }
            lock.unlock();

        }
    }

    public OutPort senderConnection()
    {
        lock.lock();
        if (senderConnected) throw new RuntimeException("Sender already connected");
        senderConnected = true;
        lock.unlock();
        return op;
    }

    public  InPort receiverConnection()
    {
        lock.lock();
        if (receiverConnected) throw new RuntimeException("Receiver already connected!");
        receiverConnected = true;
        lock.unlock();
        return ip;
    }

    public Long getId()
    {
        return id;
    }

    @Override
    public String toString()
    {
        return "Channel{" +
                "id=" + id +
                '}';
    }
}
