package edu.hw4;

import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Map;
import static org.assertj.core.api.Assertions.assertThat;

public class Task3Test {

    private static final List<Animal> ANIMALS = List.of(
        new Animal("barsik", Animal.Type.CAT, Animal.Sex.M, 2, 25, 2, true),
        new Animal("barbos", Animal.Type.DOG, Animal.Sex.M, 3, 26, 3, true),
        new Animal("xatiko", Animal.Type.DOG, Animal.Sex.M, 4, 40, 10, true),
        new Animal("laki", Animal.Type.DOG, Animal.Sex.F, 8, 35, 8, true),
        new Animal("kolibri", Animal.Type.BIRD, Animal.Sex.F, 3, 5, 1, false),
        new Animal("kambala", Animal.Type.FISH, Animal.Sex.M, 40, 55, 6, false),
        new Animal("murzik", Animal.Type.CAT, Animal.Sex.M, 2, 34, 7, true)
    );

    @Test
    void mapByTypeTest() {
        Map<Animal.Type, Integer> checkMap = Map.of(
            Animal.Type.DOG, 3,
            Animal.Type.CAT, 2,
            Animal.Type.BIRD, 1,
            Animal.Type.FISH, 1
        );

        var result = AnimalStreamTools.mapByType(ANIMALS);

        for (var entry : checkMap.entrySet()) {
            Animal.Type key = entry.getKey();
            assertThat(result.get(key)).isEqualTo(entry.getValue());
        }
    }
}
