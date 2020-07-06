package domain.user;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import domain.card.Deck;

public class Users {
    public static final int FIRST_DRAW_COUNT = 2;
    public static final int DEALER_INDEX = 0;

    private final List<User> users;

    public Users(List<User> users) {
        this.users = users;
    }

    public Map<Player, Money> createPlayerToMoney(Map<String, Integer> nameToMoney) {
        return users.stream()
            .filter(User::isPlayer)
            .collect(Collectors.toMap(user -> (Player)user, user -> new Money(nameToMoney.get(user.name().getValue()))));
    }

    public void firstDraw(Deck deck) {
        for (User user : users) {
            drawFirstCards(deck, user);
        }
    }

    private void drawFirstCards(Deck deck, User user) {
        for (int i = 0; i < FIRST_DRAW_COUNT; i++) {
            user.draw(deck);
        }
    }

    public List<User> getUsers() {
        return Collections.unmodifiableList(new ArrayList<>(users));
    }
}
