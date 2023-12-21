package test;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.*;
import org.openjdk.jmh.infra.Blackhole;

import java.util.concurrent.TimeUnit;

public class Test {

    @Benchmark
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @BenchmarkMode(Mode.AverageTime)
//    @Fork(value = 1, warmups = 0)
//    @Measurement(iterations = 2)
//    @Warmup(iterations = 1)
    public void testMethod (Blackhole bh) {
         bh.consume(new Object());
    }


    @Benchmark
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @BenchmarkMode(Mode.AverageTime)
    public double  test1() {
        int x  = 7;
        return Math.log(x);
    }

    @State(Scope.Benchmark)
    public static class Log {
        public int x =7;
    }
    @Benchmark
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @BenchmarkMode(Mode.AverageTime)
    public double  test2(Log x) {

        return Math.log(x.x);
    }
}
