package io.github.avmohan.seep.cards;

public enum Rank {
    ACE,
    TWO,
    THREE,
    FOUR,
    FIVE,
    SIX,
    SEVEN,
    EIGHT,
    NINE,
    TEN,
    JACK,
    QUEEN,
    KING;

    private static final Rank[] values = values();

    public static Rank fromNumeral(int i) {
        return values[i - 1];
    }

    public int numeral() {
        return ordinal() + 1;
    }
}
