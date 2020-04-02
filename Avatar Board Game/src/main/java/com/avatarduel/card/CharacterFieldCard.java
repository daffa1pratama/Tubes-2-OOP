package com.avatarduel.card;

public class CharacterFieldCard extends CharacterCard{
    private int role; //0 defense 1 attack
    private int isAvailableBattle;//Aktifkan jadi 1 di saat endturn (?)

    public CharacterFieldCard(){
        super();
        this.role=0;
        this.isAvailableBattle=0;
    }

    public int getRole() {
        return this.role;
    }

    public void setRole() {
        this.role = (this.role +1)%2;
        this.isAvailableBattle = 0;
    }

    public int getBattleAvailability(){return this.isAvailableBattle;}

    public void setOffBattleAvailability(){this.isAvailableBattle = 1;}

    public void AttackEnemy(CharacterFieldCard enemyCard) {
        //Enemy defense role
        if (enemyCard.getRole() == 0) {

        }
        //Enemy attack role
        else {

        }
    }


}