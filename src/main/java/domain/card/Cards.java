package domain.card;

import java.util.ArrayList;
import java.util.List;

public class Cards {

    private static final int BLACK_JACK = 21;
    private static final int BLACK_JACK_SIZE = 2;
    private static final int TEN = 10;

    private final List<Card> cards;

    public Cards() {
        cards = new ArrayList<>();
    }

    public void add(Card card) {
        cards.add(card);
    }

    public int calculatePointAccordingToHasAce() {
        if (hasAce() && calculatePoint() + TEN <= BLACK_JACK) {
            return calculatePoint() + TEN;
        }
        return calculatePoint();
    }

    private int calculatePoint() {
        return cards.stream()
                .mapToInt(Card::getPoint)
                .sum();
    }

    public boolean isBust() {
        return calculatePointAccordingToHasAce() > BLACK_JACK;
    }

    public boolean isBlackJack() {
        return cards.size() == BLACK_JACK_SIZE && areBlackJackPoint();
    }

    public boolean areBlackJackPoint() {
        return calculatePointAccordingToHasAce() == BLACK_JACK;
    }

    private boolean hasAce() {
        return cards.stream()
                .anyMatch(Card::isAce);
    }

    public List<Card> getCards() {
        return cards;
    }
}
