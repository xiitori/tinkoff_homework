package edu.hw4;

import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Map;
import static org.assertj.core.api.Assertions.assertThat;

public class Task15Test {

    private static final List<Animal> ANIMALS = List.of(
        new Animal("barsik", Animal.Type.CAT, Animal.Sex.M, 3, 25, 2, true),
        new Animal("xatiko", Animal.Type.DOG, Animal.Sex.M, 4, 40, 10, true),
        new Animal("laki", Animal.Type.DOG, Animal.Sex.F, 8, 29, 8, true),
        new Animal("kolibri", Animal.Type.BIRD, Animal.Sex.F, 2, 15, 1, false),
        new Animal("kambala", Animal.Type.FISH, Animal.Sex.M, 40, 55, 6, false),
        new Animal("black widow", Animal.Type.SPIDER, Animal.Sex.F, 8, 10, 1, true),
        new Animal("eagle", Animal.Type.BIRD, Animal.Sex.M, 2, 14, 14, false)
    );

    @Test
    void sumWeightWithCertainHeightTest() {
        Map<Animal.Type, Integer> checkMap = Map.of(
            Animal.Type.CAT, 2,
            Animal.Type.BIRD, 15,
            Animal.Type.SPIDER, 1
        );
        var result = AnimalStreamTools.sumWeightWithCertainHeight(ANIMALS, 10, 29);

        assertThat(result.size()).isEqualTo(3);
        assertThat(checkMap).isEqualTo(result);
    }
}
