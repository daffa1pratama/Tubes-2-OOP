package com.avatarduel.player;

import com.avatarduel.card.Card;
import com.avatarduel.deck.Deck;

public class Player {
    private String name;
    private Deck deck;
    private Card[] onHand;
    private int hp;
    //private int fire;
    //private int earth;
    //privage int water;
    //private int air;

    public Player() {
        this.name = "";
        this.deck = new Deck();
        this.hp = 80;
    }
}
