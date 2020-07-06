package domain.user;

import domain.state.State;

public abstract class Worker extends Gamer {
    public Worker(Name name, Money money, State state) {
        super(name, money, state);
    }
}
