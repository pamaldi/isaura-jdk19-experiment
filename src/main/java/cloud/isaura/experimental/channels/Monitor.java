package cloud.isaura.experimental.channels;

public class Monitor
{
    private SemaforoBinario mutex = new SemaforoBinario();


    public void Enter()
    {
        mutex.P();
    }//Enter

    public void Exit()
    {

        mutex.V();
    }

    public Condition newCondition()
    {
        return new ConditionVariable();
    }

    private class ConditionVariable implements Condition
    {
        private SemaforoBinario xsem = new SemaforoBinario();
        private int xcount = 0;

        public void Wait()
        {
            xcount++;
            mutex.V();
            xsem.P();
            xcount--;
        }//Wait

        public void Signal()
        {
            if (xcount > 0)
            {

                xsem.V();


            }
        }
    }//Signal

}
