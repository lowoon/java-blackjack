package domain.user;

import java.util.List;

import domain.card.Card;
import domain.card.Deck;
import domain.state.State;

public interface User {
    int calculateScore();

    Name name();

    boolean isPlayer();

    void draw(Deck deck);

    List<Card> cards();

    boolean isNotFinished();

    void stay();
}
