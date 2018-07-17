package io.github.avmohan.seep.cards;

public enum Suit {
    CLUBS("CLUBS", "♣"),
    DIAMONDS("DIAMONDS", "♦"),
    HEARTS("HEARTS", "♥"),
    SPADES("SPADES", "♠");

    private final String name;
    private final String symbol;

    Suit(String name, String symbol) {
        this.name = name;
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public String getSymbol() {
        return symbol;
    }
}
