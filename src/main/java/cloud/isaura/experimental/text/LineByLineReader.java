package cloud.isaura.experimental.text;


import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class LineByLineReader
{

    private final String fileName;

    private final Channel<String> channel;


    public LineByLineReader(String fileName, Channel<String> channel)
    {
        this.fileName = fileName;
        this.channel = channel;
    }

    public void read () throws IOException
    {
        InputStream inputStream =  FileUtils.getFileAsIOStream(fileName);
        Scanner sc = null;

        try {

            sc = new Scanner(inputStream, "UTF-8");
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                this.channel.put(line);
            }

            if (sc.ioException() != null) {
                throw sc.ioException();
            }
        } catch (IOException e)
        {
            throw new RuntimeException(e);
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
            if (sc != null) {
                sc.close();
            }

        }

    }

    private void run() {
        System.out.println("Line by line reader : Start virtual thread "+Thread.currentThread());
        try
        {
            read();
        } catch (IOException e)
        {
            throw new RuntimeException(e);
        }
        System.out.println("Line by line reader : End virtual thread "+Thread.currentThread());
    }

    public void start() {
        Thread.startVirtualThread(this::run);
    }
}
