package io.github.avmohan.seep.moves;

import io.github.avmohan.seep.cards.Card;

public abstract class Move {
    /*
    - There can only be one house of one value on the table at a time.
    - There cannot be any loose card with same value as a house on the table.
    - If a card is not played to make a house, or seal a house, then it must pick up any cards
    that can be picked up. It's not possible to leave sets of loose cards on the table whose
    sum matches the value of the played card.
    - A player who created a house is the first owner of the house.
    - A player who seals a house becomes second owner if first owner is from opposite team.
    - A player can only add cards to a house if he or his teammate is an owner. (or to initially seal the house)
    - A player cannot break his own house. He can break his teammate's house.
     */


    /*
    - play myCard as a loose card.
        - there should not be any house with same value, else it should be captured or sealed.
        eg:- If table has a 9 house, 9 cannot be thrown as a loose card
        - there should not be any group of one or more loose cards whose sum adds up to this card, else they should be
        captured or a house should be created.
        eg:- If table has a loose 8, then 8 cannot be played as a loose card.
             If table has loose A, 2 & 5, then 8 cannot be played as a loose card.

    - pick up one or more sets of loose cards whose sums are same as value of myCard
        - after the move, there should not be any more such set of loose cards on the table
        eg:= If table has J, 3, 4, A, 6, then 7 cannot be used to pick up only one of {3,4} or {A,6}.

    - pick up a house, (and any set of loose cards that can be merged into the house) using myCard
        - after the move, there should not be any more such set of loose cards on the table
        eg:= If table has a J house, A, 4, 5, 7, 10 then 7 cannot be used to pick up only one of {3,4} or {A,6}.

    - create a house by adding myCard and one or more sets of loose cards whose sums are of house value.
        - the player should have a card equal to the value of the new house.
        - there should not be any other group of one or more loose cards whose sum adds up to the value of this new house,
        else they should also be merged.
        - all houses with same value automatically gets added to this house.

    - Break an existing unsealed house using myCard to create a new house
        - all rules for house creation.
        - the owner of the house must not be current player.

    - seal a house by adding myCard and zero or more loose cards to an existing house.
        - the owner of the house must be current player or partner
        - the total sum of myCard and the loose cards must be equal to house rank.
        - if owner is current player, he should still have a house rank card after the play.

    - seal a house by breaking another unsealed house to create a new house of the same value and
    add these to the original house - this is treated as break house move.
     */

    private final Card card;

    Move(Card card) {
        this.card = card;
    }

    public final Card getCard() {
        return card;
    }

}
