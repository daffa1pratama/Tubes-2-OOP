package com.avatarduel.card;

public class PowerUpCard extends SkillCard {
    public void Effect (CharacterCard characterCard) {
        // If enemy position defense, attack is same as enemy position attack
        if (characterCard.getPosition() == 0) {
            // Attack
        }
    }
}
