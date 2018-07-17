package io.github.avmohan.seep.table;

import io.github.avmohan.seep.cards.Card;
import io.github.avmohan.seep.cards.Rank;

import java.util.Objects;

public final class LooseCard implements Playable {
    private final Card card;

    LooseCard(Card card) {
        this.card = card;
    }

    @Override
    public Rank getRank() {
        return card.getRank();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LooseCard looseCard = (LooseCard) o;
        return Objects.equals(card, looseCard.card);
    }

    @Override
    public int hashCode() {
        return Objects.hash(card);
    }

    @Override
    public String toString() {
        return "LooseCard{" +
                "card=" + card +
                '}';
    }
}
