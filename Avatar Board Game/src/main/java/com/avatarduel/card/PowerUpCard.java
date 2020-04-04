package com.avatarduel.card;

public class PowerUpCard extends SkillCard {

    public void Effect (CharacterFieldCard characterFieldCard) {
        // If enemy position defense, attack is same as enemy position attack
        if (characterFieldCard.getPosition() == 0) {
            // Attack
        }
    }
}
