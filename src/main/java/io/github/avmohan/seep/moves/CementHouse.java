package io.github.avmohan.seep.moves;

import com.google.common.base.MoreObjects;
import io.github.avmohan.seep.cards.Card;
import io.github.avmohan.seep.playables.House;
import io.github.avmohan.seep.playables.LooseCard;
import org.pcollections.PSet;

import java.util.Objects;

public final class CementHouse extends Move {
    private final House house;
    private final PSet<LooseCard> looseCards;

    public CementHouse(Card card, House house, PSet<LooseCard> looseCards) {
        super(card);
        this.house = house;
        this.looseCards = looseCards;
    }

    public House getHouse() {
        return house;
    }

    public PSet<LooseCard> getLooseCards() {
        return looseCards;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CementHouse that = (CementHouse) o;
        return Objects.equals(getCard(), that.getCard()) &&
                getHouse() == that.getHouse() &&
                Objects.equals(getLooseCards(), that.getLooseCards());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCard(), getHouse(), getLooseCards());
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("card", getCard())
                .add("house", house)
                .add("looseCards", looseCards)
                .toString();
    }
}
