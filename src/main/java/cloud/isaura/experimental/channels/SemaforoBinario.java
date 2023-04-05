package cloud.isaura.experimental.channels;

public class SemaforoBinario
{
    private boolean flag = false;
    public synchronized void P()
    {
        while (flag)
        {
            try
            {
                wait();
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
        flag = true;
    }
    public synchronized void V()
    {
        flag = false;
        notify();
    }

}
