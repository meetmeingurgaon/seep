package io.github.avmohan.seep.cards;

import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

import static io.github.avmohan.seep.cards.Rank.ACE;
import static io.github.avmohan.seep.cards.Rank.TEN;
import static io.github.avmohan.seep.cards.Suit.DIAMONDS;
import static io.github.avmohan.seep.cards.Suit.SPADES;
import static org.assertj.core.api.Assertions.assertThat;

class CardTest {
    @Test
    void totalValueOfADeckIsHundred() {
        assertThat(deck().mapToInt(Card::getPointValue).sum())
                .isEqualTo(100);
    }

    private Stream<Card> deck() {
        return Stream.of(Suit.values())
                .flatMap(suit -> Stream.of(Rank.values())
                        .map(rank -> new Card(suit, rank)));
    }

    @Test
    void acesHaveFaceValue() {
        assertThat(Stream.of(Suit.values()).map(suit -> new Card(suit, ACE)))
                .allMatch(card -> card.getPointValue() == 1);
    }

    @Test
    void spadesHaveFaceValue() {
        assertThat(Stream.of(Rank.values()).map(rank -> new Card(SPADES, rank)))
                .allMatch(card -> card.getPointValue() == card.getRank().numeral());
    }

    @Test
    void valueOfTenOfDiamondsIsSix() {
        assertThat(new Card(DIAMONDS, TEN).getPointValue()).isEqualTo(6);
    }

    @Test
    void numberOfHouseCardsInDeckIsTwenty() {
        assertThat(deck().filter(Card::isHouseCard)).hasSize(20);
    }

}