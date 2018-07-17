package io.github.avmohan.seep.moves;

import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableSet;
import io.github.avmohan.seep.cards.Card;
import io.github.avmohan.seep.cards.Rank;
import io.github.avmohan.seep.table.LooseCard;

import java.util.Objects;

public final class BreakHouse extends Move {
    private final Rank houseRank;
    private final ImmutableSet<LooseCard> looseCards;

    public BreakHouse(Card card, Rank houseRank, ImmutableSet<LooseCard> looseCards) {
        super(card);
        this.houseRank = houseRank;
        this.looseCards = looseCards;
    }

    public ImmutableSet<LooseCard> getLooseCards() {
        return looseCards;
    }

    public Rank getHouseRank() {
        return houseRank;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BreakHouse that = (BreakHouse) o;
        return Objects.equals(getCard(), that.getCard()) &&
                getHouseRank() == that.getHouseRank() &&
                Objects.equals(getLooseCards(), that.getLooseCards());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCard(), getHouseRank(), getLooseCards());
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("card", getCard())
                .add("houseRank", houseRank)
                .add("looseCards", looseCards)
                .toString();
    }
}
