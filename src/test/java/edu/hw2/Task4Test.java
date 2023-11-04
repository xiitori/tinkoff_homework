package edu.hw2;

import edu.hw2.task4.CallingInfo;
import edu.hw2.task4.MethodCaller;
import org.assertj.core.util.Throwables;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class Task4Test {
    @Test
    void callingInfoTest() {
        CallingInfo callingInfo = CallingInfo.callingInfo();

        assertThat(callingInfo.className()).isEqualTo("edu.hw2.Task4Test");
        assertThat(callingInfo.methodName()).isEqualTo("callingInfoTest");
    }

    @Test
    void callMethodFromDifferentClass() {
        CallingInfo callingInfo = MethodCaller.callMethod();

        assertThat(callingInfo.className()).isEqualTo("edu.hw2.task4.MethodCaller");
        assertThat(callingInfo.methodName()).isEqualTo("callMethod");
    }
}
