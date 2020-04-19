package com.avatarduel.player;

import com.avatarduel.card.*;
import com.avatarduel.deck.Deck;
import com.avatarduel.fieldcard.CharacterFieldCard;
import com.avatarduel.fieldcard.SkillFieldCard;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;

/**
 * Player is the class that represents a player
 * @author Kelompok 9 K3
 */
public class Player {
    private String name;
    private Deck deck;
    private List<Card> onHand;
    private List<LandCard> landFieldCards;
    private List<CharacterFieldCard> characterFieldCards;
    private List<SkillFieldCard> skillFieldCards;
    private int hp;
    private int maxFire;
    private int maxEarth;
    private int maxWater;
    private int maxAir;
    private int maxEnergy;
    private int curFire;
    private int curEarth;
    private int curWater;
    private int curAir;
    private int curEnergy;
    private boolean isLandCardDeployed;

    /**
     * Constructor for Player
     * @param name is the name of a player
     * @param characterCardCollection is the CardCollection of character card that a player owns
     * @param landCardCollection is the CardCollection of land card that a player owns
     * @param skillCardCollection is the CardCollection of skill card that a player owns
     * @param destroyCardCollection is the CardCollection of destroy card that a player owns
     * @param powerupCardCollection is the CardCollection of power up card that a player owns
     */
    public Player(String name, CardCollection characterCardCollection, CardCollection landCardCollection, CardCollection skillCardCollection, CardCollection destroyCardCollection, CardCollection powerupCardCollection) {
        this.name = name;
        this.deck = new Deck(characterCardCollection, landCardCollection, skillCardCollection, destroyCardCollection, powerupCardCollection);
        this.onHand = new ArrayList<Card>(7);
        this.landFieldCards = new ArrayList<LandCard>();
        this.characterFieldCards = new ArrayList<CharacterFieldCard>(6);
        this.skillFieldCards = new ArrayList<SkillFieldCard>(6);
        this.isLandCardDeployed = false;
        this.hp = 80;
        this.curFire = 0;
        this.curEarth = 0;
        this.curWater = 0;
        this.curAir = 0;
        this.curEnergy = 0;
        this.maxFire = 0;
        this.maxEarth = 0;
        this.maxWater = 0;
        this.maxAir = 0;
        this.maxEnergy = 0;
    }

    /**
     *Getter for the Player's attribut
     */
    public String getName() { return name; }
    public Deck getDeck() { return deck; }
    public List<Card> getOnHand() { return onHand; }
    public int getHp() { return hp; }
    public int getMaxFire() { return maxFire; }
    public int getMaxEarth() { return maxEarth; }
    public int getMaxWater() { return maxWater; }
    public int getMaxAir() { return maxAir; }
    public int getMaxEnergy() { return maxEnergy; }
    public int getCurFire() { return curFire; }
    public int getCurEarth() { return curEarth; }
    public int getCurWater() { return curWater; }
    public int getCurAir() { return curAir; }
    public int getCurEnergy() { return curEnergy; }
    public List<LandCard> getLandFieldCards(){return this.landFieldCards;}
    public List<CharacterFieldCard> getCharacterFieldCard() {return this.characterFieldCards;}
    public List<SkillFieldCard> getSkillFieldCard() {return this.skillFieldCards;}
    public boolean getIsLandCardDeployed() { return this.isLandCardDeployed; }

    /**
     * Setter for the Player's attribute
     */
    public void setIsLandCardDeployed(boolean state) { this.isLandCardDeployed = state ;}
    public int setHp(int newhp){return this.hp = newhp;}

    /**
     * Check whether a player has enough amount of power of a certain type of element to deploy a card
     * @param element the element type of a card that is going to be checked
     * @param amount the amount that is going to be used to deploy a card with certain element
     * @return true when a player has enough power in the selected element
     */
    public boolean hasEnoughPower (Element element,int amount) {
        boolean temp=true;
        switch(element){
            case FIRE:
                temp = this.curFire >= amount;
                break;
            case EARTH:
                temp = this.curEarth >= amount;
                break;
            case WATER:
                temp = this.curWater >= amount;
                break;
            case AIR:
                temp = this.curAir >= amount;
                break;
            case ENERGY:
                temp = this.curEnergy >= amount;
                break;
        }
        return temp;
    }

    /**
     * add 1 power on a certain element to a player
     * @param element the element that is going to be added
     */
    public void addPower (Element element) {
        switch (element) {
            case AIR:
                this.curAir++;
                this.maxAir++;
                break;
            case WATER:
                this.curWater++;
                this.maxWater++;
                break;
            case FIRE:
                this.curFire++;
                this.maxFire++;
                break;
            case EARTH:
                this.curEarth++;
                this.maxEarth++;
                break;
            case ENERGY:
                this.curEnergy++;
                this.maxEnergy++;
                break;
        }
    }

