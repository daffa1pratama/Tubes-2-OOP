package com.avatarduel.card;

public abstract class SkillCard extends Card {
    private int power;

    public int getPower() { return power; }

    public abstract void Effect(CharacterFieldCard characterFieldCard);
}
