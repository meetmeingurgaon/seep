package io.github.avmohan.seep.moves;

import com.google.common.base.MoreObjects;
import io.github.avmohan.seep.cards.Card;
import io.github.avmohan.seep.playables.LooseCard;
import org.pcollections.PSet;

import java.util.Objects;

public final class CreateHouse extends Move {
    private final PSet<LooseCard> looseCards;

    public CreateHouse(Card card, PSet<LooseCard> looseCards) {
        super(card);
        this.looseCards = looseCards;
    }

    public PSet<LooseCard> getLooseCards() {
        return looseCards;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreateHouse that = (CreateHouse) o;
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
