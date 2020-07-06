package domain.user;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Users {
    private final List<User> users;

    public Users(List<User> users) {
        this.users = users;
    }

    public Map<Player, Money> createPlayerToMoney(Map<String, Integer> nameToMoney) {
        return users.stream()
            .filter(User::isPlayer)
            .collect(Collectors.toMap(user -> (Player)user, user -> new Money(nameToMoney.get(user.name()))));
    }

    public List<User> getUsers() {
        return Collections.unmodifiableList(new ArrayList<>(users));
    }
}
