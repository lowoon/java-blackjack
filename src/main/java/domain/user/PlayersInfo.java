package domain.user;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

import domain.card.Deck;

public class PlayersInfo {

    private Map<Player, BettingMoney> playersInfo;

    private PlayersInfo(Map<String, Integer> playersInfo) {
        this.playersInfo = playersInfo.entrySet()
                .stream()
                .collect(Collectors.toMap(entry -> new Player(entry.getKey()),
                        entry -> new BettingMoney(entry.getValue()),
                        (first, second) -> first,
                        LinkedHashMap::new));
    }

    public static PlayersInfo of(Map<String, Integer> playerNames) {
        return new PlayersInfo(playerNames);
    }

    public void draw(Deck deck) {
        playersInfo.forEach((player, bettingMoney) -> player.draw(deck));
    }

    public void additionalDealOut(Deck deck, Function<String, Boolean> isYes, Consumer<Player> showResult) {
        for (Player player : playersInfo.keySet()) {
            askAndDealOut(deck, isYes, showResult, player);
        }
    }

    private void askAndDealOut(Deck deck, Function<String, Boolean> isYes, Consumer<Player> showResult, Player player) {
        while (player.isAvailableToDraw() && isYes.apply(player.name.getName())) {
            player.draw(deck);
            showResult.accept(player);
        }
    }

    public Map<User, Integer> calculatePoint() {
        return playersInfo.keySet()
                .stream()
                .collect(Collectors.toMap(Function.identity(),
                        Player::calculatePoint,
                        (first, second) -> first,
                        LinkedHashMap::new));
    }

    public Map<Player, Integer> calculateProfit(Dealer dealer) {
        Map<Player, Integer> profitOfPlayers = new LinkedHashMap<>();

        for (Map.Entry<Player, BettingMoney> entry : playersInfo.entrySet()) {
            profitOfPlayers.put(entry.getKey(),
                    (int)(entry.getValue().getMoney() * entry.getKey().decideRatio(dealer).getRatio()));
        }

        return profitOfPlayers;
    }

    public int calculateTotalProfit(Dealer dealer) {
        return playersInfo.keySet()
                .stream()
                .mapToInt(player -> (int)(playersInfo.get(player).getMoney() * player.decideRatio(dealer).getRatio()))
                .sum();
    }

    public List<Player> getPlayers() {
        return new ArrayList<>(playersInfo.keySet());
    }
}
