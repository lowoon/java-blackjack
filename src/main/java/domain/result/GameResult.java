package domain.result;

import java.util.Map;

import domain.user.Money;
import domain.user.Player;
import domain.user.Users;

public class GameResult {
    private final Map<Player, Money> bettingMoney;

    public GameResult(Map<Player, Money> bettingMoney) {
        this.bettingMoney = bettingMoney;
    }

    public static GameResult of(Users users, Map<String, Integer> nameToMoney) {
        return new GameResult(users.createPlayerToMoney(nameToMoney));
    }
}
