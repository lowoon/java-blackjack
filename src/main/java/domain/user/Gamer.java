package domain.user;

import domain.state.State;

public abstract class Gamer implements User {
    protected Name name;
    protected State state;

    public Gamer(Name name, State state) {
        this.name = name;
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
