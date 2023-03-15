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
    public static List<File> splitBySize(InputStream in, int numberOfFile, String dir) throws IOException
    {
        Integer maxChunkSize = 0;
        Integer size = FileUtils.getSize(in);
        Integer standardChunkSize = size /numberOfFile;
        Integer currentChunked = 0;
        List<File> list = new ArrayList<>();
        for(int i = 0; i < numberOfFile; i++)
        {
            boolean isLast = i == numberOfFile - 1;
            int remain = size - currentChunked;
            maxChunkSize= isLast ?  remain :standardChunkSize;
            currentChunked=currentChunked+maxChunkSize;
            final byte[] buffer = new byte[maxChunkSize];
            int dataRead = in.read(buffer);
            File fileChunk = stageFile(buffer, dataRead, dir);
            list.add(fileChunk);
            dataRead = in.read(buffer);


        }

        return list;
    }

    private static File stageFile(byte[] buffer, int length, String dir) throws IOException {
        File outPutFile = File.createTempFile("temp-", "-split", new File(dir));
        try(FileOutputStream fos = new FileOutputStream(outPutFile)) {
            fos.write(buffer, 0, length);
        }
        return outPutFile;
    }
}
