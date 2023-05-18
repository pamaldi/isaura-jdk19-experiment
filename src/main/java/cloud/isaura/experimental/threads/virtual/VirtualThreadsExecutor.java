package cloud.isaura.experimental.threads.virtual;

import java.util.concurrent.*;

public class VirtualThreadsExecutor
{
    public static int DELAY = 10_000;
    public static int NTASKS = 1_000_000;

    public static void run(String someString) {
        try {
            Thread.sleep((int) (DELAY * Math.random()));
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        System.out.println("Finished "+someString);
    }

    public static void main(String[] args) {
        //ExecutorService exec = Executors.newVirtualThreadPerTaskExecutor();
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 1; i <= NTASKS; i++) {
            String taskname = "task " + i;
            System.out.println("Submitting "+taskname);
            exec.submit(() -> run(taskname));
        }
        exec.close();
    }
}
