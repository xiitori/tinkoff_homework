package edu.hw4.validate;

import edu.hw4.Animal;
import java.util.HashSet;
import java.util.Set;

public class AnimalValidator {

    private AnimalValidator() {
    }

    private static final int MAX_WEIGHT = 200000;

    private static final int MAX_HEIGHT = 3300;

    private static final int MAX_AGE = 250;

    public static Set<ValidationError> validateAnimal(Animal animal) {
        Set<ValidationError> set = new HashSet<>();
        if (animal.type() == null || animal.name() == null || animal.sex() == null) {
            set.add(ValidationError.NULL_FIELD);
        }

        int weight = animal.weight();
        if (weight < 0 || weight > MAX_WEIGHT) {
            set.add(ValidationError.INCORRECT_WEIGHT);
        }

        int height = animal.height();
        if (height < 0 || height > MAX_HEIGHT) {
            set.add(ValidationError.INCORRECT_HEIGHT);
        }

        int age = animal.age();
        if (age < 0 || age > MAX_AGE) {
            set.add(ValidationError.INCORRECT_AGE);
        }

        return set;
    }
}
