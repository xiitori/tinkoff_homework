package edu.hw4;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

public class Task18Test {

    private static final List<Animal> ANIMALS = List.of(
        new Animal("barsik", Animal.Type.CAT, Animal.Sex.M, 3, 25, 2, true),
        new Animal("xatiko", Animal.Type.DOG, Animal.Sex.M, 4, 40, 10, true),
        new Animal("laki", Animal.Type.DOG, Animal.Sex.F, 8, 35, 8, true),
        new Animal("kolibri", Animal.Type.BIRD, Animal.Sex.F, 2, 5, 1, false),
        new Animal("kambala", Animal.Type.FISH, Animal.Sex.M, 40, 55, 60, false),
        new Animal("black widow", Animal.Type.SPIDER, Animal.Sex.F, 8, 1, 1, true),
        new Animal("eagle", Animal.Type.BIRD, Animal.Sex.M, 2, 75, 4,  false)
    );

    @Test
    void mostHeaviestFishTest() {
        var list = List.of(
            new Animal("karp", Animal.Type.FISH, Animal.Sex.M, 2, 2, 2, false),
            new Animal("shark", Animal.Type.FISH, Animal.Sex.F, 2, 1, 1000, true));

        var result = AnimalStreamTools.mostHeaviestFish(list, ANIMALS);
        assertThat(result.name()).isEqualTo("shark");
    }
}
