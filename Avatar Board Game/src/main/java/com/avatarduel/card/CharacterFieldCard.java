package com.avatarduel.card;

import java.util.ArrayList;
import java.util.List;

public class CharacterFieldCard extends FieldCard{
    private CharacterCard characterCard;
    private int position; //0 defense 1 attack
    private int isAvailableAttack; // Set to attack on next turn
    private List<SkillFieldCard> skills;


    public CharacterFieldCard(int field, CharacterCard characterCard){
        super(field);
        this.characterCard = new CharacterCard(characterCard.getName(),characterCard.getDescription(),characterCard.getElement(),characterCard.getPathName(),characterCard.getAttack(),characterCard.getDefense(),characterCard.getPower());
        this.position = 1;
        this.isAvailableAttack = 0;
        this.skills = new ArrayList<SkillFieldCard>();
    }

    public List<SkillFieldCard>getSkills(){ return this.skills;}

    public void addSkills(SkillFieldCard skillFieldCard){this.skills.add(skillFieldCard);}

    public CharacterCard getCharacterCard(){return this.characterCard;}

    public int getBattleAvailability(){return this.isAvailableAttack;}

    public void setBattleAvailability(int isAvailableAttack){this.isAvailableAttack = isAvailableAttack;}

    public void setPositionValue(){position = (position+1)%2; }

    public void rotate() { this.position = (this.position + 1) % 2; }

    public int getPosition() { return this.position; }

    public boolean hasPowerUp(){
        boolean has = false;
        for (SkillFieldCard skills : this.getSkills()){
            if (skills.getSkillCard() instanceof PowerUpCard){
                has = true;
                break;
            }
        }
        return has;
    }
}
