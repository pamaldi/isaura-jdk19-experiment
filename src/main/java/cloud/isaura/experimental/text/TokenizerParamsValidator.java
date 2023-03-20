package cloud.isaura.experimental.text;

import java.io.FileNotFoundException;
import java.net.URISyntaxException;

public class TokenizerParamsValidator
{
    public void isValid(TokenizerOption tokenizerOption) throws FileNotFoundException, URISyntaxException
    {
        if(tokenizerOption.fileName()==null || tokenizerOption.fileName().isEmpty())
        {
            throw new IllegalArgumentException("File is mandatory");
        }

        if(tokenizerOption.numberOfReader() == null || tokenizerOption.numberOfReader()==0)
        {
            throw new IllegalArgumentException("Number of readers > 0");
        }


    }

}
