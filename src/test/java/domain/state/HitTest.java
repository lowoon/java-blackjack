package domain.state;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import domain.card.Card;
import domain.card.Cards;
import domain.card.Denomination;
import domain.card.Suit;

class HitTest {
    @Test
    @DisplayName("상태의 카드")
    void cards() {
        List<Card> cards = Arrays.asList(new Card(Denomination.ACE, Suit.CLUB),
            new Card(Denomination.KING, Suit.CLUB));
        State state = new Hit(new Cards(cards));

        assertThat(state.cards().getCards()).isEqualTo(cards);
    }

    @Test
    @DisplayName("상태의 게임 여부")
    void isFinished() {
        List<Card> cards = Arrays.asList(new Card(Denomination.ACE, Suit.CLUB),
            new Card(Denomination.KING, Suit.CLUB));
        State state = new Hit(new Cards(cards));

        assertThat(state.isFinished()).isFalse();
    }

    @Test
    @DisplayName("stay 상태 생성")
    void stay() {
        List<Card> cards = Arrays.asList(new Card(Denomination.ACE, Suit.CLUB),
            new Card(Denomination.KING, Suit.CLUB));
        State state = new Hit(new Cards(cards));

        assertThat(state.stay()).isInstanceOf(Stay.class);
    }

    @ParameterizedTest
    @MethodSource("createCardAndState")
    @DisplayName("다음 상태 생성")
    void draw(Card card, Class<?> expected) {
        List<Card> cards = new ArrayList<>(Arrays.asList(new Card(Denomination.KING, Suit.CLUB),
            new Card(Denomination.EIGHT, Suit.CLUB)));
        State state = new Hit(new Cards(cards));

        assertThat(state.draw(card)).isInstanceOf(expected);
    }

    private static Stream<Arguments> createCardAndState() {
        return Stream.of(
            Arguments.of(new Card(Denomination.TWO, Suit.CLUB), Hit.class),
            Arguments.of(new Card(Denomination.FIVE, Suit.CLUB), Bust.class)
        );
    }
}
