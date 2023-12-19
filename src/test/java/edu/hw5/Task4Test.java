package edu.hw5;

import edu.hw5.task4.PasswordValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class Task4Test {

    @Test
    @DisplayName("Тест валидных данных")
    void validatePasswordTest() {
        String correctPassword = "qwe@rty123";
        String incorrectPassword = "fdjbbfnljbveq";

        boolean firstAnswer = PasswordValidator.validate(correctPassword);
        boolean secondAnswer = PasswordValidator.validate(incorrectPassword);

        assertThat(firstAnswer).isTrue();
        assertThat(secondAnswer).isFalse();
    }

    @Test
    @DisplayName("Тест пустой строки")
    void emptyPasswordTest() {
        String password = "";

        boolean answer = PasswordValidator.validate(password);

        assertThat(answer).isFalse();
    }
}
