package domain.card;

import static org.assertj.core.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class DenominationTest {
    @ParameterizedTest
    @MethodSource("createDenomination")
    @DisplayName("카드가 Ace인 확인")
    void isAce(Denomination denomination, boolean expected) {
        assertThat(denomination.isAce()).isEqualTo(expected);
    }

    private static Stream<Arguments> createDenomination() {
        return Stream.of(
            Arguments.of(Denomination.ACE, true),
            Arguments.of(Denomination.SIX, false)
        );
    }
}
