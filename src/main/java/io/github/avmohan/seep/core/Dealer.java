package io.github.avmohan.seep.core;

import io.github.avmohan.seep.cards.Card;
import io.github.avmohan.seep.cards.Rank;
import io.github.avmohan.seep.cards.Suit;
import org.pcollections.TreePVector;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Shuffles the cards
 */
public class Dealer {

    /**
     * Get a list of cards, after shuffling. This method makes sure that the first 4 cards has at least
     * one house card.
     * @return A permutation of the deck.
     */
    public List<Card> getCards() {
        List<Card> cards = getDeck();
        do {
            Collections.shuffle(cards);
        } while (cards.stream().limit(4).noneMatch(Card::isHouseCard));
        return TreePVector.from(cards);
    }

    // Deck of all cards, in order.
    private List<Card> getDeck() {
        return Stream.of(Suit.values())
                .flatMap(suit -> Stream.of(Rank.values())
                        .map(rank -> new Card(suit, rank))).collect(Collectors.toList());
    }
}
