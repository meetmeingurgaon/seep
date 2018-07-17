package io.github.avmohan.seep.table;

import io.github.avmohan.seep.Player;
import io.github.avmohan.seep.cards.Card;
import io.github.avmohan.seep.cards.Rank;

import java.util.HashSet;
import java.util.Set;

public final class House implements Playable {
    private final Set<Card> cards;
    private Rank rank;
    private boolean sealed;
    private Set<Player> owners;

    House(Set<Card> cards, Rank rank) {
        this.cards = new HashSet<>(cards);
        this.rank = rank;
    }

    boolean isSealed() {
        return sealed;
    }

    void seal(Set<Card> newCards) {
        cards.addAll(newCards);
        sealed = true;
    }

    void smash(Card card) {
        if (sealed) throw new IllegalStateException("Sealed house cannot be smashed");
        cards.add(card);
        rank = Rank.fromNumeral(rank.numeral() + 1);
    }

    @Override
    public Rank getRank() {
        return rank;
    }


    @Override
    public String toString() {
        return "House{" +
                "cards=" + cards +
                ", rank=" + rank +
                ", sealed=" + sealed +
                ", owners=" + owners +
                '}';
    }
}
