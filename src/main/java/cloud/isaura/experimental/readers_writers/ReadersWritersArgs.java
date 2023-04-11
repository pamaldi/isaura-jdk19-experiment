package cloud.isaura.experimental.readers_writers;

public record ReadersWritersArgs(int numberOfReaders, int numberOfWriters, int numberOfMessages,Boolean useVirtualThreads)
{
}
