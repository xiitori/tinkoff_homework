package edu.hw3;

import edu.hw3.task2.Clusterizator;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ClusterizatorTest {
    @Test
    void correctBraceTest() {
        List<String> result = Clusterizator.clusterize("()()()");
        for (String brackets : result) {
            assertThat(brackets).isEqualTo("()");
        }

        result = Clusterizator.clusterize("((()))");
        assertThat(result.get(0)).isEqualTo("((()))");

        result = Clusterizator.clusterize("((()))(())()()(()())");
        assertThat(result.get(0)).isEqualTo("((()))");
        assertThat(result.get(1)).isEqualTo("(())");
        assertThat(result.get(2)).isEqualTo("()");
        assertThat(result.get(3)).isEqualTo("()");
        assertThat(result.get(4)).isEqualTo("(()())");

        result = Clusterizator.clusterize("((())())(()(()()))");
        assertThat(result.get(0)).isEqualTo("((())())");
        assertThat(result.get(1)).isEqualTo("(()(()()))");
    }

    @Test
    void illegalCharsTest() {
        assertThrows(IllegalArgumentException.class, () -> {
            Clusterizator.clusterize("((()()))()J()()()");
        });
    }

    @Test
    void notBalancedBraceStringTest() {
        assertThrows(IllegalArgumentException.class, () -> {
            Clusterizator.clusterize("((())(())(()(()()))((()))");
        });
    }

    @Test
    void invertedBraceStringTest() {
        assertThrows(IllegalArgumentException.class, () -> {
            Clusterizator.clusterize(")(");
        });
    }
}
