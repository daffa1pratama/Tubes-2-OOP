package com.avatarduel.card;


public class CharacterFieldCard implements iFieldCard {
    private CharacterCard characterCard;
    private int position; //0 defense 1 attack
    private int isAvailableAttack; // Set to attack on next turn
    private int isRotatable;

    // public CharacterFieldCard(){
    //     this.characterCard = new CharacterCard();
    //     this.position=0;
    //     this.isAvailableAttack=0;
    //     this.isRotatable = 1;
    // }

    public CharacterFieldCard(CharacterCard  characterCard,int position,int isAvailableAttack){
        this.characterCard = new CharacterCard(characterCard.getName(),characterCard.getDescription(),characterCard.getElement(),characterCard.getPathName(),characterCard.getAttack(),characterCard.getDefense(),characterCard.getPower());
        this.position = position;
        this.isAvailableAttack = isAvailableAttack;
        this.isRotatable = 1;
    }

    public CharacterCard getCharacterCard(){return this.characterCard;}

    public int getPosition() {
        return this.position;
    }

    public int getBattleAvailability(){return this.isAvailableAttack;}

    public void setBattleAvailability(int isAvailableAttack){this.isAvailableAttack = isAvailableAttack;}


    @Override
    public int getIsRotateAble() {
        return this.isRotatable;
    }

    @Override
    public void setIsRotatable(int isRotatable) {
        this.isRotatable = isRotatable;
    }

    @Override
    public void setPositionValue(int position) {
        this.position = position;
    }

    @Override
    public void rotate() {
        this.position = (this.position + 1) % 2;
    }

    @Override
    public int getPositionValue() {
        if (this.position == 0) {
            return this.characterCard.getAttack();
        }
        return this.characterCard.getDefense();
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