package com.avatarduel.card;

/**
 * PowerUpCard is a class that defines a powerup card.
 *
 * @author Kelompok 9 K3
 */
public class PowerUpCard extends SkillCard {

    /**
     * Creates a character card.
     * @param name Name of the card.
     * @param description Description of the card.
     * @param element Element of the card.
     * @param imagePath Image path of the card.
     * @param power Card's power value.
     */
    public PowerUpCard(String name, String description, Element element,String imagePath, int power) {
        super(name, description, element, imagePath, power);
    }
}
