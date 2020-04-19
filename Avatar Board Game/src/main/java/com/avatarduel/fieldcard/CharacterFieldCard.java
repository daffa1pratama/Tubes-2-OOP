package com.avatarduel.fieldcard;

import com.avatarduel.card.CharacterCard;
import com.avatarduel.card.PowerUpCard;

import java.util.ArrayList;
import java.util.List;

/**
 * CharacterFieldCard is a class that defines a character field card.
 *
 * @author Kelompok 9 K3
 */
public class CharacterFieldCard extends FieldCard {
    private CharacterCard characterCard;
    /**
     * Card's position. 0 if defense and 1 if attack.
     */
    private int position;
    /**
     * Card's attack status. 0 if it is unavailable to attack, 1 if available.
     */
    private int isAvailableAttack;
    /**
     * List of buffs/debuffs this card currently has.
     */
    private List<SkillFieldCard> skills;

    /**
     * Creates a character field card.
     * @param field Which field is this card on (1 or 2).
     * @param characterCard The character card that is placed in the field.
     */
    public CharacterFieldCard(int field, CharacterCard characterCard){
        super(field);
        this.characterCard = new CharacterCard(characterCard.getName(),characterCard.getDescription(),characterCard.getElement(),characterCard.getImagePath(),characterCard.getAttack(),characterCard.getDefense(),characterCard.getPower());
        this.position = 1;
        this.isAvailableAttack = 0;
        this.skills = new ArrayList<>();
    }

    /**
     * Getter skills that equipped into CharacterFieldCard
     * @return list of buffs/debuffs this card currently has.
     */
    public List<SkillFieldCard>getSkills() { return this.skills;}

    /**
     * Adds a buff/debuff to this card.
     * @param skillFieldCard Skill to be used on this card.
     */
    public void addSkills(SkillFieldCard skillFieldCard) {this.skills.add(skillFieldCard);}

    /**
     * Getter CharacterCard
     * @return This character card
     */
    public CharacterCard getCharacterCard() {return this.characterCard;}

    /**
     * Getter battle availability
     * @return Card's attack status. 0 if it is unavailable to attack, 1 if available.
     */
    public int getBattleAvailability() {return this.isAvailableAttack;}

    /**
     * Sets this card's attack status.
     * @param isAvailableAttack 0 if it is made unavailable to attack, 1 if made available.
     */
    public void setBattleAvailability(int isAvailableAttack) {this.isAvailableAttack = isAvailableAttack;}

    /**
     * Changes the card position from attacking to defending, or vice-versa.
     */
    public void rotate() { this.position = (this.position + 1) % 2; }

    /**
     * Getter position of characterfieldcard
     * @return Card's position. 0 if defense and 1 if attack.
     */
    public int getPosition() { return this.position; }

    /**
     * Check characterfieldcard has power up or not
     * @return A boolean value which indicates whether this card has a powerup effect.
     */
    public boolean hasPowerUp() {
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
