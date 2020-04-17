package com.avatarduel.board;

/**
 * Interface that act as a contract which should be implement by class Board
 * A Board class should always consist of swithTurn() and nextPhase() method
 */
public interface iBoard {
    public void switchTurn();
    public void nextPhase();
}
