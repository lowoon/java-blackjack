package domain.user;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import domain.card.DeckFactory;
import domain.card.RandomStrategy;
import domain.state.Hit;

class UsersTest {
    @Test
    @DisplayName("처음 카드 나누기")
    void firstDraw() {
        User first = new Player(new Name("pobi"), Hit.initial());
        User second = new Player(new Name("crong"), Hit.initial());
        Users users = new Users(Arrays.asList(first, second));

        users.firstDraw(new DeckFactory(new RandomStrategy()).generateDeck());

        assertAll(
            () -> assertThat(users.getUsers().get(0).cards()).hasSize(2),
            () -> assertThat(users.getUsers().get(1).cards()).hasSize(2)
        );
    }
}
