package domain.state;

import domain.card.Card;
import domain.card.Cards;

public interface State {
    Cards cards();

    boolean isFinished();

    State stay();

    State draw(Card card);
}
