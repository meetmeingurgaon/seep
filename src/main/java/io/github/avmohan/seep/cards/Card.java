package io.github.avmohan.seep.cards;

import java.util.Comparator;
import java.util.Objects;

import static io.github.avmohan.seep.cards.Rank.*;
import static io.github.avmohan.seep.cards.Suit.DIAMONDS;
import static io.github.avmohan.seep.cards.Suit.SPADES;

public final class Card implements Comparable<Card> {

    private static final Comparator<Card> SUIT_THEN_RANK_COMPARATOR = Comparator
            .comparing(Card::getSuit)
            .thenComparing(Card::getRank);

    private final Suit suit;
    private final Rank rank;

    public Card(Suit suit, Rank rank) {
        this.suit = Objects.requireNonNull(suit);
        this.rank = Objects.requireNonNull(rank);
    }

    public Suit getSuit() {
        return suit;
    }

    public Rank getRank() {
        return rank;
    }

    public int getPointValue() {
        if (suit == SPADES || rank == ACE) return rank.numeral();
        if (suit == DIAMONDS && rank == TEN) return 6;
        return 0;
    }

    public boolean isHouseCard() {
        return rank.compareTo(NINE) >= 0;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (!(other instanceof Card)) return false;
        Card card = (Card) other;
        return suit == card.suit && rank == card.rank;
    }

    @Override
    public int hashCode() {
        return Objects.hash(suit, rank);
    }

    @Override
    public String toString() {
        return rank + " of " + suit;
    }

    @Override
    public int compareTo(Card other) {
        return SUIT_THEN_RANK_COMPARATOR.compare(this, other);
    }
}
