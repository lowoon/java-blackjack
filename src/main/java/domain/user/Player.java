package domain.user;

import domain.state.State;

public class Player extends Gamer {
    public Player(Name name, State state) {
        super(name, state);
    }

    @Override
    public boolean isPlayer() {
        return true;
    }
}
