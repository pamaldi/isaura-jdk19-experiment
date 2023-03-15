package cloud.isaura.experimental.text;

import java.io.InputStream;
import java.net.URL;

public record TokenizerOption(
        InputStream is,
        Integer numberOfReader
)
{

}
