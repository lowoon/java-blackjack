package domain.user;

import exception.InvalidMoneyException;

public class Money {
    private final int money;

    public Money(int money) {
        validate(money);
        this.money = money;
    }

    private void validate(int money) {
        if (money <= 0) {
            throw new InvalidMoneyException("금액은 0원 이하일 수 없습니다.");
        }
    }

    public int getMoney() {
        return money;
    }
}
