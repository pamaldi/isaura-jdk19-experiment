package cloud.isaura.experimental.text;

import javax.sound.sampled.Line;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class LineByLineReader
{
    public void read (String fileName, LineReader lineReader) throws IOException
    {
        FileInputStream inputStream = null;
        Scanner sc = null;
        try {
            inputStream = new FileInputStream(fileName);
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
