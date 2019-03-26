package io.github.avmohan.seep.cards;

import java.util.Collection;

public class CardUtils {
    private CardUtils() {
    }

    public static int getRankSum(Collection<Card> cards) {
        return cards.stream().mapToInt(card -> card.getRank().numeral()).sum();
    }

    public static int getPointSum(Collection<Card> cards) {
        return cards.stream().mapToInt(Card::getPointValue).sum();
    }

    public static int getRankSum(Rank rank1, Rank rank2) {
        return rank1.numeral() + rank2.numeral();
    }
}
