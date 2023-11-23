package edu.hw4;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

public class Task1Test {

    private static final List<Animal> ANIMALS = List.of(
        new Animal("barsik", Animal.Type.CAT, Animal.Sex.M, 2, 25, 2, true),
        new Animal("xatiko", Animal.Type.DOG, Animal.Sex.M, 4, 40, 10, true),
        new Animal("laki", Animal.Type.DOG, Animal.Sex.F, 8, 35, 8, true),
        new Animal("kolibri", Animal.Type.BIRD, Animal.Sex.F, 3, 5, 1, false),
        new Animal("kambala", Animal.Type.FISH, Animal.Sex.M, 40, 55, 6, false)
    );

    @Test
    void heightSortTest() {
        List<String> checkList = List.of("kolibri", "barsik", "laki", "xatiko", "kambala");

        var result = AnimalStreamTools.heightSort(ANIMALS);

        for (int i = 0; i < result.size(); i++) {
            assertThat(result.get(i).name()).isEqualTo(checkList.get(i));
        }
    }
}
