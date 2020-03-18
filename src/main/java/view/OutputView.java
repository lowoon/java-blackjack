package view;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import domain.card.Card;
import domain.result.GameResult;
import domain.user.Dealer;
import domain.user.Player;
import domain.user.PlayersInfo;
import domain.user.User;

public class OutputView {

    public static final String NEWLINE = System.getProperty("line.separator");
    public static final String COMMA = ", ";
    private static final String CARD = "카드: ";
    private static final String RESULT = " - 결과: ";
    private static final String COLON = ": ";

    public static void printFirstDealOutResult(Dealer dealer, PlayersInfo playersInfo) {
        printFirstDealOut(playersInfo);
        printDealerFirstDealOutResult(dealer);
        printPlayersFirstDealOutResult(playersInfo);
    }

    private static void printFirstDealOut(PlayersInfo playersInfo) {
        String allNames = playersInfo.getPlayers()
                .stream()
                .map(Player::getName)
                .collect(Collectors.joining(COMMA));

        System.out.printf(NEWLINE + "딜러와 %s에게 2장을 나누었습니다." + NEWLINE, allNames);
    }

    private static void printDealerFirstDealOutResult(Dealer dealer) {
        String dealerFirstDealOutResult =
                Dealer.NAME + CARD + dealer.getFirstCard().getType() + dealer.getFirstCard().getSymbol();
        System.out.println(dealerFirstDealOutResult);
    }

    private static void printPlayersFirstDealOutResult(PlayersInfo playersInfo) {
        playersInfo.getPlayers()
                .forEach(player -> System.out.println(printUserDealOutResult(player)));
        System.out.println();
    }

    public static void printPlayerDealOutResult(Player player) {
        System.out.println(printUserDealOutResult(player));
    }

    public static void printDealerDealOut(String name) {
        System.out.printf(NEWLINE + "%s는 16이하라 한장의 카드를 더 받았습니다." + NEWLINE, name);
    }

    public static void printTotalResult(GameResult gameResult) {
        Map<User, Integer> cardPoint = gameResult.getUserToCardPoint();
        System.out.println();
        cardPoint.forEach((user, point) -> System.out.println(printUserDealOutResult(user) + RESULT + point));
    }

    public static void printWinningResult(GameResult gameResult) {
        System.out.println(NEWLINE + "## 최종 승패");
        System.out.printf("%s%s%.0f" + NEWLINE, Dealer.NAME, COLON, gameResult.getProfitOfDealer());
        gameResult.getProfitOfPlayers()
                .forEach((key, value) -> System.out.printf("%s%s%.0f" + NEWLINE, key.getName(), COLON, value));
    }

    private static String printUserDealOutResult(User user) {
        return user.getName() + CARD + cardsJoin(user);
    }

    private static String cardsJoin(User user) {
        return String.join(COMMA, printCard(user.getCards()));
    }

    private static String printCard(List<Card> cards) {
        return cards.stream()
                .map(card -> card.getType() + card.getSymbol())
                .collect(Collectors.joining(COMMA));
    }
}
