package edu.hw4;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

public class Task11Test {
    private static final List<Animal> ANIMALS = List.of(
        new Animal("barsik", Animal.Type.CAT, Animal.Sex.M, 3, 25, 2, true),
        new Animal("xatiko", Animal.Type.DOG, Animal.Sex.M, 4, 110, 10, true),
        new Animal("laki", Animal.Type.DOG, Animal.Sex.F, 8, 105, 8, true),
        new Animal("kolibri", Animal.Type.BIRD, Animal.Sex.F, 2, 5, 1, false),
        new Animal("kambala", Animal.Type.FISH, Animal.Sex.M, 40, 55, 6, false),
        new Animal("black widow", Animal.Type.SPIDER, Animal.Sex.F, 8, 1, 1, true),
        new Animal("eagle", Animal.Type.BIRD, Animal.Sex.M, 2, 75, 4, false)
    );


    @Test
    void listBitesAnimalsOver100Test() {
        var result = AnimalStreamTools.listBitesAnimalsOver100(ANIMALS);
        assertThat(result.size()).isEqualTo(2);
        assertThat(result.get(0).name()).isEqualTo("xatiko");
        assertThat(result.get(1).name()).isEqualTo("laki");
    }
}
