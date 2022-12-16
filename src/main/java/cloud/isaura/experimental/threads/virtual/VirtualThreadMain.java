package cloud.isaura.experimental.threads.virtual;

public class VirtualThreadMain
{

    public static void main(String[] args) throws InterruptedException {
        var vthread = Thread.ofVirtual().start(() -> {
            System.out.println("Hello World from " + Thread.currentThread());
        });
        vthread.join();
    }


}
