package io.github.avmohan.seep.playables;

import io.github.avmohan.seep.cards.Card;
import io.github.avmohan.seep.cards.Rank;
import org.pcollections.HashTreePSet;
import org.pcollections.PCollection;
import org.pcollections.PSet;

import java.util.Collections;
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
    public PCollection<Card> getCards() {
        return HashTreePSet.singleton(card);
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
