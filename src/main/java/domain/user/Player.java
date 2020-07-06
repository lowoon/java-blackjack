package domain.user;

import domain.state.State;

public class Player extends Gamer {
    public Player(Name name, Money money, State state) {
        super(name, money, state);
    }
}
