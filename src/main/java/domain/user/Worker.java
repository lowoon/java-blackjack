package domain.user;

import domain.state.State;

public abstract class Worker extends Gamer {
    public Worker(Name name, State state) {
        super(name, state);
    }
}
