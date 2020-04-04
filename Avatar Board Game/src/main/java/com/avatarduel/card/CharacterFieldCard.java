package com.avatarduel.card;

public class CharacterFieldCard extends CharacterCard implements iFieldCard {
    private int position; //0 defense 1 attack
    private int isAvailableAttack; // Set to attack on next turn

    public CharacterFieldCard(){
        super();
        this.position=0;
        this.isAvailableAttack=0;
    }

    public int getPosition() {
        return this.position;
    }

    public int getBattleAvailability(){return this.isAvailableAttack;}

    public void setOffBattleAvailability(){this.isAvailableAttack = 1;}

    @Override
    public void rotate() {
        this.position = (this.position + 1) % 2;
    }

    @Override
    public int getPositionValue() {
        if (this.position == 0) {
            return super.getAttack();
        }
        return super.getDefense();
    }

    public void AttackEnemy(CharacterFieldCard enemyCard) {
        //Enemy defense role
        if (enemyCard.getPosition() == 0) {

        }
        //Enemy attack role
        else {

        }
    }


}