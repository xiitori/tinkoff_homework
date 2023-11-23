package edu.hw4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.NoSuchElementException;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Task7Test {

    private static final List<Animal> ANIMALS = List.of(
        new Animal("barsik", Animal.Type.CAT, Animal.Sex.M, 2, 25, 2, true),
        new Animal("xatiko", Animal.Type.DOG, Animal.Sex.M, 4, 40, 10, true),
        new Animal("laki", Animal.Type.DOG, Animal.Sex.F, 8, 35, 8, true),
        new Animal("kolibri", Animal.Type.BIRD, Animal.Sex.F, 3, 5, 1, false),
        new Animal("kambala", Animal.Type.FISH, Animal.Sex.M, 40, 55, 6, false),
        new Animal("black widow", Animal.Type.SPIDER, Animal.Sex.F, 1, 1, 1, true),
        new Animal("eagle", Animal.Type.BIRD, Animal.Sex.M, 9, 75, 4, false)
    );

    @Test
    void oldestAnimalTest() {

        var result = AnimalStreamTools.oldestAnimal(ANIMALS, 2);

        assertThat(result.name()).isEqualTo("laki");
    }

    @Test
    @DisplayName("k == 0")
    void kIsZeroTest() {
        var result = AnimalStreamTools.oldestAnimal(ANIMALS, 0);

        assertThat(result.name()).isEqualTo("kambala");
    }

    @Test
    @DisplayName("k > list.size()")
    void kIsMoreThanListSize() {
        assertThrows(NoSuchElementException.class, () -> {
            var result = AnimalStreamTools.oldestAnimal(ANIMALS, 18);
        });
    }
}
