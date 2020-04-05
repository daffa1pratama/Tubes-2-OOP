package com.avatarduel.deck;

import java.util.Random;
import java.util.LinkedList;
import com.avatarduel.card.Card;
import com.avatarduel.card.CharacterCard;
import com.avatarduel.card.CardCollection;

import java.util.Queue;

public class Deck {
    private Queue<Card> deckContainer;
    private int deckSize;

    public Deck(CardCollection characterCardCollection, CardCollection landCardCollection, CardCollection skillCardCollection) {
        this.deckSize = 40;
        buildDeck(characterCardCollection, landCardCollection, skillCardCollection);
    }

    public int getDeckSize() { return this.deckSize; }

    public Card drawCard() {
        return this.deckContainer.remove();
    }

    public void buildDeck(CardCollection characterCardCollection, CardCollection landCardCollection, CardCollection skillCardCollection) {
        CardCollection chosenCards = new CardCollection();
        Random r = new Random();
        for (int i = 0; i < 25; i++) {
            int x = r.nextInt(characterCardCollection.getSize());
            chosenCards.addCard(characterCardCollection.getCardAt(x));
        }
        for (int i = 0; i < 10; i++) {
            int x = r.nextInt(landCardCollection.getSize());
            chosenCards.addCard(landCardCollection.getCardAt(x));
        }
        for (int i = 0; i < 5; i++) {
            int x = r.nextInt(skillCardCollection.getSize());
            chosenCards.addCard(skillCardCollection.getCardAt(x));
        }
        chosenCards.shuffle();
        deckContainer = new LinkedList();
        for (int i = 0; i < deckSize; i++) {
            deckContainer.add(chosenCards.getCardAt(i));
        }
    }
}
