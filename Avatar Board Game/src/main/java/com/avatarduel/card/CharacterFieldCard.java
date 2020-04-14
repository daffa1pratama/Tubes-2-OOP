package com.avatarduel.card;

public class CharacterFieldCard extends FieldCard{
    private CharacterCard characterCard;
    private int position; //0 defense 1 attack
    private int isAvailableAttack; // Set to attack on next turn
    private int isRotatable;

    public CharacterFieldCard(int field, CharacterCard characterCard){
        super(field);
        this.characterCard = new CharacterCard(characterCard.getName(),characterCard.getDescription(),characterCard.getElement(),characterCard.getPathName(),characterCard.getAttack(),characterCard.getDefense(),characterCard.getPower());
        this.position = 1;
        this.isAvailableAttack = 0;
        this.isRotatable = 1;
    }

    public CharacterCard getCharacterCard(){return this.characterCard;}
    public int getBattleAvailability(){return this.isAvailableAttack;}

    public void setBattleAvailability(int isAvailableAttack){this.isAvailableAttack = isAvailableAttack;}

    public int getIsRotateAble() { return this.isRotatable; }

    public void setIsRotatable(int isRotatable) { this.isRotatable = isRotatable; }

    public void setPositionValue(){position = (position+1)%2; }

    public void rotate() { this.position = (this.position + 1) % 2; }

    public int getPosition() { return this.position; }



//    public int getPositionValue() {
//        if (this.position == 0) {
//            return this.characterCard.getAttack();
//        }
//        return this.characterCard.getDefense();
//    }
//
//    public void AttackEnemy(com.avatarduel.card.CharacterFieldCard enemyCard) {
//        //Enemy defense role
//        if (enemyCard.getPosition() == 0) {
//
//        }
//        //Enemy attack role
//        else {
//
//        }
//    }


    }
