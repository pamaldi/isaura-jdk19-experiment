package cloud.isaura.experimental.text;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class FileUtils
{
    public static InputStream getFileAsIOStream(final String fileName)
    {
        InputStream ioStream = FileUtils.class
                .getClassLoader()
                .getResourceAsStream(fileName);

        if (ioStream == null) {
            throw new IllegalArgumentException(fileName + " is not found");
        }
        return ioStream;
    }

    public static String getResourcePath()
    {
        String path = "src/main/resources";

        File file = new File(path);
        String absolutePath = file.getAbsolutePath();

        return absolutePath;
    }


    public static Integer getSize(InputStream is) throws IOException
    {
        return is.available();
    }
}
