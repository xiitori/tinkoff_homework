package edu.project5;

import java.lang.invoke.LambdaMetafactory;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@State(Scope.Benchmark)
public class StudentBenchmark {

    private static final Logger LOGGER = LogManager.getLogger();

    public static void main(String[] args) throws RunnerException {
        Options options = new OptionsBuilder()
            .include(StudentBenchmark.class.getSimpleName())
            .forks(1)
            .build();

        new Runner(options).run();
    }
    public record Student(String name, String surname) {
    }

    private Student student;
    private Method method;
    private MethodHandle methodHandle;
    private LambdaNameGetter getter;

    @Setup
    public void setup() {
        try {
            method = Student.class.getMethod("name");
        } catch (Throwable e) {
            LOGGER.info(e);
        }

        try {
            MethodHandles.Lookup lookup = MethodHandles.lookup();
            methodHandle = lookup.findVirtual(Student.class, "name", MethodType.methodType(String.class));
        } catch (Throwable e) {
            LOGGER.info(e);
        }

        try {
            var lookup = MethodHandles.lookup();
            var methodType = MethodType.methodType(LambdaNameGetter.class);
            var interfaceMethodType = MethodType.methodType(String.class, Student.class);
            var implementation = lookup.findVirtual(Student.class, "name", MethodType.methodType(String.class));
            var dynamic = MethodType.methodType(String.class, Student.class);

            getter = (LambdaNameGetter) LambdaMetafactory.metafactory(
                lookup,
                "getName",
                methodType,
                interfaceMethodType,
                implementation,
                dynamic
            ).getTarget().invokeExact();
        } catch (Throwable e) {
            LOGGER.info(e);
        }

        student = new Student("Nikola", "Tesla");
    }

    @Benchmark
    public void directAccess(Blackhole bh) {
        String name = student.name();
        bh.consume(name);
    }

    @Benchmark
    public void reflectMethod(Blackhole bh) throws Exception {
        String name = (String) method.invoke(student);
        bh.consume(name);
    }

    @Benchmark
    public void methodHandles(Blackhole bh) throws Throwable {
        String name = (String) methodHandle.invoke(student);
        bh.consume(name);

    }

    @Benchmark
    public void lambdaMetaFactory(Blackhole bh) {
        String name = getter.getName(student);
        bh.consume(name);
    }
}
