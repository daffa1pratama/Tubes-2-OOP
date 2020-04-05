package com.avatarduel.card;

public class SkillCard extends Card {
    private int attack;
    private int defense;
    private int power;

    public SkillCard() {
        super();
        this.attack = 0;
        this.defense = 0;
        this.power = 0;
    }

    public SkillCard(String name, String description, Element element, int attack, int defense, int power) {
        super(name, description, element);
        this.attack = attack;
        this.defense = defense;
        this.power = power;
    }

    public int getAttack() {
        return this.attack;
    }

    public int getDefense() {
        return this.defense;
    }

    public int getPower() {
        return this.power;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public void setPower(int power) {
        this.power = power;
    }

    @Override
    public void InfoCard() {
        super.InfoCard();
        System.out.println("Attack\t : " + this.attack);
        System.out.println("Defense\t : " + this.defense);
        System.out.println("Power\t : " + this.power);
    }
}
