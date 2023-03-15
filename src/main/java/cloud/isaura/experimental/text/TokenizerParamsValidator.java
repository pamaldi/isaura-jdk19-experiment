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
        if(tokenizerOption.is()==null)
        {
            throw new IllegalArgumentException("Resource is mandatory");
        }

    }

}
