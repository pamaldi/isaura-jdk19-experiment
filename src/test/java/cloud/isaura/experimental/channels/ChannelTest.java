package cloud.isaura.experimental.channels;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class ChannelTest
{
    /*
    @Test
    public void whenCreateChannelThenInPortAndOutPortAreNotNull()
    {
        Channel channel = new Channel(1L);
        InPort inPort = channel.receiverConnection();
        OutPort outPort = channel.senderConnection();
        assertNotNull(inPort);
        assertNotNull(outPort);
    }

    @Test
    public void when_thread_invoke_receive_and_not_sender_then_blocked()
    {
            Channel channel = new Channel(1L);
            InPort inPort = channel.receiverConnection();
            OutPort outPort = channel.senderConnection();
            assertNotNull(inPort);
            assertNotNull(outPort);

            Thread blockedReceiver = new Thread(() -> {
                 Object receive = inPort.receive();
                 System.out.println("receive " + receive);
            });
            blockedReceiver.start();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            assertEquals(Thread.State.WAITING, blockedReceiver.getState());
            blockedReceiver.interrupt();


    }

    @Test
    public void when_thread_invoke_receive_and_sender_then_blocked()
    {
        Channel channel = new Channel(1L);
        InPort inPort = channel.receiverConnection();
        OutPort outPort = channel.senderConnection();
        assertNotNull(inPort);
        assertNotNull(outPort);

        Thread blockedReceiver = new Thread(() -> {
            Object receive = inPort.receive();
            assertNotNull(receive);
            assertEquals("Hello", receive);
        });
        blockedReceiver.start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertEquals(Thread.State.WAITING, blockedReceiver.getState());

        Thread sender = new Thread(() -> {
            outPort.send("Hello");
        });


        sender.start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertEquals(Thread.State.TERMINATED, blockedReceiver.getState());

    }

     */
}
