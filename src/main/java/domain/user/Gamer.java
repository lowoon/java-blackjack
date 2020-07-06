package domain.user;

import java.util.Objects;

import domain.state.State;

public abstract class Gamer implements User {
    protected final Name name;
    protected State state;

    public Gamer(Name name, State state) {
        this.name = name;
        this.state = state;
    }

    @Override
    public int calculateScore() {
        return state.cards().calculateScore();
    }

    @Override
    public Name name() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Gamer gamer = (Gamer)o;
        return Objects.equals(name, gamer.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
