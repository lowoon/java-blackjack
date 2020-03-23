package domain.result;

import java.util.function.BiFunction;

import domain.card.Cards;

public enum PlayerResultRule {

    PLAYER_BUST((playerCards, dealerCards) -> playerCards.isBust(), Ratio.LOSE),
    DEALER_BUST((playerCards, dealerCards) -> dealerCards.isBust(), Ratio.WIN),
    PLAYER_ONLY_BLACK_JACK((playerCards, dealerCards) -> playerCards.isBlackJack() && !dealerCards.isBlackJack(), Ratio.BLACKJACK),
    DEALER_ONLY_BLACK_JACK((playerCards, dealerCards) -> !playerCards.isBlackJack() && dealerCards.isBlackJack(), Ratio.LOSE),
    EQUALS((playerCards, dealerCards) -> playerCards.compareTo(dealerCards) == 0, Ratio.DRAW),
    PLAYER_GREATER((playerCards, dealerCards) -> playerCards.compareTo(dealerCards) > 0, Ratio.WIN),
    DEALER_GREATER((playerCards, dealerCards) -> playerCards.compareTo(dealerCards) < 0, Ratio.LOSE);

    private final BiFunction<Cards, Cards, Boolean> condition;
    private final Ratio ratio;

    PlayerResultRule(BiFunction<Cards, Cards, Boolean> condition, Ratio ratio) {
        this.condition = condition;
        this.ratio = ratio;
    }

    public Boolean condition(Cards playerCards, Cards dealerCards) {
        return condition.apply(playerCards, dealerCards);
    }

    public Ratio getRatio() {
        return ratio;
    }
}
