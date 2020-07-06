package domain.user;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

import exception.InvalidMoneyException;

class MoneyTest {
    @Test
    void moneyWithInvalidInput() {
        assertThatThrownBy(() -> new Money(0))
            .isInstanceOf(InvalidMoneyException.class)
            .hasMessage("금액은 0원 이하일 수 없습니다.");
    }
}
