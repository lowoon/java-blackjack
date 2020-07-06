package domain.user;

import domain.state.State;

public abstract class Gamer implements User {
    protected final Name name;
    protected final Money money;
    protected State state;

    public Gamer(Name name, Money money, State state) {
        this.name = name;
        this.money = money;
        this.state = state;
    }

    @Override
    public int calculateScore() {
        return state.cards().calculateScore();
    }

    public Name name() {
        return name;
    }

    public State state() {
        return state;
    }
}
