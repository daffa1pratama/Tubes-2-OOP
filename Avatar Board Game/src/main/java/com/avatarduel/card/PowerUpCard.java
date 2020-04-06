package com.avatarduel.card;

public class PowerUpCard extends SkillCard {
    public PowerUpCard(String name, String description, Element element, int attack, int defense, int power) {
        super(name, description, element, attack, defense, power);
    }

    public void Effect (CharacterFieldCard characterFieldCard) {
        // If enemy position defense, attack is same as enemy position attack
        if (characterFieldCard.getPosition() == 0) {
            // Attack
        }
    }
}
