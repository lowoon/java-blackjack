package domain.card;

import static org.assertj.core.api.Assertions.*;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import domain.exception.InvalidDeckException;

class DeckTest {
    @Test
    void createWithInvalidCards() {
        Queue<Card> cards = new LinkedList<>();

        assertThatThrownBy(() -> new Deck(cards))
            .isInstanceOf(InvalidDeckException.class)
            .hasMessage("Deck은 52장의 카드여야 합니다.");
    }

    @Test
    @DisplayName("카드 한장 뽑기")
    void draw() {
        Queue<Card> cards  = new LinkedList<>();
        for (Denomination denomination : Denomination.values()) {
            for (Suit suit : Suit.values()) {
                cards.add(new Card(denomination, suit));
            }
        }
        Deck deck = new Deck(cards);

        Card card = deck.draw();

        assertThat(card).isEqualTo(new Card(Denomination.ACE, Suit.CLUB));
    }
}
