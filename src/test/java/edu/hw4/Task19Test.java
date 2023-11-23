package edu.hw4;

import edu.hw4.validate.ValidationError;
import org.junit.jupiter.api.Test;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import static org.assertj.core.api.Assertions.assertThat;

public class Task19Test {

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
    void getAnimalErrorSetsTest() {
        Map<String, Set<ValidationError>> checkMap = Map.of(
            "barsik", Set.of(ValidationError.INCORRECT_HEIGHT),
            "xatiko", Collections.emptySet(),
            "kolibri", Set.of(ValidationError.NULL_FIELD),
            "kambala", Set.of(ValidationError.INCORRECT_WEIGHT),
            "pauk", Set.of(ValidationError.INCORRECT_AGE, ValidationError.INCORRECT_HEIGHT),
            "black widow", Collections.emptySet(),
            "eagle", Set.of(ValidationError.INCORRECT_AGE));

        var result = AnimalStreamTools.getAnimalErrorSets(ANIMALS);

        assertThat(result).isEqualTo(checkMap);
    }
}
