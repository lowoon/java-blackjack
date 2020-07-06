package domain.user;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import domain.exception.InvalidNameException;

class NameTest {
    @Test
    @DisplayName("이름이 빈 값이 경우")
    void nameWithEmptyInput() {
        assertThatThrownBy(() -> new Name(""))
            .isInstanceOf(InvalidNameException.class)
            .hasMessage("이름은 빈 값일 수 없습니다.");
    }

    @Test
    @DisplayName("이름이 5자를 초과할 경우")
    void nameWithOverFiveCharacter() {
        assertThatThrownBy(() -> new Name("aaaaaa"))
            .isInstanceOf(InvalidNameException.class)
            .hasMessage("이름은 5자를 초과할 수 없습니다.");
    }
}
