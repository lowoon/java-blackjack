package domain;

import java.util.function.Consumer;

import domain.user.User;

public enum YesOrNo {
    y(true, user -> {}),
    n(false, User::stay);

    private final Boolean yesOrNo;
    private final Consumer<User> consumer;

    YesOrNo(Boolean yesOrNo, Consumer<User> consumer) {
        this.yesOrNo = yesOrNo;
        this.consumer = consumer;
    }

    public Boolean getYesOrNo() {
        return yesOrNo;
    }

    public void finish(User user) {
        consumer.accept(user);
    }
}
