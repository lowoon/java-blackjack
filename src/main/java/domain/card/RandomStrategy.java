package domain.card;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class RandomStrategy implements GenerateStrategy {
    private final LinkedList<Card> cards = new LinkedList<>();

    public RandomStrategy() {
        for (Denomination denomination : Denomination.values()) {
            createCard(denomination);
        }
    }

    private void createCard(Denomination denomination) {
        for (Suit suit : Suit.values()) {
            cards.add(new Card(denomination, suit));
        }
    }

    @Override
    public Queue<Card> generateCards() {
        Collections.shuffle(cards);
        return cards;
    }
}
