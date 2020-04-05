package com.avatarduel.board;

import com.avatarduel.deck.Deck;
import com.avatarduel.player.Player;
import com.avatarduel.card.CardCollection;
import com.avatarduel.card.Card;

public class Board {
    private Player p1;
    private Player p2;
    private Player winner;
    private Player currentPlayer;
    private int turn; //1 or 2

    //MAIN BOARD IMPLEMENTS HERE

    public Board(CardCollection characterCardCollection, CardCollection landCardCollection, CardCollection skillCardCollection) {
        this.p1 = new Player("P1", characterCardCollection, landCardCollection, skillCardCollection);
        this.p2 = new Player("P2", characterCardCollection, landCardCollection, skillCardCollection);
        this.turn = 1;
    }

    public void printCards() {
        // Careful. Both decks will be emptied. For debugging purposes only.
        System.out.println("Player 1:");
        Deck D1 = this.p1.getDeck();
        for (int i = 0; i < D1.getDeckSize(); i++) {
            Card C = D1.drawCard();
            C.InfoCard();
        }
        System.out.println();
        System.out.println("Player 2:");
        Deck D2 = this.p2.getDeck();
        for (int i = 0; i < D2.getDeckSize(); i++) {
            Card C = D2.drawCard();
            C.InfoCard();
        }
    }
}
