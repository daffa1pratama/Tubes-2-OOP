package com.avatarduel.card;

/**
 * LandCard is a class that defines a land card.
 *
 * @author Kelompok 9 K3
 */
public class LandCard extends Card {

    /**
     * Creates a land card.
     * @param name Name of the card.
     * @param description Description of the card.
     * @param element Element of the card.
     * @param imagePath Image path of the card.
     */
    public LandCard(String name, String description, Element element, String imagePath) {
        super(name, description, element, imagePath);
    }

    /**
     * Outputs the card's information to the console.
     */
    @Override
    public void InfoCard() {
        super.InfoCard();
    }
}