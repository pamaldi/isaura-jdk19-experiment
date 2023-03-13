package cloud.isaura.experimental.text;


import cloud.isaura.experimental.utils.SystemUtils;
import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.info.GraphLayout;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

public class TokenizerTest
{
    public static void main(String[] args) throws IOException, URISyntaxException
    {
        Tokenizer tokenizer = new Tokenizer();
        ClassLoader classLoader = TokenizerTest.class.getClassLoader();
        URL resource = classLoader.getResource("spotify_millsongdata.csv");
        TokenizerOption tokenizerOption = new TokenizerOption(resource, ParseFileStrategy.DEFAULT);
        long start = System.currentTimeMillis();
        tokenizer.tokens(tokenizerOption);
        long end = System.currentTimeMillis();
        long diff = end - start;
        System.out.println(" elapsed "+diff);
        SystemUtils.printSystemResource();
        System.out.println(ClassLayout.parseInstance(tokenizer).toPrintable());
        System.out.println(GraphLayout.parseInstance(tokenizer).toFootprint());

    }
}
