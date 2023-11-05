package edu.hw4;

import edu.hw4.validate.ValidationError;
import org.junit.jupiter.api.Test;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import static edu.hw4.validate.ValidationError.INCORRECT_AGE;
import static edu.hw4.validate.ValidationError.INCORRECT_HEIGHT;
import static edu.hw4.validate.ValidationError.INCORRECT_WEIGHT;
import static edu.hw4.validate.ValidationError.NULL_FIELD;
import static org.assertj.core.api.Assertions.assertThat;

public class Task20Test {

    private static final List<Animal> ANIMALS = List.of(
        new Animal("barsik", Animal.Type.CAT, Animal.Sex.M, 3, 25000, 2, true),
        new Animal("xatiko", Animal.Type.DOG, Animal.Sex.M, 4, 40, 10, true),
        new Animal("kolibri", Animal.Type.BIRD, null, 2, 5, 1, false),
        new Animal("kambala", Animal.Type.FISH, Animal.Sex.M, 40, 55, 600000, false),
        new Animal("pauk", Animal.Type.SPIDER, Animal.Sex.F, 822, 1000000, 1, true),
        new Animal("black widow", Animal.Type.SPIDER, Animal.Sex.F, 8, 1, 1, true),
        new Animal("eagle", Animal.Type.BIRD, Animal.Sex.M, 300, 75, 4,  false)
    );

    @Test
    void getAnimalErrorStringsTest() {
        Map<String, String> checkMap = Map.of(
            "barsik", "[" + INCORRECT_HEIGHT.name() + "]",
            "xatiko", "[]",
            "kolibri", "[" + NULL_FIELD.name() + "]",
            "kambala","[" +  INCORRECT_WEIGHT.name() + "]",
            "pauk", "[" + INCORRECT_AGE.name() + ", " + INCORRECT_HEIGHT.name() + "]",
            "black widow", "[]",
            "eagle", "[" + INCORRECT_AGE.name() + "]"
        );

        var result = AnimalStreamTools.getAnimalErrorStrings(ANIMALS);

        for (var entry : result.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();

            assertThat(checkMap.containsKey(key)).isTrue();
            assertThat(checkMap.get(key)).isEqualTo(value);
        }
    }
}
