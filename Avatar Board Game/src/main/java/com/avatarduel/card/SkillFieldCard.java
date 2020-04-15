package com.avatarduel.card;

public class SkillFieldCard extends FieldCard{
    private SkillCard skillCard;
    //Ini blh pake design builder
    private CharacterFieldCard skillTarget;//SkillFieldCard lifetime is depend on the skillTarget

    public SkillFieldCard(int field, SkillCard skillCard){
        super(field);
        this.skillCard = skillCard;
    }

    public SkillCard getSkillCard(){return this.skillCard;}
}