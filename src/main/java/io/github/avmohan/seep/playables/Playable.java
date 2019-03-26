package io.github.avmohan.seep.playables;

import io.github.avmohan.seep.cards.Card;
import io.github.avmohan.seep.cards.Rank;
import org.pcollections.PCollection;

public interface Playable {
    Rank getRank();

    PCollection<Card> getCards();
}
