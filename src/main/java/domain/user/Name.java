package domain.user;

import exception.InvalidNameException;

public class Name {
    public static final int MAX_LENGTH = 5;

    private final String name;

    public Name(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        if (name.isEmpty()) {
            throw new InvalidNameException("이름은 빈 값일 수 없습니다.");
        }
        if (name.length() > MAX_LENGTH) {
            throw new InvalidNameException("이름은 " + MAX_LENGTH + "자를 초과할 수 없습니다.");
        }
    }

    public String getName() {
        return name;
    }
}
