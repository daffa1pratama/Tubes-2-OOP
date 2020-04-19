package com.avatarduel.card;

/**
 * Card is a class that defines a card.
 *
 * @author Kelompok 9 K3
 */
public abstract class Card {
    protected String name;
    protected String description;
    protected Element element;
    protected String imagePath;

    /**
     * Creates a card.
     * @param name Name of the card.
     * @param description Description of the card.
     * @param element Element of the card.
     * @param imagePath Image path of the card.
     */
    public Card(String name, String description, Element element, String imagePath) {
        this.name = name;
        this.description = description;
        this.element = element;
        this.imagePath = imagePath;
    }

    /**
     *
     * @return Card's name.
     */
    public String getName() {
        return this.name;
    }

    /**
     *
     * @return Card's description.
     */
    public String getDescription() {
        return  this.description;
    }

    /**
     *
     * @return Card's element.
     */
    public Element getElement() {
        return this.element;
    }

    /**
     *
     * @return Card's image path.
     */
    public String getImagePath() {
        return this.imagePath;
    }

    /**
     * Outputs the card's information to the console.
     */
    public void infoCard() {
        System.out.println("Name\t : " + this.name);
        System.out.println("Desc\t : " + this.description);
        System.out.println("Element\t : " + this.element);
    }
}
