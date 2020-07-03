package domain.card;

import java.util.Queue;

public class TestStrategy implements GenerateStrategy {
    private final Queue<Card> cards;

    public TestStrategy(Queue<Card> cards) {
        this.cards = cards;
    }

    @Override
    public Queue<Card> generateCards() {
        return cards;
    }
}
