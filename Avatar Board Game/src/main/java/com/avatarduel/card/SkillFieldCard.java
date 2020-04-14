package com.avatarduel.card;

public class SkillFieldCard extends FieldCard{
    private SkillCard skillCard;

    public SkillFieldCard(int field, SkillCard skillCard){
        super(field);
        this.skillCard = skillCard;
    }

    public SkillCard getSkillCard(){return this.skillCard;}
}