package io.github.avmohan.seep.moves;

import com.google.common.base.MoreObjects;
import io.github.avmohan.seep.cards.Card;
import io.github.avmohan.seep.cards.CardUtils;
import io.github.avmohan.seep.playables.House;

import java.util.Objects;

/**
 * Break an unsealed house.
 */
public final class BreakHouse extends Move {
    private final House house;

    public BreakHouse(Card card, House house) {
        super(card);
        if (house.isSealed()) {
            throw new IllegalStateException("Sealed house cannot be broken");
        }
        if (CardUtils.getRankSum(card.getRank(), house.getRank()) > 13) {
            throw new IllegalArgumentException("House rank overflows");
        }
        this.house = house;
    }

    public House getHouse() {
        return house;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BreakHouse that = (BreakHouse) o;
        return Objects.equals(getCard(), that.getCard()) &&
                getHouse() == that.getHouse();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCard(), getHouse());
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("card", getCard())
                .add("house", house)
                .toString();
    }
}
