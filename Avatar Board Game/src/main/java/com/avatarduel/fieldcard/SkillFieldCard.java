package com.avatarduel.fieldcard;

import com.avatarduel.card.SkillCard;

/**
 * SkillFieldCard is the class that represents skill card that is on deployed on the field.
 * @author Kelompok 9 K3
 */
public class SkillFieldCard extends FieldCard {
    /**
     * skillCard is a required attribute for all instance of SkillFieldCard.It is declared final so it can't be modified once an object of this class is created
     */
    private final SkillCard skillCard;
    /**
     * owner is an optional attribute only for instance of SkillFieldCard that has already been used or attached on some CharacterFieldCard
     */
    private CharacterFieldCard owner;

    /**
     * Private Constructor
     * @param field determine the field/side of the board that the card belongs
     * @param builder is the builder for building SkillFieldCard
     */
    private SkillFieldCard(int field,SkillFieldCardBuilder builder){
        super(field);
        this.skillCard = builder.skillCard;
        this.owner = builder.owner;
    }

    /**
     * getter of skillCard
     * @return skillCard
     */
    public SkillCard getSkillCard() {return this.skillCard;}
    /**
     * getter of owner
     * @return owner
     */
    public CharacterFieldCard getOwner(){return this.owner;}


    /**
     * Setter for owner
     * @param characterFieldCard Which character field card this skill card applied
     */
    public void setOwner(CharacterFieldCard characterFieldCard){
        this.owner = characterFieldCard;
    }

    /**
     * SkillFieldCardBuilder is the builder class for SkillFieldCard
     */
    public static class SkillFieldCardBuilder{
        private final SkillCard skillCard;//Require
        private CharacterFieldCard owner;//Optional

        public SkillFieldCardBuilder(int field,SkillCard skillCard){
            this.skillCard = skillCard;
        }
        public SkillFieldCardBuilder owner(CharacterFieldCard owner){
            this.owner = owner;
            return this;
        }
        //Return the finally constructed object
        public SkillFieldCard build(int field){
            SkillFieldCard skillFieldCard = new SkillFieldCard(field,this);
            return skillFieldCard;
        }
    }
}
