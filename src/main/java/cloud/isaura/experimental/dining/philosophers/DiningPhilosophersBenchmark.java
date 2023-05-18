package cloud.isaura.experimental.dining.philosophers;

import java.util.concurrent.TimeUnit;


import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.OptionsBuilder;

@State(Scope.Benchmark)
@Warmup(iterations = 5)
@Measurement(iterations = 10)
@OutputTimeUnit(TimeUnit.SECONDS)
@Fork(2)
public class DiningPhilosophersBenchmark
{

    private DiningPhilosophers diningPhilosophers;




    @Benchmark
    @BenchmarkMode(Mode.Throughput)
    public void benchmarkGreek() {
        DiningPhilosophersParams diningPhilosophersParams = new DiningPhilosophersParams(PhilosopherType.GREEK,5,2000L,1000L,1);
        this.diningPhilosophers = new DiningPhilosophers();
        this.diningPhilosophers.agorazein(diningPhilosophersParams);
    }

    public static void main(String[] args) throws InterruptedException, RunnerException
    {
        var opt = new OptionsBuilder()
                .include(DiningPhilosophersBenchmark.class.getSimpleName())
                .detectJvmArgs()
                .build();
        new Runner(opt).run();
    }
}
