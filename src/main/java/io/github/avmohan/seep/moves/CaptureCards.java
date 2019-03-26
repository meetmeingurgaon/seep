package io.github.avmohan.seep.moves;

import com.google.common.base.MoreObjects;
import io.github.avmohan.seep.cards.Card;
import io.github.avmohan.seep.playables.House;
import io.github.avmohan.seep.playables.LooseCard;
import org.pcollections.PSet;

import javax.annotation.Nullable;
import java.util.Objects;

/**
 * Capture zero or more loose cards, and optionally a house
 */
public final class CaptureCards extends Move {
    private final House house;
    private final PSet<LooseCard> looseCards;

    public CaptureCards(Card card, @Nullable House house, PSet<LooseCard> looseCards) {
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
        CaptureCards that = (CaptureCards) o;
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
