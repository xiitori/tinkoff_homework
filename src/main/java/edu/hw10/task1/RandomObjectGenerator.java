package edu.hw10.task1;

import edu.hw10.task1.generators.ArgumentGenerator;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class RandomObjectGenerator {
    public RandomObjectGenerator() {

    }

    public Object nextObject(Class<?> clazz, String methodName) {
        Method fabricMethod = Arrays.stream(clazz.getDeclaredMethods()).filter(
                method -> method.getName().equals(methodName) && method.getReturnType().equals(clazz))
            .findAny().orElseThrow(NoSuchMethodError::new);

        var parameters = generateParameters(fabricMethod.getParameters());
        try {
            return fabricMethod.invoke(clazz, parameters);
        } catch (InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public Object nextObject(Class<?> clazz)
        throws InvocationTargetException, InstantiationException, IllegalAccessException {
        Constructor<?>[] constructors = clazz.getDeclaredConstructors();

        if (constructors.length == 0) {
            throw new NoSuchMethodError();
        }

        int random = ThreadLocalRandom.current().nextInt(constructors.length);
        Constructor<?> constructor = constructors[random];
        constructor.setAccessible(true);

        var parameters = generateParameters(constructor.getParameters());
        return constructor.newInstance(parameters);
    }

    private Object[] generateParameters(Parameter[] parameters) {
        List<Object> generatedParameters = new ArrayList<>();
        for (var parameter : parameters) {
            var annotations = parameter.getAnnotations();
            Class<?> type = parameter.getType();
            ArgumentGenerator generator = ArgumentGenerator.getGenerator(type);
            generatedParameters.add(generator.generate(annotations));
        }

        return generatedParameters.toArray();
    }
}
