package com.avatarduel.card;

public class AuraCard extends SkillCard {
    private int addAttack;
    private int addDefense;

    public void Effect(CharacterFieldCard characterFieldCard) {
        int currAttack = characterFieldCard.getCharacterCard().getAttack();
        int currDefense = characterFieldCard.getCharacterCard().getDefense();
        characterFieldCard.getCharacterCard().setAttack(currAttack + this.addAttack);
        characterFieldCard.getCharacterCard().setDefense(currDefense + this.addDefense);
    }

    @Override
    public void InfoCard() {
        super.InfoCard();
        System.out.println("Aura Attack\t : " + this.addAttack);
        System.out.println("Aura Defense\t : " + this.addDefense);
    }
}
