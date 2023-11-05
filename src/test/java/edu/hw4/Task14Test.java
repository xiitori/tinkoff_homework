package edu.hw4;

import org.junit.jupiter.api.Test;
import java.util.List;
import static edu.hw4.Animal.Sex.F;
import static edu.hw4.Animal.Sex.M;
import static org.assertj.core.api.Assertions.assertThat;

public class Task14Test {

    private static final List<Animal> ANIMALS = List.of(
        new Animal("barsik", Animal.Type.CAT, M, 3, 105, 2, true),
        new Animal("xatiko", Animal.Type.DOG, M, 4, 41, 10, true),
        new Animal("laki", Animal.Type.DOG, F, 8, 101, 8, true),
        new Animal("kolibri", Animal.Type.BIRD, F, 2, 5, 1, false),
        new Animal("kambala", Animal.Type.FISH, M, 40, 109, 6, false),
        new Animal("black widow", Animal.Type.SPIDER, F, 8, 1, 1, true),
        new Animal("eagle", Animal.Type.BIRD, M, 2, 75, 4,  false)
    );

    @Test
    void findDogOverKTest() {
        var result = AnimalStreamTools.findDogOverK(ANIMALS, 40);
        assertThat(result).isTrue();
    }

    @Test
    void noDogOverKTest() {
        var list = List.of(new Animal("shawka", Animal.Type.DOG, M, 4, 39, 20, true),
            new Animal("grusha", Animal.Type.DOG, F, 2, 40, 10, false));

        boolean result = AnimalStreamTools.findDogOverK(list, 40);

        assertThat(result).isFalse();
    }
}
