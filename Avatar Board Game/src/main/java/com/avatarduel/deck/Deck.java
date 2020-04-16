package com.avatarduel.deck;

import java.util.Random;
import java.util.LinkedList;
import com.avatarduel.card.Card;
import com.avatarduel.card.CardCollection;

import java.util.Queue;

public class Deck {
    private Queue<Card> deckContainer;
    private int deckSize;
    public boolean deckEmpty;

    public Deck(CardCollection characterCardCollection, CardCollection landCardCollection, CardCollection auraCardCollection, CardCollection destroyCardCollection, CardCollection powerupCardCollection) {
        this.deckSize = 50;
        buildDeck(characterCardCollection, landCardCollection, auraCardCollection, destroyCardCollection, powerupCardCollection);
        this.deckEmpty = false;
    }

    public int getDeckCount() { return this.deckContainer.size(); }

    public Card drawCard() {
        if (!deckContainer.isEmpty()) return this.deckContainer.remove();
        else {
            deckEmpty = true;
            return null;
        }
    }

    public boolean isDeckEmpty() {
        return this.deckEmpty;
    }

    public void buildDeck(CardCollection characterCardCollection, CardCollection landCardCollection, CardCollection auraCardCollection, CardCollection destroyCardCollection, CardCollection powerupCardCollection) {
        CardCollection chosenCards = new CardCollection();
        Random r = new Random();
        for (int i = 0; i < 20; i++) {
            int x = r.nextInt(characterCardCollection.getSize());
            chosenCards.addCard(characterCardCollection.getCardAt(x));
        }
        for (int i = 0; i < 15; i++) {
            int x = r.nextInt(landCardCollection.getSize());
            chosenCards.addCard(landCardCollection.getCardAt(x));
        }
        for (int i = 0; i < 9; i++) {
            int x = r.nextInt(auraCardCollection.getSize());
            chosenCards.addCard(auraCardCollection.getCardAt(x));
        }
        for (int i = 0; i < 3; i++) {
            int x = r.nextInt(destroyCardCollection.getSize());
            chosenCards.addCard(destroyCardCollection.getCardAt(x));
        }
        for (int i = 0; i < 3; i++) {
            int x = r.nextInt(powerupCardCollection.getSize());
            chosenCards.addCard(powerupCardCollection.getCardAt(x));
        }
        chosenCards.shuffle();
        deckContainer = new LinkedList<Card>();
        for (int i = 0; i < deckSize; i++) {
            deckContainer.add(chosenCards.getCardAt(i));
        }
    }
}
