package cloud.isaura.experimental.threads.virtual;

import java.util.concurrent.*;

public class CompletableFutureExample
{


    public static CompletableFuture<Long> getNPrime(int n)
    {

        return CompletableFuture.supplyAsync(() -> NumberService.findNthPrime(n));
    }

    public static void main(String[] args)
    {
        Future<Long> nPrime = getNPrime(100000);
        try
        {
            long result  = nPrime.get(100, TimeUnit.SECONDS);
            System.out.println("result "+result);
        }catch(InterruptedException | ExecutionException | TimeoutException ie)
        {
            nPrime.cancel(true);
            ie.printStackTrace();

        }
    }
}
