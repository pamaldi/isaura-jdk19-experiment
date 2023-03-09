package cloud.isaura.experimental.bench;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.StringTokenizer;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.All)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
public class BenchReadingTextFile
{

    private final static String TEXT = "Once upon a midnight dreary, while I pondered, weak and weary,\n" +
            "Over many a quaint and curious volume of forgotten lore—\n" +
            "While I nodded, nearly napping, suddenly there came a tapping,\n" +
            "As of some one gently rapping, rapping at my chamber door—\n" +
            "\"'Tis some visitor,\" I muttered, \"tapping at my chamber door—\n" +
            "               Only this and nothing more.\"\n" +
            "\n" +
            "Ah, distinctly I remember it was in the bleak December;\n" +
            "And each separate dying ember wrought its ghost upon the floor.\n" +
            "Eagerly I wished the morrow;—vainly I had sought to borrow\n" +
            "From my books surcease of sorrow—sorrow for the lost Lenore—\n" +
            "For the rare and radiant maiden whom the angels name Lenore—\n" +
            "               Nameless here for evermore.";

    @Benchmark
    public void split()
    {
        String[] splitS = TEXT.split(" ");
    }

    @Benchmark
    public void tokenizer()
    {
        StringTokenizer sTokenize = new StringTokenizer(TEXT," ");
    }

    public static void main(String[] args) throws InterruptedException, RunnerException
    {
        var opt = new OptionsBuilder()
                .include(BenchReadingTextFile.class.getSimpleName())
                .detectJvmArgs()

                .forks(1)
                .build();
        new Runner(opt).run();
    }
}
