package com.avatarduel.player;

import com.avatarduel.card.Card;
import com.avatarduel.deck.Deck;

public class Player {
    private String name;
    private Deck deck;
    private int hp;
    private Turn turn;
//    private int fire;
//    private int earth;
//    privage int water;
//    private int air;
//    private Field field;

    public Player() {
        this.name = "";
        this.deck = new Deck();
        this.hp = 80;
        this.turn = new Turn();
    }


}
