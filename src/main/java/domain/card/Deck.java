package domain.card;

import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

import domain.exception.InvalidDeckException;

public class Deck {
    private static final int DECK_SIZE = 52;

    private final Queue<Card> deck;

    public Deck(Queue<Card> deck) {
        validate(deck);
        this.deck = deck;
    }

    private void validate(Queue<Card> deck) {
        Set<Card> cards = new HashSet<>(deck);

        if (cards.size() != DECK_SIZE) {
            throw new InvalidDeckException("Deck은 52장의 카드여야 합니다.");
        }
    }

    public Card draw() {
        return deck.poll();
    }

    public Queue<Card> getDeck() {
        return deck;
    }
}
