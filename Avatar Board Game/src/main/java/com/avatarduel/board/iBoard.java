package com.avatarduel.board;

/**
 * Interface that act as a contract which should be implement by class Board
 * A Board class should always consist of switchTurn() and nextPhase() method
 *
 * @author Kelompok 9 K3
 */
public interface iBoard {
    /**
     * Switches the player's turn. Resets player's power and draws one card.
     */
    public void switchTurn();

    /**
     * Moves player to the next phase.
     */
    public void nextPhase();
}
