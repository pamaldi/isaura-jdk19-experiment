package cloud.isaura.experimental.text;



import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class LineByLineReader
{

    private final String fileName;

    private final Channel<String> channel;

    private final Channel<Boolean> close;

    public LineByLineReader(String fileName, Channel<String> channel, Channel<Boolean> close)
    {
        this.fileName = fileName;
        this.channel = channel;
        this.close=close;
    }

    public void read () throws IOException
    {
        InputStream inputStream =  new FileInputStream(fileName);
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
            System.out.println("send close"+Thread.currentThread());
            this.close.put(Boolean.TRUE);
        }

    }

    public void run() {
        System.out.println("Start virtual thread "+Thread.currentThread());
        try
        {
            read();
        } catch (IOException e)
        {
            throw new RuntimeException(e);
        }
        System.out.println("End virtual thread "+Thread.currentThread());
    }

    void start() {
        Thread.startVirtualThread(this::run);
    }
}
