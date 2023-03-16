package cloud.isaura.experimental.text;

import java.io.FileNotFoundException;
import java.net.URISyntaxException;

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
