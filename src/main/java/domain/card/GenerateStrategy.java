package domain.card;

import java.util.Queue;

public interface GenerateStrategy {
    Queue<Card> generateCards();
}
