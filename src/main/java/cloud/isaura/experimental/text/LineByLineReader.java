package cloud.isaura.experimental.text;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;

public class LineByLineReader
{
    public void read (URL url, TokenLineParser lineReader) throws IOException
    {
        InputStream inputStream = url.openStream();
        Scanner sc = null;
        try {

            sc = new Scanner(inputStream, "UTF-8");
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                lineReader.accept(line);
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
}
