package domain;

import static org.assertj.core.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import domain.state.Hit;
import domain.user.Name;
import domain.user.Player;
import domain.user.User;

class YesOrNoTest {
    @ParameterizedTest
    @MethodSource("createYesOrNo")
    @DisplayName("추가 draw 여부")
    void getYesOrNo(YesOrNo yesOrNo, boolean expected) {
        assertThat(yesOrNo.getYesOrNo()).isEqualTo(expected);
    }

    private static Stream<Arguments> createYesOrNo() {
        return Stream.of(
            Arguments.of(YesOrNo.y, true),
            Arguments.of(YesOrNo.n, false)
        );
    }

    @ParameterizedTest
    @MethodSource("createState")
    @DisplayName("user 상태")
    void finish(YesOrNo yesOrNo, boolean expected) {
        User user = new Player(new Name("pobi"), Hit.initial());

        yesOrNo.finish(user);

        assertThat(user.isNotFinished()).isEqualTo(expected);
    }

    private static Stream<Arguments> createState() {
        return Stream.of(
            Arguments.of(YesOrNo.y, true),
            Arguments.of(YesOrNo.n, false)
        );
    }
}
