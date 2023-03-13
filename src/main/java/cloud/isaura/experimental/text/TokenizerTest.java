package cloud.isaura.experimental.text;


import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.info.GraphLayout;
import org.openjdk.jol.vm.VM;

import java.io.IOException;

public class TokenizerTest
{
    public static void main(String[] args) throws IOException
    {
        Tokenizer tokenizer = new Tokenizer();
        TokenizerOption tokenizerOption = new TokenizerOption("C:\\progetti\\isaura-jdk19-experiment\\src\\main\\resources\\data\\text\\archive\\spotify_millsongdata.csv", ParseFileStrategy.DEFAULT);
        long start = System.currentTimeMillis();
        tokenizer.tokens(tokenizerOption);
        long end = System.currentTimeMillis();
        long diff = end - start;
        System.out.println(" elapsed "+diff);
        System.out.println(VM.current().details());
        System.out.println(ClassLayout.parseInstance(tokenizer).toPrintable());
        System.out.println(GraphLayout.parseInstance(tokenizer).toFootprint());
    }
}
