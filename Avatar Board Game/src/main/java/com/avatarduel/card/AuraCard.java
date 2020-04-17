package com.avatarduel.card;

import com.avatarduel.fieldcard.CharacterFieldCard;

/**
 * AuraCard is a class that defines an aura card.
 *
 * @author Kelompok 9 K3
 */
public class AuraCard extends SkillCard {
    private int attack;
    private int defense;

    /**
     * Creates an aura card.
     * @param name Name of the card.
     * @param description Description of the card.
     * @param element Element of the card.
     * @param imagePath Image path of the card.
     * @param attack Card's attack value.
     * @param defense Card's defense value.
     * @param power Card's power value.
     */
    public AuraCard(String name, String description, Element element,String imagePath, int attack, int defense, int power) {
        super(name, description, element,imagePath, power);
        this.attack = attack;
        this.defense = defense;
    }

    /**
     *
     * @return Card's attack value.
     */
    public int getAttack() {
        return this.attack;
    }

    /**
     *
     * @return Card's defense value.
     */
    public int getDefense() {
        return this.defense;
    }

    /**
     * Applies a buff/debuff to a character field card.
     * @param characterFieldCard Character field card to apply the buff.
     */
    public void effect(CharacterFieldCard characterFieldCard) {
        int currAttack = characterFieldCard.getCharacterCard().getAttack();
        int currDefense = characterFieldCard.getCharacterCard().getDefense();
        characterFieldCard.getCharacterCard().setAttack(currAttack + this.attack);
        characterFieldCard.getCharacterCard().setDefense(currDefense + this.defense);
    }

    /**
     * Undo a buff/debuff to a character field card.
     * @param characterFieldCard Character field card to undo the buff.
     */
    public void reverseEffect(CharacterFieldCard characterFieldCard){
        int normalAtk = characterFieldCard.getCharacterCard().getAttack();
        int normalDef = characterFieldCard.getCharacterCard().getDefense();
        characterFieldCard.getCharacterCard().setAttack(normalAtk - this.attack);
        characterFieldCard.getCharacterCard().setDefense(normalDef - this.defense);
    }

    /**
     * Outputs the card's information to the console.
     */
    @Override
    public void InfoCard() {
        super.InfoCard();
        System.out.println("Aura Attack\t : " + this.attack);
        System.out.println("Aura Defense\t : " + this.defense);
    }
}
