package cloud.isaura.experimental.readers_writers;

public class ReadersAndWriters
{
    public static void main(String[] args)
    {
        ReadersWritersArgs readersWritersArgs = new ReadersWritersArgs(10, 10, 10, true);
        ReadersAndWritersOrchestra readersAndWritersOrchestra = new ReadersAndWritersOrchestra(readersWritersArgs);
        readersAndWritersOrchestra.orchestrate();

    }
}
