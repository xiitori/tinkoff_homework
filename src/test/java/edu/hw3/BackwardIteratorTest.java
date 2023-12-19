package edu.hw3;

import edu.hw3.task8.BackwardIterator;
import org.junit.jupiter.api.Test;
import java.util.Collections;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

public class BackwardIteratorTest {
    @Test
    void backwardIteratorTest() {
        BackwardIterator<Integer> iterator = new BackwardIterator<>(List.of(3, 1, 2));
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    @Test
    void emptyCollectionTest() {
        BackwardIterator<Integer> iterator = new BackwardIterator<>(Collections.emptyList());
        assertThat(iterator.hasNext()).isFalse();
    }
}
