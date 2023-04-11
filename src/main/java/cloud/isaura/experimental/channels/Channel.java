package cloud.isaura.experimental.channels;

public class Channel
{
    protected boolean senderOk = false, receiverOk = false;
    protected Object message;
    protected boolean senderConnected = false, receiverConnected = false;

    private final Long id;

    public Channel(Long id) {
        this.id = id;
    }


    private InputPort ip = new InputPort();
    private OutputPort op = new OutputPort();

    private class InputPort implements InPort
    {
        public Object receive()
        {
            synchronized (Channel.this)
            {

                Object msg;
                receiverOk = true;
                while (!senderOk)
                    try
                    {
                        //System.out.println(Thread.currentThread()+" Receiver  waiting for sender on channel " + id);
                        Channel.this.wait();
                    } catch (InterruptedException e)
                    {
                    }
                //System.out.println("Receiver  received message on channel " + id);
                msg = message;
                senderOk = false;
                receiverOk = false;
                Channel.this.notify();
                return msg;
            }
        }//receive
    }//InputPort

    private class OutputPort implements OutPort
    {
        public void send(Object msg)
        {
            synchronized (Channel.this)
            {

                message = msg;
                senderOk = true;
                if (receiverOk) Channel.this.notify();
                while (senderOk)
                    try
                    {
                        //System.out.println("Sender with message" + msg  + " waiting for receiver on channel " + id);
                        Channel.this.wait();
                    } catch (InterruptedException e)
                    {
                    }
            }
        }
    }

    public synchronized OutPort senderConnection(){
        if( senderConnected ) throw new RuntimeException("Sender already connected");
        senderConnected=true;
        return op;
    }
    public synchronized InPort receiverConnection(){
        if( receiverConnected ) throw new RuntimeException("Receiver already connected!");
        receiverConnected=true;
        return ip;
    }

    public Long getId() {
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
