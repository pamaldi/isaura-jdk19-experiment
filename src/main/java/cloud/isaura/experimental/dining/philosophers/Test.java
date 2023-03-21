package cloud.isaura.experimental.dining.philosophers;

public class Test
{

    public static void main(String[] args)
    {
        int i = 5;
        for(int k = 0; k < i; k++)
        {
            System.out.println(" k1 "+(k%i)+" k2 "+((k+1)%i));
        }
    }
}
