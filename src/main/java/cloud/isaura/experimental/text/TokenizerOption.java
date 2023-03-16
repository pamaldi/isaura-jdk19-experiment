package cloud.isaura.experimental.text;

import java.io.InputStream;

public record TokenizerOption(
        InputStream is,
        Integer numberOfReader
)
{

}
