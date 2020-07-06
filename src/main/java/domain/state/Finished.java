package domain.state;

import domain.card.Card;
import domain.card.Cards;

public abstract class Finished extends Started {
    public Finished(Cards cards) {
        super(cards);
    }

    @Override
    public boolean isFinished() {
        return true;
    }

    @Override
    public State stay() {
        return null;
    }

    @Override
    public State draw(Card card) {
        return null;
    }

    public abstract double earningRate();
}
