package io.github.avmohan.seep.moves;

import com.google.common.base.MoreObjects;
import io.github.avmohan.seep.cards.Card;

import java.util.Objects;

public final class ThrowLooseCard extends Move {

    public ThrowLooseCard(Card card) {
        super(card);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ThrowLooseCard that = (ThrowLooseCard) o;
        return Objects.equals(getCard(), that.getCard());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCard());
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("card", getCard())
                .toString();
    }
}
