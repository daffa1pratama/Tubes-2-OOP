package com.avatarduel.deck;

import java.util.Random;
import java.util.LinkedList;
import com.avatarduel.card.Card;
import com.avatarduel.card.CardCollection;

import java.util.Queue;

/**
 * Deck is a class that defines a deck.
 *
 * @author Kelompok 9 K3
 */
public class Deck {
    private Queue<Card> deckContainer;
    private int deckSize;
    public boolean deckEmpty;
    private CardCollection characterCardCollection;
    private CardCollection landCardCollection;
    private CardCollection auraCardCollection;
    private CardCollection destroyCardCollection;
    private CardCollection powerupCardCollection;

    /**
     * Creates a new deck of cards consisting of 50 cards.
     * @param characterCardCollection CardCollection of character cards.
     * @param landCardCollection CardCollection of land cards.
     * @param auraCardCollection CardCollection of aura cards.
     * @param destroyCardCollection CardCollection of destroy cards.
     * @param powerupCardCollection CardCollection of powerup cards.
     */
    public Deck(CardCollection characterCardCollection, CardCollection landCardCollection, CardCollection auraCardCollection, CardCollection destroyCardCollection, CardCollection powerupCardCollection) {
        this.deckSize = 50;
        this.characterCardCollection = characterCardCollection;
        this.landCardCollection = landCardCollection;
        this.auraCardCollection = auraCardCollection;
        this.destroyCardCollection = destroyCardCollection;
        this.powerupCardCollection = powerupCardCollection;
        buildDeck();
        this.deckEmpty = false;
    }

    /**
     *
     * @return Size of this deck.
     */
    public int getDeckCount() { return this.deckContainer.size(); }

    /**
     * Draws a card by popping the front card of the deck.
     * @return A card if the deck is not empty or null if empty.
     */
    public Card drawCard() {
        if (!deckContainer.isEmpty()) return this.deckContainer.remove();
        else {
            deckEmpty = true;
            return null;
        }
    }

    /**
     *
     * @return False if the deck is not empty or True if empty.
     */
    public boolean isDeckEmpty() {
        return this.deckEmpty;
    }

    /**
     * Builds a random deck based on the given card collections.
     * <p>
     * Final deck count:
     * <ul>
     * <li>Character = 20</li>
     * <li>Land = 20</li>
     * <li>Aura = 6</li>
     * <li>Destroy = 2</li>
     * <li>Powerup = 2</li>
     * </ul>
     */
    public void buildDeck() {
        CardCollection chosenCards = new CardCollection();
        Random r = new Random();
        for (int i = 0; i < 20; i++) {
            int x = r.nextInt(characterCardCollection.getSize());
            chosenCards.addCard(characterCardCollection.getCardAt(x));
        }
        for (int i = 0; i < 20; i++) {
            int x = r.nextInt(landCardCollection.getSize());
            chosenCards.addCard(landCardCollection.getCardAt(x));
        }
        for (int i = 0; i < 6; i++) {
            int x = r.nextInt(auraCardCollection.getSize());
            chosenCards.addCard(auraCardCollection.getCardAt(x));
        }
        for (int i = 0; i < 2; i++) {
            int x = r.nextInt(destroyCardCollection.getSize());
            chosenCards.addCard(destroyCardCollection.getCardAt(x));
        }
        for (int i = 0; i < 2; i++) {
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
