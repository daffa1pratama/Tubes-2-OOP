package com.avatarduel.card;

import com.avatarduel.fieldcard.CharacterFieldCard;

public class AuraCard extends SkillCard {
    private int attack;
    private int defense;

    public AuraCard(String name, String description, Element element,String imagePath, int attack, int defense, int power) {
        super(name, description, element,imagePath, power);
        this.attack = attack;
        this.defense = defense;
    }

    public int getAttack() {
        return this.attack;
    }

    public int getDefense() {
        return this.defense;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public void effect(CharacterFieldCard characterFieldCard) {
        int currAttack = characterFieldCard.getCharacterCard().getAttack();
        int currDefense = characterFieldCard.getCharacterCard().getDefense();
        characterFieldCard.getCharacterCard().setAttack(currAttack + this.attack);
        characterFieldCard.getCharacterCard().setDefense(currDefense + this.defense);
    }

    public void reverseEffect(CharacterFieldCard characterFieldCard){
        int normalAtk = characterFieldCard.getCharacterCard().getAttack();
        int normalDef = characterFieldCard.getCharacterCard().getDefense();
        characterFieldCard.getCharacterCard().setAttack(normalAtk - this.attack);
        characterFieldCard.getCharacterCard().setDefense(normalDef - this.defense);
    }

    @Override
    public void InfoCard() {
        super.InfoCard();
        System.out.println("Aura Attack\t : " + this.attack);
        System.out.println("Aura Defense\t : " + this.defense);
    }
}
