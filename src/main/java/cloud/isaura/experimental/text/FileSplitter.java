package cloud.isaura.experimental.text;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class FileSplitter
{
    public static List<File> splitBySize(InputStream in, int numberOfFiles, String dir) throws IOException
    {
        Integer maxChunkSize = 0;
        Integer sizeOfFile = FileUtils.getSize(in);
        Integer standardChunkSize = sizeOfFile/numberOfFiles;
        Integer currentChunked = 0;
        List<File> list = new ArrayList<>();
        for(int i = 0; i < numberOfFiles; i++)
        {
            boolean isLast = (i == (numberOfFiles - 1));
            int toBeWritten = sizeOfFile - currentChunked;
            maxChunkSize= isLast ?  toBeWritten :standardChunkSize;
            currentChunked= currentChunked+maxChunkSize;
            final byte[] buffer = new byte[maxChunkSize];
            int dataRead = in.read(buffer);
            File fileChunk = stageFile(buffer, dataRead, dir);
            list.add(fileChunk);
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
