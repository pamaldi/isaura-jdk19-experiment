package cloud.isaura.experimental.text;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TokenizerParamsValidator
{
    public void isValid(TokenizerOption tokenizerOption) throws FileNotFoundException, URISyntaxException
    {
        if(tokenizerOption.url()==null)
        {
            throw new IllegalArgumentException("Resource is mandatory");
        }

        File file = new File(tokenizerOption.url().toURI());
        Path path = Paths.get(file.getAbsolutePath());
        boolean exists = Files.exists(path);
        if(!exists)
        {
            throw new FileNotFoundException("File does not exists");
        }
    }

}
