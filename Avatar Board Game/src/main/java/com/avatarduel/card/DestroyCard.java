package com.avatarduel.card;

public class DestroyCard extends SkillCard {
    public DestroyCard(String name, String description, Element element, int attack, int defense, int power) {
        super(name, description, element, attack, defense, power);
    }

    public void Effect (CharacterFieldCard characterCard) {
        System.out.println("Destroying card...");
        //Destroy card here
    }
}
