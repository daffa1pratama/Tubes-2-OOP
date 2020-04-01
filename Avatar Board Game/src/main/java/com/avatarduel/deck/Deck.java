package com.avatarduel.deck;

import com.avatarduel.card.Card;
import com.avatarduel.card.CharacterCard;

import java.util.Queue;

public class Deck {
    private Queue<Card> deckContainer;
    private int deckSize;

    public Deck() {
        this.deckSize = 40;
        ShuffleCard();
    }

    public Card drawCard() {
        return this.deckContainer.remove();
    }

    public void ShuffleCard() {
        for(int i = 0; i <= this.deckSize; i++) {
            //Shuffle card implements later
            deckContainer.add(new CharacterCard());
        }
    }
}
