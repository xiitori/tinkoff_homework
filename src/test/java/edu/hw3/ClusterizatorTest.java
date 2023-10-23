package edu.hw3;

import edu.hw3.task2.Clusterizator;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

public class ClusterizatorTest {
    @Test
    void clusterizeTest() {
        List<String> result = Clusterizator.clusterize("()()()");
        for (String brackets : result) {
            assertThat(brackets).isEqualTo("()");
        }
    }
}
