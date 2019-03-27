package io.github.avmohan.seep.core;

import io.github.avmohan.seep.cards.Card;
import io.github.avmohan.seep.cards.Rank;
import io.github.avmohan.seep.moves.Move;
import io.github.avmohan.seep.playables.Playable;
import org.pcollections.HashTreePSet;

import java.util.Collection;
import java.util.List;
import java.util.Set;

public class Player {

    private boolean isFirstMove;
    private Set<Card> hand;
    private final int playerNumber;

    public Player(boolean isFirstMove, int playerNumber) {
        this.playerNumber = playerNumber;
        this.isFirstMove = false;
        this.hand = HashTreePSet.empty();
    }

    /**
     * Notify the player of a move that was played by a particular player
     * and the state after this move.
     * @param move The move that was played.
     * @param whoPlayed The player who played the move.
     * @param afterState The state of the table after this move.
     */
    public void onMove(Move move, int whoPlayed, List<Playable> afterState) {

    }

    /**
     * Get the bid rank (only for firstmove)
     * @return
     */
    public Rank getBid() {
        if (!isFirstMove) {
            throw new IllegalStateException("Not the first move");
        }
        // TODO
        return null;
    }

    /**
     * Get the move to be played.
     * @return
     */
    public Move getMove() {
        if (isFirstMove) {
            // TODO
        } else {
            // TODO
        }
        return null;
    }

    /**
     * Deal cards to the player.
     * @param cards Cards dealt to the player.
     */
    public void dealCards(Collection<Card> cards) {
        hand.addAll(cards);
    }

}
