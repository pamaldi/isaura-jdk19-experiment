package cloud.isaura.experimental.text;

import java.net.URL;

public record TokenizerOption(
        URL url,
        ParseFileStrategy parseFileStrategy
)
{

}
