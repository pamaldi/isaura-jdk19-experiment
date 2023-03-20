package cloud.isaura.experimental.text;


import java.io.IOException;
import java.net.URISyntaxException;

//mvn compile exec:java -Dexec.mainClass="cloud.isaura.experimental.text.TokenizerTest" \
public class TokenizerTest
{
    public static void main(String[] args) throws IOException, URISyntaxException
    {
        Tokenizer tokenizer = new Tokenizer();
        TokenizerOption tokenizerOption = new TokenizerOption("spotify_millsongdata.csv", 100);
        long start = System.currentTimeMillis();
        tokenizer.tokens(tokenizerOption);
        long end = System.currentTimeMillis();
        long diff = end - start;
        System.out.println(" elapsed "+diff);
        System.out.println(" number of tokens "+tokenizer.numberOfTokens());


    }
}
