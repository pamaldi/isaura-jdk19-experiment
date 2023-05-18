package cloud.isaura.experimental.threads.virtual;

public class NumberService
{
    public static Boolean isPrime(long n)
    {
      boolean ret = Boolean.TRUE;
      for(int i = 2 ; i<=n/2; i++)
      {
          if (n % i == 0) {
              ret = Boolean.FALSE;
              break;
          }
      }
      return ret;
    }


    public static Long findNthPrime(int nth)
    {
        int count = 1; long num =1;
        while(count < nth)
        {
            num = num+1;
            //System.out.println("count "+count+" num "+num);
            Boolean isPrime = isPrime(num);
            //System.out.println("isPrime "+num+" ? "+isPrime);
            if(isPrime)
            {
                count++;
            }
        }
        return num;
    }
}
