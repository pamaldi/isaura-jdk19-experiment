package cloud.isaura.experimental.text;


import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.info.GraphLayout;

import java.io.IOException;
import java.net.URISyntaxException;

//mvn compile exec:java -Dexec.mainClass="cloud.isaura.experimental.text.TokenizerTest" \
public class TokenizerTest
{
    public static void main(String[] args) throws IOException, URISyntaxException
    {
        Tokenizer tokenizer = new Tokenizer();
        TokenizerOption tokenizerOption = new TokenizerOption(FileUtils.getFileAsIOStream("spotify_millsongdata.csv"), 4);
        long start = System.currentTimeMillis();
        tokenizer.tokens(tokenizerOption);
        long end = System.currentTimeMillis();
        long diff = end - start;
        System.out.println(" elapsed "+diff);
        System.out.println(" number of tokens "+tokenizer.numberOfTokens());


    }
}
