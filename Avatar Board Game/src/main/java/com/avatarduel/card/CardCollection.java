package com.avatarduel.card;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CardCollection {
    private List<Card> cardCollection;

    public CardCollection() {
        cardCollection = new ArrayList<Card>();
    }

    public void addCard(Card newCard) {
        cardCollection.add(newCard);
    }

    public Card getCardAt(int i) { return cardCollection.get(i); }

    public void printCards() {
        for (int i = 0; i < cardCollection.size(); i++) {
            cardCollection.get(i).InfoCard();
            System.out.println();
        }
    }
}