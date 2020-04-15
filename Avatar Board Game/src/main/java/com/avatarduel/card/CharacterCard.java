package com.avatarduel.card;

public class CharacterCard extends Card {
    private int attack;
    private int defense;
    private int power;

    public CharacterCard(String name, String description, Element element, String imagePath,int attack, int defense, int power) {
        super(name, description, element,imagePath);
        this.attack = attack;
        this.defense = defense;
        this.power = power;
    }

    public String getName(){return super.getName();}

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


    public String CardInfo() {
        String stream = "";
        stream += "Name\t : " + super.name + "\n";
        stream += "Desc\t\t : " + super.description + "\n";
        stream += "Element\t : " + super.element + "\n";
        stream += "Attack\t : " + this.attack + "\n";
        stream += "Defense\t : " + this.defense + "\n";
        stream += "Power\t : " + this.power + "\n";
        return  stream;
    }
}
