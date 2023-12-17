package edu.hw10.task1;

import edu.hw10.task1.annotations.Max;
import edu.hw10.task1.annotations.Min;
import edu.hw10.task1.annotations.NotNull;
import java.lang.reflect.InvocationTargetException;
import org.apache.logging.log4j.LogManager;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class RandomObjectGeneratorTest {

    record Person(@Max(120) int age, @Min(value = 100) int height, @NotNull String name) {
    }

    @Test
    void notNullTest() throws InvocationTargetException, InstantiationException, IllegalAccessException {
        RandomObjectGenerator generator = new RandomObjectGenerator();

        Person generatedPerson = (Person) generator.nextObject(Person.class);

        assertThat(generatedPerson.name).isNotNull();
    }

    @Test
    void minTest() throws InvocationTargetException, InstantiationException, IllegalAccessException {
        RandomObjectGenerator generator = new RandomObjectGenerator();

        Person generatedPerson = (Person) generator.nextObject(Person.class);

        assertThat(generatedPerson.height).isGreaterThanOrEqualTo(100);
    }

    @Test
    void maxTest() throws InvocationTargetException, InstantiationException, IllegalAccessException {
        RandomObjectGenerator generator = new RandomObjectGenerator();

        Person generatedPerson = (Person) generator.nextObject(Person.class);

        assertThat(generatedPerson.age).isLessThanOrEqualTo(120);
    }

    @Test
    void fabricMethodTest() throws InvocationTargetException, InstantiationException, IllegalAccessException {
        RandomObjectGenerator generator = new RandomObjectGenerator();

        TestClass testClass = (TestClass) generator.nextObject(TestClass.class, "getTestClass");

        assertThat(testClass).isNotNull();
    }
}
