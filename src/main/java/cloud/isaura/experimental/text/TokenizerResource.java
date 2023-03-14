package cloud.isaura.experimental.text;

import java.net.URL;

public class TokenizerResource
{
    public static URL getResourceFromName(String resourceName)
    {
        ClassLoader classLoader = TokenizerTest.class.getClassLoader();
        URL resource = classLoader.getResource("spotify_millsongdata.csv");
        return resource;
    }
}
