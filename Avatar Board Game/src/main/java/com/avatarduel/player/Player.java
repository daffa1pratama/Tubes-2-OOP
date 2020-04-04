package com.avatarduel.player;

import com.avatarduel.card.Card;
import com.avatarduel.card.Element;
import com.avatarduel.deck.Deck;

import java.util.List;

public class Player {
    private String name;
    private Deck deck;
    private List<Card> onHand;
    private int hp;
    private int fire;
    private int earth;
    private int water;
    private int air;

    public Player() {
        this.name = "";
        this.deck = new Deck();
        this.hp = 80;
        this.air = 0;
        this.fire = 0;
        this.earth = 0;
        this.water = 0;
    }

    public Player(String name) {
        this.name = name;
        this.deck = new Deck();
        this.hp = 80;
        this.air = 0;
        this.fire = 0;
        this.earth = 0;
        this.water = 0;
    }

    public String getName() { return name; }

    public Deck getDeck() { return deck; }

    public List<Card> getOnHand() { return onHand; }

    public int getHp() { return hp; }

    public int getAir() { return air; }

    public int getEarth() { return earth; }

    public int getFire() { return fire; }

    public int getWater() { return water; }

    public void addPower(Element element) {
        switch (element) {
            case AIR:
                this.air++;
                break;
            case WATER:
                this.water++;
                break;
            case FIRE:
                this.fire++;
                break;
            case EARTH:
                this.earth++;
                break;
        }
    }

    public void usePower(Element element, int amount) {
        switch (element) {
            case AIR:
                this.air -= amount;
                break;
            case WATER:
                this.water -= amount;
                break;
            case FIRE:
                this.fire -= amount;
                break;
            case EARTH:
                this.earth -= amount;
                break;
        }
    }

    public void drawCard() {
        // Draw card implements later
    }

    public void endPhase() {
        // End phase implements later
    }

    public void endTurn() {
        // End turn implements later
    }

    public void placeCard(Card card) {
        // Place card implements later
    }
}
