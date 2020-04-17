package com.avatarduel.board;

import com.avatarduel.card.*;
import com.avatarduel.deck.Deck;
import com.avatarduel.player.Phase;
import com.avatarduel.player.Player;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.text.*;
import javafx.scene.control.*;
import javafx.scene.Group;

public class Board implements iBoard {

    private Player p1;
    private Player p2;
    private Player winner;
    private Phase phase;
    private int turn; //1 or 2

    public Board(CardReader cardReader) {
        this.p1 = new Player("P1", cardReader.getCharacterCardCollection(), cardReader.getLandCardCollection(), cardReader.getAuraCardCollection(), cardReader.getDestroyCardCollection(), cardReader.getPowerupCardCollection());
        this.p2 = new Player("P2", cardReader.getCharacterCardCollection(), cardReader.getLandCardCollection(), cardReader.getAuraCardCollection(), cardReader.getDestroyCardCollection(), cardReader.getPowerupCardCollection());
        this.turn = 1;
        this.winner = null;
        for (int i = 0; i < 8; i++) this.p1.drawCard(); // player 1 starts first, so draw 1 extra
        for (int i = 0; i < 7; i++) this.p2.drawCard();
        this.phase = Phase.DRAW;
    }

    //Getter
    public Player getP1() { return this.p1; }
    public Player getP2() { return this.p2; }
    public Player getCurrentPlayer() { if (turn == 1) return p1; else return p2; }
    public Player getOppositePlayer(){ if (turn == 1) return p2; else return p1;}
    public int getTurn() { return this.turn; }
    public Phase getPhase() { return phase; }

    @Override
    public void switchTurn(){
        if (turn == 1) turn = 2; else turn = 1;
        getCurrentPlayer().resetPower();
        getCurrentPlayer().drawCard();
        this.phase = Phase.DRAW;

    }
    
    @Override
    public void nextPhase() {
        switch (this.phase) {
            case DRAW:
                this.phase = Phase.MAIN;
                break;
            case MAIN:
                this.phase = Phase.BATTLE;
                break;
        }
    }
}
