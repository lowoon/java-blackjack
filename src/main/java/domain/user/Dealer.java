package domain.user;

import domain.state.State;

public class Dealer extends Worker {
    public Dealer(Name name, State state) {
        super(name, state);
    }

    @Override
    public boolean isPlayer() {
        return false;
    }
}
