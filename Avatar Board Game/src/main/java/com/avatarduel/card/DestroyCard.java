package com.avatarduel.card;

/**
 * CharacterCard is a class that defines a destroy card.
 *
 * @author Kelompok 9 K3
 */
public class DestroyCard extends SkillCard {
    /**
     * Creates a destroy card.
     * @param name Name of the card.
     * @param description Description of the card.
     * @param element Element of the card.
     * @param imagePath Image path of the card.
     * @param power Card's power value.
     */
    public DestroyCard(String name, String description, Element element, String imagePath, int power) {
        super(name, description, element, imagePath, power);
    }
}
