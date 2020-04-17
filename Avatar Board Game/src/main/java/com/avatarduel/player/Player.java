package com.avatarduel.player;

import com.avatarduel.card.*;
import com.avatarduel.deck.Deck;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;

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

//      Supposed to be all 0, set 10 only for testing deploy
        this.maxAir = 10;
        this.maxFire = 10;
        this.maxEarth = 10;
        this.maxWater = 10;
        this.maxEnergy = 10;
    }

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

    public void setIsLandCardDeployed(boolean state) { this.isLandCardDeployed = state ;}

    public int setHp(int newhp){return this.hp = newhp;}

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
    public void drawCard() {
        this.onHand.add(this.deck.drawCard());
        if (this.onHand.size() > 8){
            // randomly delete one card
            Random r = new Random();
            int idx = r.nextInt(this.onHand.size());
            this.onHand.remove(idx);
        }
    }

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
//            SkillFieldCard skillFieldCard = new SkillFieldCard(field, (SkillCard) card);
            SkillFieldCard skillFieldCard = new SkillFieldCard.SkillFieldCardBuilder(field,(SkillCard) card).build(field);
            skillFieldCards.add(skillFieldCard);
        }
        discardCardOnHand(card);
    }

    public void discardCardOnHand(Card card) { onHand.remove(card); }


    public void discardCharacterCardOnField(CharacterFieldCard characterFieldCard) {characterFieldCards.remove(characterFieldCard);}

    public void discardSkillFieldCard(SkillFieldCard skillFieldCard){
        if (skillFieldCard.getOwner() != null){
            if (skillFieldCard.getSkillCard() instanceof AuraCard){
                ((AuraCard)skillFieldCard.getSkillCard()).reverseEffect(skillFieldCard.getOwner());
                skillFieldCard.getOwner().getSkills().remove(skillFieldCard);
            } else if (skillFieldCard.getSkillCard() instanceof PowerUpCard){
                skillFieldCard.getOwner().getSkills().remove(skillFieldCard);
            }
        }
        this.getSkillFieldCard().remove(skillFieldCard);//Remove on the user's field
    }

    public void useAura (SkillFieldCard skillFieldCard,CharacterFieldCard target,Player targetPlayer){//Precondition: skillFieldCard is an auracard
        ((AuraCard)skillFieldCard.getSkillCard()).effect(target);
        ((SkillFieldCard) skillFieldCard).setOwner((CharacterFieldCard) target);
        target.getSkills().add(skillFieldCard);
    }

    public void useDestroyer(SkillFieldCard skillFieldCard,CharacterFieldCard target,Player targetPlayer, Player notTargetPlayer){//TargetPlayer can be currentPlayer or Opposite Player
        for (SkillFieldCard skills : target.getSkills()){
            targetPlayer.getSkillFieldCard().remove(skills);
            notTargetPlayer.getSkillFieldCard().remove(skills);
        }
        this.getSkillFieldCard().remove(skillFieldCard);
        targetPlayer.getCharacterFieldCard().remove(target);
        this.skillFieldCards.remove(skillFieldCard);
    }

    public void usePowerUp(SkillFieldCard skillFieldCard,CharacterFieldCard target,Player targetPlayer){//Precondition, target is currentPlayer's card
        target.addSkills(skillFieldCard);
        ((SkillFieldCard) skillFieldCard).setOwner((CharacterFieldCard) target);
        target.getSkills().add(skillFieldCard);
    }

    
    public boolean isAttackValid(CharacterFieldCard characterFieldCard,CharacterFieldCard opponentCharacterFieldCard){
        if (opponentCharacterFieldCard.getPosition() == 0 ){
            return (characterFieldCard.getCharacterCard().getAttack() > opponentCharacterFieldCard.getCharacterCard().getDefense());
        } else {
            return (characterFieldCard.getCharacterCard().getAttack() > opponentCharacterFieldCard.getCharacterCard().getAttack());
        }
    }


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
    public void attackOpponentPlayer(CharacterFieldCard characterFieldCard,Player opponent){
        opponent.setHp(opponent.getHp() - characterFieldCard.getCharacterCard().getAttack());
        characterFieldCard.setBattleAvailability(0); //Each character can only attack at most once in a turn
    }
}
