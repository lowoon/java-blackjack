package domain.card;

import java.util.ArrayList;
import java.util.List;

public class Cards {
    private final List<Card> cards;

    public Cards(List<Card> cards) {
        this.cards = cards;
    }

    public static Cards empty() {
        return new Cards(new ArrayList<>());
    }

    public void add(Card card) {
        cards.add(card);
    }

    public boolean isBust() {
        return calculateScore() > 21;
    }

    public int calculateScore() {
        return cards.stream()
            .mapToInt(card -> card.getDenomination().getScore())
            .sum();
    }

    public List<Card> getCards() {
        return cards;
    }
}
