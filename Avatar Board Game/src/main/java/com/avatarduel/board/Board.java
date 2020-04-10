package com.avatarduel.board;

import com.avatarduel.deck.Deck;
import com.avatarduel.player.Player;
import com.avatarduel.card.CardCollection;
import com.avatarduel.card.CharacterCard;
import com.avatarduel.card.Card;
import com.avatarduel.card.Element;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.text.*;
import javafx.scene.control.*;
import javafx.scene.Group;

public class Board {

    private Player p1;
    private Player p2;
    private Player winner;
    private Player currentPlayer;
    private int turn; //1 or 2

    //MAIN BOARD IMPLEMENTS HERE
    public Player getP1() { return this.p1; }
    public Player getP2() { return this.p2; }
    public int getTurn() { return this.turn; }
    public void switchTurn() { if (turn == 1) turn = 2; else turn = 1; }

    public Board(CardCollection characterCardCollection, CardCollection landCardCollection, CardCollection auraCardCollection, CardCollection destroyCardCollection, CardCollection powerupCardCollection) {
        this.p1 = new Player("P1", characterCardCollection, landCardCollection, auraCardCollection, destroyCardCollection, powerupCardCollection);
        this.p2 = new Player("P2", characterCardCollection, landCardCollection, auraCardCollection, destroyCardCollection, powerupCardCollection);
        this.turn = 1;
        this.winner = null;
        this.currentPlayer = this.p1;
        for (int i = 0; i < 7; i++) this.p1.drawCard();
        for (int i = 0; i < 7; i++) this.p2.drawCard();
    }

    public void printCards() {
        // Careful. Both decks will be emptied. For debugging purposes only.
        System.out.println("Player 1:");
        Deck D1 = this.p1.getDeck();
        for (int i = 0; i < D1.getDeckCount(); i++) {
            Card C = D1.drawCard();
            C.InfoCard();
        }
        System.out.println();
        System.out.println("Player 2:");
        Deck D2 = this.p2.getDeck();
        for (int i = 0; i < D2.getDeckCount(); i++) {
            Card C = D2.drawCard();
            C.InfoCard();
        }
    }
}
