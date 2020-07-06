package domain.user;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import domain.card.Card;
import domain.card.Cards;
import domain.card.Denomination;
import domain.card.Suit;
import domain.state.Hit;

class PlayerTest {
    @Test
    @DisplayName("유저의 점수 계산")
    void calculateScore() {
        List<Card> cards = new ArrayList<>(Arrays.asList(new Card(Denomination.KING, Suit.CLUB),
            new Card(Denomination.EIGHT, Suit.CLUB)));
        User user = new Player(new Name("a"), new Hit(new Cards(cards)));

        assertThat(user.calculateScore()).isEqualTo(18);
    }
}
