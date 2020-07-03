package domain.card;

import static org.assertj.core.api.Assertions.*;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DeckFactoryTest {
    @Test
    @DisplayName("Deck 생성")
    void generateDeck() {
        Queue<Card> cards  = new LinkedList<>();
        for (Denomination denomination : Denomination.values()) {
            for (Suit suit : Suit.values()) {
                cards.add(new Card(denomination, suit));
            }
        }
        GenerateStrategy generateStrategy = new TestStrategy(cards);
        DeckFactory deckFactory = new DeckFactory(generateStrategy);

        Deck deck = deckFactory.generateDeck();

        assertThat(deck.getDeck()).isEqualTo(cards);
    }
}
