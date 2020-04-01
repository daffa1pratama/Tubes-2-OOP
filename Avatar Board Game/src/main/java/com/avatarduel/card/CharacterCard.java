package com.avatarduel.card;

public class CharacterCard extends  Card{
    private int attack;
    private int defense;
    private int power;
    private int position; // 0 : Defense ; 1 : AttackW

    public CharacterCard() {
        super();
        this.attack = 0;
        this.defense = 0;
        this.power = 0;
    }

    public CharacterCard(String name, String description, Element element, int attack, int defense, int power) {
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

    public int getPosition() {
        return this.position;
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

    public void setPosition(int position) {
        this.position = position;
    }

    @Override
    public void InfoCard() {
        super.InfoCard();
        System.out.println("Attack\t : " + this.attack);
        System.out.println("Defense\t : " + this.defense);
        System.out.println("Power\t : " + this.power);
    }

    public void changePosition() {
        if (this.position == 0) {
            setPosition(1);
        }
        else {
            setPosition(0);
        }
    }

    public void AttackEnemy(CharacterCard enemyCard) {
        //Enemy defense position
        if (enemyCard.getPosition() == 0) {

        }
        //Enemy attack position
        else {

        }
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
