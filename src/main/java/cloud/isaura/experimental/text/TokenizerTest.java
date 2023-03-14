package cloud.isaura.experimental.text;


import cloud.isaura.experimental.utils.SystemUtils;
import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.info.GraphLayout;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;


public class TokenizerTest
{
    public static void main(String[] args) throws IOException, URISyntaxException
    {
        Tokenizer tokenizer = new Tokenizer();
        TokenizerOption tokenizerOption = new TokenizerOption(TokenizerResource.getResourceFromName("spotify_millsongdata.csv"), ParseFileStrategy.DEFAULT);
        long start = System.currentTimeMillis();
        tokenizer.tokens(tokenizerOption);
        long end = System.currentTimeMillis();
        long diff = end - start;
        System.out.println(" elapsed "+diff);
        SystemUtils.printSystemResource();
        System.out.println(ClassLayout.parseInstance(tokenizer).toPrintable());
        System.out.println(GraphLayout.parseInstance(tokenizer).toFootprint());
        long startToSplit = System.currentTimeMillis();
        FileSplitter.splitBySize(new File("C:\\progetti\\isaura-jdk19-experiment\\src\\main\\resources\\spotify_millsongdata.csv"),5000000);
        long endToSplit = System.currentTimeMillis();
        long diffToSplit = endToSplit - startToSplit;
        System.out.println(" elapsed split "+diffToSplit);
    }
}
