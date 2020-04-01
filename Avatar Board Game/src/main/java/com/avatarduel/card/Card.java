package com.avatarduel.card;

public abstract class Card {
    protected String name;
    protected String description;
    protected Element element;

    public Card() {
        this.name = "";
        this.description = "";
        this.element = Element.AIR;
    }

    public Card(String name, String description, Element element) {
        this.name = name;
        this.description = description;
        this.element = element;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return  this.description;
    }

    public Element getElement() {
        return this.element;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setElement(Element element) {
        this.element = element;
    }

    public void InfoCard() {
        System.out.println("Name\t : " + this.name);
        System.out.println("Desc\t : " + this.description);
        System.out.println("Element\t : " + this.element);
    }
}
