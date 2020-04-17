package com.avatarduel.fieldcard;

import com.avatarduel.card.SkillCard;

public class SkillFieldCard extends FieldCard {
    private final SkillCard skillCard;//required
    private CharacterFieldCard owner;//optional

    //Private Constructor
    private SkillFieldCard(int field,SkillFieldCardBuilder builder){
        super(field);
        this.skillCard = builder.skillCard;
        this.owner = builder.owner;
    }
    public void setOwner(CharacterFieldCard characterFieldCard){
        this.owner = characterFieldCard;
    }

    public SkillCard getSkillCard() {return this.skillCard;}

    public CharacterFieldCard getOwner(){return this.owner;}

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