    /**
     * use/decrease an amount of power for a certain element on a Player.
     * Precondition : The player has enough power to be decreased (won't leads to condition condition where player's power is a negative number)
     * @param element is the element that is going to be used
     * @param amount is the amount of certain element that is going to be used
     */
    public void usePower (Element element, int amount) {
        switch (element) {
            case AIR:
                this.curAir -= amount;
                break;
            case WATER:
                this.curWater -= amount;
                break;
            case FIRE:
                this.curFire -= amount;
                break;
            case EARTH:
                this.curEarth -= amount;
                break;
            case ENERGY:
                this.curEnergy -= amount;
                break;
        }
    }


    /**
     *Player movement option in DRAW PHASE
     */

    /**drawcard to a player's hand and discard the player's card randomly when a player's has more than 8 cards on his/her hand
     */
    public void drawCard() {
        this.onHand.add(this.deck.drawCard());
        if (this.onHand.size() > 8){
            // randomly delete one card
            Random r = new Random();
            int idx = r.nextInt(this.onHand.size());
            this.onHand.remove(idx);
        }
    }

    /**
     * Reset the power for each element on the player based on his/her land card
     */
    public void resetPower(){
        this.curAir = this.maxAir;
        this.curFire = this.maxFire;
        this.curEarth = this.maxEarth;
        this.curWater = this.maxWater;
        this.curEnergy = this.maxEnergy;
    }

    /**
     * Player movement option in MAIN1
     */
    /**
     * Checking whether a player has enough power to deploy certain card
     * @param card the card that is going to be deployed
     * @return true when the player has enough power to deploy and false otherwise
     */
    public boolean canDeploy(Card card) {
        if (card instanceof CharacterCard) {
            return hasEnoughPower(card.getElement(), ((CharacterCard) card).getPower()) && characterFieldCards.size() < 6;
        } else if (card instanceof LandCard) {
            return !isLandCardDeployed;
        } else if (card instanceof AuraCard) {
            return hasEnoughPower(card.getElement(), ((AuraCard) card).getPower()) && skillFieldCards.size() < 6;
        } else if (card instanceof DestroyCard) {
            return hasEnoughPower(card.getElement(), ((DestroyCard) card).getPower()) && skillFieldCards.size() < 6;
        } else { // card instanceof PowerUpCard
            return hasEnoughPower(card.getElement(), ((PowerUpCard) card).getPower()) && skillFieldCards.size() < 6;
        }
    }

    /**
     * Add a card from the hand of a player to the field of the player
     * @param field the field that determines the side of a board that belongs to the current player
     * @param card the card to be deployed
     */
    public void addToField(int field, Card card) {
        if (card instanceof CharacterCard) {
            usePower(card.getElement(), ((CharacterCard) card).getPower());
            CharacterFieldCard fieldCard = new CharacterFieldCard(field, (CharacterCard) card);
            characterFieldCards.add(fieldCard);
        } else if (card instanceof LandCard) {
            addPower(card.getElement());
            isLandCardDeployed = true;
            landFieldCards.add((LandCard) card);
        } else {
            usePower(card.getElement(), ((SkillCard) card).getPower());
            SkillFieldCard skillFieldCard = new SkillFieldCard.SkillFieldCardBuilder(field,(SkillCard) card).build(field);
            skillFieldCards.add(skillFieldCard);
        }
        discardCardOnHand(card);
    }

    /**
     * discard card from a player's hand
     * @param card the card to be discarded
     */
    public void discardCardOnHand(Card card) { onHand.remove(card); }

    /**
     * discard a SkillFieldCard from a player's field
     * @param skillFieldCard the skill field card to be discard
     */
    public void discardSkillFieldCard(SkillFieldCard skillFieldCard){
        if (skillFieldCard.getOwner() != null){
            if (skillFieldCard.getSkillCard() instanceof AuraCard){
                ((AuraCard)skillFieldCard.getSkillCard()).reverseEffect(skillFieldCard.getOwner());
                skillFieldCard.getOwner().getSkills().remove(skillFieldCard);
            } else if (skillFieldCard.getSkillCard() instanceof PowerUpCard){
                skillFieldCard.getOwner().getSkills().remove(skillFieldCard);
            }
        }
        this.getSkillFieldCard().remove(skillFieldCard);
    }

