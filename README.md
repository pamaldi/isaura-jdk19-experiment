## Isaura experiment
Some experiment with jdk 19



# Build

An [OpenJDK 19](https://jdk.java.net/19/) or later build is required. At the time of this writing, virtual
threads are a preview feature. That is why `--enable-preview` is provided below.

---
Build with `mvn`:
```shell
mvn compile
```


## JMH

Some experiments in [jmh] (https://github.com/openjdk/jmh).
JMH is a library for benchmarks written in Java and other languages targeting the JVM.

The [BenchReadingTextFile.java](src/main/java/cloud/isaura/experimental/bench/BenchReadingTextFile.java) class
test the number of operations for a simple task: generate tokens for a large sting, using two different methods:
- The method split of the String class
- The StringTokenizer class

In a system with

Available processors (cores): 12
Free memory (bytes): 849800928
Maximum memory (bytes): 4208984064
Total memory available to JVM (bytes): 975175680

the benchmarks between split and tokenizer are the following:

Benchmark                                           Mode      Cnt         Score     Error   Units
BenchReadingTextFile.split                         thrpt        5        ≈ 10⁻³            ops/ns
BenchReadingTextFile.tokenizer                     thrpt        5         2,990 ±   2,214  ops/ns
BenchReadingTextFile.split                          avgt        5      2291,476 ±  41,889   ns/op
BenchReadingTextFile.tokenizer                      avgt        5         0,320 ±   0,044   ns/op

| Benchmark                        | Mode | Cnt   | Score | Units |
|----------------------------------|------|-------| -----  | ---- |
| BenchReadingTextFile.split       | thrpt | 5   |  ≈ 10⁻³  | ops/ns |
| BenchReadingTextFile.tokenizer   | thrpt | 5   |     2,990 | ops/ns |
| BenchReadingTextFile.split       | avgt | 5    |  2291,476  | ns/op |
| BenchReadingTextFile.tokenizer   | avgt | 5    |    0,320 | ns/op |

## JOL

Some experiments in [jol] (https://github.com/openjdk/jol).
JOL is a library that that helps you measure size of objects in java.

The [TokenizerTest.java](src/main/java/cloud/isaura/experimental/text/TokenizerTest.java) class
tokenize and store in an HashMap a dataset of song lyrics.

The jol library output as follows:

| Count                          | Avg | sum   | Description |
|--------------------------------|-----| -----  |-------------|
| 1                              | 524304 | 524304   | [Ljava.util.HashMap$Node;   |

