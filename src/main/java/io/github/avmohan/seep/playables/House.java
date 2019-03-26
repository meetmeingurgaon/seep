package io.github.avmohan.seep.playables;

import io.github.avmohan.seep.cards.Card;
import io.github.avmohan.seep.cards.CardUtils;
import io.github.avmohan.seep.cards.Rank;
import org.pcollections.HashTreePSet;
import org.pcollections.PCollection;
import org.pcollections.PSet;

public final class House implements Playable {
    private final PSet<Card> cards;
    private final Rank rank;
    private final boolean sealed;

    private House(PSet<Card> cards, Rank rank, boolean sealed) {
        this.cards = cards;
        this.rank = rank;
        this.sealed = sealed;
    }

    public static House of(PSet<Card> cards, Rank rank) {
        int sum = CardUtils.getRankSum(cards);
        if (sum % rank.numeral() != 0) {
            throw new IllegalArgumentException("Card rank sum should match the house rank matching the house rank");
        }
        return new House(HashTreePSet.from(cards), rank, sum > 13);
    }

    public boolean isSealed() {
        return sealed;
    }

    public House seal(PSet<Card> newCards) {
        return new House(cards.plusAll(newCards), rank, true);
    }

    public House smash(Card card) {
        if (sealed) {
            throw new IllegalStateException("Sealed house cannot be smashed");
        }
        int newRank = rank.numeral() + card.getRank().numeral();
        if (newRank > 13) {
            throw new IllegalArgumentException("Cannot smash due to overflow");
        }
        return new House(cards.plus(card), Rank.fromNumeral(newRank), false);
    }

    @Override
    public Rank getRank() {
        return rank;
    }

    @Override
    public PCollection<Card> getCards() {
        return cards;
    }


    @Override
    public String toString() {
        return "House{" +
                "cards=" + cards +
                ", rank=" + rank +
                ", sealed=" + sealed +
                '}';
    }
}
