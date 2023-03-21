package cloud.isaura.experimental.bench;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.All)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
public class BenchConvertLongToString
{

   private final static Long aLong = 234512L;

    @Benchmark
    public void plusOperator()
    {
        String longString = aLong+"";
    }

    @Benchmark
    public void longToString()
    {
        String longString = Long.toString(aLong);
    }

    @Benchmark
    public void stringValueOf()
    {
        String longString = String.valueOf(aLong);
    }

    public static void main(String[] args) throws InterruptedException, RunnerException
    {
        var opt = new OptionsBuilder()
                .include(BenchConvertLongToString.class.getSimpleName())
                .detectJvmArgs()

                .forks(1)
                .build();
        new Runner(opt).run();
    }
}
