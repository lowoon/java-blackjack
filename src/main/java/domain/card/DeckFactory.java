package domain.card;

import java.util.ArrayList;
import java.util.List;

public class DeckFactory {

    private static List<Card> DECK_CARDS = new ArrayList<>();

    static {
        for (Symbol symbol : Symbol.values()) {
            for (Type type : Type.values()) {
                DECK_CARDS.add(new Card(symbol, type));
            }
        }
    }

    public static Deck createDeck() {
        return new Deck(DECK_CARDS);
    }
}
