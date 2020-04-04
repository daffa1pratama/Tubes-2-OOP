package com.avatarduel.board;

import com.avatarduel.player.Player;

public class Board {
    private Player p1;
    private Player p2;
    private Player winner;
    private Player currentPlayer;
    private int turn; //1 or 2

    //MAIN BOARD IMPLEMENTS HERE

    public Board() {
        this.p1 = new Player("P1");
        this.p2 = new Player("P2");
        this.turn = 1;
    }
}
