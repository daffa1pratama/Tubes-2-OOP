package com.avatarduel.board;

import com.avatarduel.player.Phase;
import com.avatarduel.player.Player;
import com.avatarduel.util.CardReader;

import java.io.IOException;

/**
 * Board is a class that defines the game board.
 *
 * @author Kelompok 9 K3.
 */
public class Board implements iBoard {

    private Player p1;
    private Player p2;
    private Phase phase;
    /**
     * Shows which player's turn it is now.
     */
    private int turn;

    /**
     * Creates a new board. Initializes a new game.
     * @param cardReader the initialized card reader that contains collection of cards.
     */
    public Board(CardReader cardReader) {
        this.p1 = new Player("P1", cardReader.getCharacterCardCollection(), cardReader.getLandCardCollection(), cardReader.getAuraCardCollection(), cardReader.getDestroyCardCollection(), cardReader.getPowerupCardCollection());
        this.p2 = new Player("P2", cardReader.getCharacterCardCollection(), cardReader.getLandCardCollection(), cardReader.getAuraCardCollection(), cardReader.getDestroyCardCollection(), cardReader.getPowerupCardCollection());
        this.turn = 1;
        for (int i = 0; i < 8; i++) this.p1.drawCard(); // player 1 starts first, so draw 1 extra
        for (int i = 0; i < 7; i++) this.p2.drawCard();
        this.phase = Phase.DRAW;
    }

    /**
     * @return player 1 object.
     */
    public Player getP1() { return this.p1; }

    /**
     * @return player 2 object.
     */
    public Player getP2() { return this.p2; }

    /**
     * @return current player object according to current turn.
     */
    public Player getCurrentPlayer() { if (turn == 1) return p1; else return p2; }

    /**
     * @return opponent player object according to current turn.
     */
    public Player getOppositePlayer() { if (turn == 1) return p2; else return p1; }

    /**
     * @return integer. current turn.
     */
    public int getTurn() { return this.turn; }

    /**
     * @return current phase.
     */
    public Phase getPhase() { return phase; }

    /**
     * Switches the player's turn. Resets player's power and draws one card.
     */
    @Override
    public void switchTurn(){
        if (turn == 1) turn = 2; else turn = 1;
        this.phase = Phase.DRAW;
        getCurrentPlayer().resetPower();
        getCurrentPlayer().drawCard();
    }

    /**
     * Moves player to the next phase.
     */
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
