package com.avatarduel.card;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class CardCollection {
    private List<Card> cardCollection;

    public CardCollection() {
        cardCollection = new ArrayList<Card>();
    }

    public void addCard(Card newCard) {
        cardCollection.add(newCard);
    }

    public Card getCardAt(int i) { return cardCollection.get(i); }

    public int getSize() { return cardCollection.size(); }

    public void shuffle() {
        Collections.shuffle(cardCollection);
    }

    public void printCards() {
        for (int i = 0; i < cardCollection.size(); i++) {
            cardCollection.get(i).InfoCard();
            System.out.println();
        }
    }
}