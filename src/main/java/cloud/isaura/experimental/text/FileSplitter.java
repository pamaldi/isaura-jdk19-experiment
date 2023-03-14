package cloud.isaura.experimental.text;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class FileSplitter
{
    public static List<File> splitBySize(File largeFile, int maxChunkSize) throws IOException
    {
        List<File> list = new ArrayList<>();
        try (InputStream in = Files.newInputStream(largeFile.toPath())) {
            final byte[] buffer = new byte[maxChunkSize];
            int dataRead = in.read(buffer);
            while (dataRead > -1) {
                File fileChunk = stageFile(buffer, dataRead);
                list.add(fileChunk);
                dataRead = in.read(buffer);
            }
        }
        return list;
    }

    private static File stageFile(byte[] buffer, int length) throws IOException {
        File outPutFile = File.createTempFile("temp-", "-split", new File("C:\\progetti\\isaura-jdk19-experiment\\src\\main\\resources"));
        try(FileOutputStream fos = new FileOutputStream(outPutFile)) {
            fos.write(buffer, 0, length);
        }
        return outPutFile;
    }
}
