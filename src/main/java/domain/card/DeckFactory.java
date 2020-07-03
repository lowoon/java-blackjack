package domain.card;

public class DeckFactory {
    private final GenerateStrategy generateStrategy;

    public DeckFactory(GenerateStrategy generateStrategy) {
        this.generateStrategy = generateStrategy;
    }

    public Deck generateDeck() {
        return new Deck(generateStrategy.generateCards());
    }
}
