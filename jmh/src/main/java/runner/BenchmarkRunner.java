package runner;

import org.openjdk.jmh.profile.GCProfiler;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import test.Test;


public class BenchmarkRunner {

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(Test.class.getSimpleName())
                .addProfiler(GCProfiler.class)
                //.addProfiler(StackProfiler.class)
                .build();

        new Runner(opt).run();
    }
}