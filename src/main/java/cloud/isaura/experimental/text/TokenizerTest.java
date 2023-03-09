package cloud.isaura.experimental.text;


import java.io.IOException;

public class TokenizerTest
{
    public static void main(String[] args) throws IOException
    {
        Tokenizer tokenizer = new Tokenizer();
        TokenizerOption tokenizerOption = new TokenizerOption("/mnt/localdisk/progetti/experimental/src/main/resources/data/text/archive/spotify_millsongdata.csv", ParseFileStrategy.DEFAULT);
        long start = System.currentTimeMillis();
        tokenizer.tokens(tokenizerOption);
        long end = System.currentTimeMillis();
        long diff = end - start;
        System.out.println(" elapsed "+diff);
    }
}
