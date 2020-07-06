package domain.user;

public interface User {
    int calculateScore();

    Name name();

    boolean isPlayer();
}
