package com.avatarduel.card;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

/**
 * CardCollection is a class that defines a collection of cards.
 *
 * @author Kelompok 9 K3
 */
public class CardCollection {
    private List<Card> cardCollection;

    /**
     * Creates an empty card collection.
     */
    public CardCollection() {
        cardCollection = new ArrayList<Card>();
    }

    /**
     * Adds a card into the card collection.
     * @param newCard Card to be added.
     */
    public void addCard(Card newCard) {
        cardCollection.add(newCard);
    }

    /**
     *
     * @param i Index needed.
     * @return Card from the card collection that corresponds to the index.
     */
    public Card getCardAt(int i) { return cardCollection.get(i); }

    /**
     *
     * @return Size of the card collection
     */
    public int getSize() { return cardCollection.size(); }

    /**
     * Shuffles the card collection
     */
    public void shuffle() {
        Collections.shuffle(cardCollection);
    }
}