    /**
     * use aura skill card on a certain character card
     * @param skillFieldCard the aura card to be used
     * @param target the card which is the target for the aura card to be used
     * @param targetPlayer the player that owns the target card
     */
    public void useAura (SkillFieldCard skillFieldCard,CharacterFieldCard target,Player targetPlayer){
        ((AuraCard)skillFieldCard.getSkillCard()).effect(target);
        ((SkillFieldCard) skillFieldCard).setOwner((CharacterFieldCard) target);
        target.getSkills().add(skillFieldCard);
    }

    /**
     * use aura skill card on a certain character card
     * @param skillFieldCard the destroyer card to be used
     * @param target the card which is the target for the destroyer card to be used
     * @param targetPlayer the player that owns the target card
     */
    public void useDestroyer(SkillFieldCard skillFieldCard,CharacterFieldCard target,Player targetPlayer){
        for (SkillFieldCard skills : target.getSkills()){
            targetPlayer.getSkillFieldCard().remove(skills);
            this.getSkillFieldCard().remove(skills);
        }
        this.getSkillFieldCard().remove(skillFieldCard);
        targetPlayer.getCharacterFieldCard().remove(target);
        this.skillFieldCards.remove(skillFieldCard);
    }

    /**
     * use power up skill card on a certain character card
     * @param skillFieldCard the power up card to be used
     * @param target the card which is the target for the power up card to be used
     * @param targetPlayer the player that owns the target card
     */
    public void usePowerUp(SkillFieldCard skillFieldCard,CharacterFieldCard target,Player targetPlayer){//Precondition, target is currentPlayer's card
        target.addSkills(skillFieldCard);
        ((SkillFieldCard) skillFieldCard).setOwner((CharacterFieldCard) target);
        target.getSkills().add(skillFieldCard);
    }

    /**
     * Checking if a character field card of a player's is available to launch an attack to the opponent character field card
     * @param characterFieldCard the attacker's card
     * @param opponentCharacterFieldCard the target attacked card
     * @return true when an attack is available and false otherwise
     */
    public boolean isAttackValid(CharacterFieldCard characterFieldCard,CharacterFieldCard opponentCharacterFieldCard){
        if (opponentCharacterFieldCard.getPosition() == 0 ){
            return (characterFieldCard.getCharacterCard().getAttack() > opponentCharacterFieldCard.getCharacterCard().getDefense());
        } else {
            return (characterFieldCard.getCharacterCard().getAttack() > opponentCharacterFieldCard.getCharacterCard().getAttack());
        }
    }


    /**
     * launch and attack from a player's character card to opponent's character card.
     * @param characterFieldCard the attacker's card
     * @param opponentCharacterCard the attacked target card
     * @param opponent the opposite player in a certain turn
     * @return true when the attack is successfully launched and false otherwise
     */
    public boolean attack(CharacterFieldCard characterFieldCard,CharacterFieldCard opponentCharacterCard, Player opponent){
        if (isAttackValid(characterFieldCard,opponentCharacterCard)){
            if (opponentCharacterCard.getPosition()==1){
                opponent.setHp(opponent.getHp() - (characterFieldCard.getCharacterCard().getAttack() - opponentCharacterCard.getCharacterCard().getAttack()));
            }
            //dump the opponentSkillCard
            for (SkillFieldCard skills : opponentCharacterCard.getSkills()){
                //Each time only one of the below lines will be executed depend on which player owns the skillCard
                opponent.getSkillFieldCard().remove(skills);
                this.getSkillFieldCard().remove(skills);
            }
            opponent.getCharacterFieldCard().remove(opponentCharacterCard);
            //Check if attack has powerup skill and available to use it
            if (opponentCharacterCard.getPosition() == 0 && characterFieldCard.hasPowerUp()){
                opponent.setHp(opponent.getHp() - (characterFieldCard.getCharacterCard().getAttack()-opponentCharacterCard.getCharacterCard().getDefense()));
            }
            characterFieldCard.setBattleAvailability(0); //Setiap karakter hanya boleh attack maksimal 1 kali
            return true;
        } else {
            return false;
        }
    }

    /**
     * Launch an attack from a character card from a player directly to the oppponent player hp.
     * Precondition : the opponent's character field is empty
     * @param characterFieldCard the attacker's character field card
     * @param opponent the opponent that is going to be attacked
     */
    public void attackOpponentPlayer(CharacterFieldCard characterFieldCard,Player opponent){
        opponent.setHp(opponent.getHp() - characterFieldCard.getCharacterCard().getAttack());
        characterFieldCard.setBattleAvailability(0); //Each character can only attack at most once in a turn
    }


//    public void discardCharacterCardOnField(CharacterFieldCard characterFieldCard) {characterFieldCards.remove(characterFieldCard);}

}
