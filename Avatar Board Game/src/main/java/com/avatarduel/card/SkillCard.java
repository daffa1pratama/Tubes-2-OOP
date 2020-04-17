package com.avatarduel.card;

/**
 * SkillCard is a class that defines a skill card.
 *
 * @author Kelompok 9 K3
 */
public class SkillCard extends Card {
    private int power;

    /**
     * Creates a skill card.
     * @param name Name of the card.
     * @param description Description of the card.
     * @param element Element of the card.
     * @param imagePath Image path of the card.
     * @param power Card's power value.
     */
    public SkillCard(String name, String description, Element element,String imagePath, int power) {
        super(name, description, element,imagePath);
        this.power = power;
    }

    /**
     *
     * @return Card's power value.
     */
    public int getPower() {
        return this.power;
    }

    /**
     * Outputs the card's information to the console.
     */
    @Override
    public void InfoCard() {
        super.InfoCard();
        System.out.println("Power\t : " + this.power);
    }
}
