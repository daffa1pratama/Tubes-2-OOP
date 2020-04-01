package com.avatarduel.card;

public class AuraCard extends SkillCard {
    private int addAttack;
    private int addDefense;

    public void Effect(CharacterCard characterCard) {
        int currAttack = characterCard.getAttack();
        int currDefense = characterCard.getDefense();
        characterCard.setAttack(currAttack + this.addAttack);
        characterCard.setDefense(currDefense + this.addDefense);
    }

    @Override
    public void InfoCard() {
        super.InfoCard();
        System.out.println("Aura Attack\t : " + this.addAttack);
        System.out.println("Aura Defense\t : " + this.addDefense);
    }
}
