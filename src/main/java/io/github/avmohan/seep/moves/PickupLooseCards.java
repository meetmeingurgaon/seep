package io.github.avmohan.seep.moves;

import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableSet;
import io.github.avmohan.seep.cards.Card;
import io.github.avmohan.seep.table.LooseCard;

import java.util.Objects;
import java.util.Set;

public final class PickupLooseCards extends Move {
    private final ImmutableSet<LooseCard> looseCards;

    public PickupLooseCards(Card card, ImmutableSet<LooseCard> looseCards) {
        super(card);
        this.looseCards = looseCards;
    }

    public Set<LooseCard> getLooseCards() {
        return looseCards;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PickupLooseCards that = (PickupLooseCards) o;
        return Objects.equals(getCard(), that.getCard()) &&
                Objects.equals(getLooseCards(), that.getLooseCards());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCard(), getLooseCards());
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("card", getCard())
                .add("looseCards", looseCards)
                .toString();
    }
}
