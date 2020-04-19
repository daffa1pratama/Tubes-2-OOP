package com.avatarduel.card;

/**
 * CharacterCard is a class that defines a character card.
 *
 * @author Kelompok 9 K3
 */
public class CharacterCard extends Card {
    private int attack;
    private int defense;
    private int power;

    /**
     * Creates a character card.
     * @param name Name of the card.
     * @param description Description of the card.
     * @param element Element of the card.
     * @param imagePath Image path of the card.
     * @param attack Card's attack value.
     * @param defense Card's defense value.
     * @param power Card's power value.
     */
    public CharacterCard(String name, String description, Element element, String imagePath, int attack, int defense, int power) {
        super(name, description, element,imagePath);
        this.attack = attack;
        this.defense = defense;
        this.power = power;
    }

    /**
     *
     * @return Card's name.
     */
    public String getName() {
        return super.getName();
    }

    /**
     *
     * @return Card's attack value.
     */
    public int getAttack() {
        return this.attack;
    }

    /**
     *
     * @return Card's defense value.
     */
    public int getDefense() {
        return this.defense;
    }

    /**
     *
     * @return Card's power value.
     */
    public int getPower() {
        return this.power;
    }

    /**
     *
     * @param attack New attack value.
     */
    public void setAttack(int attack) {
        this.attack = attack;
    }

    /**
     *
     * @param defense New defense value.
     */
    public void setDefense(int defense) {
        this.defense = defense;
    }

    /**
     * Outputs the card's information to the console.
     */
    @Override
    public void infoCard() {
        super.infoCard();
        System.out.println("Attack\t : " + this.attack);
        System.out.println("Defense\t : " + this.defense);
        System.out.println("Power\t : " + this.power);
    }
}
