package com.avatarduel.player;

import com.avatarduel.card.*;
import com.avatarduel.deck.Deck;

import java.util.List;
import java.util.ArrayList;

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
//        this.maxFire = 0;
//        this.maxEarth = 0;
//        this.maxWater = 0;
//        this.maxAir = 0;
//        this.maxEnergy = 0;

//      Supposed to be all 0, set 10 only for testing deploy
        this.curAir = 10;
        this.curFire = 10;
        this.curEarth = 10;
        this.curWater = 10;
        this.curEnergy = 10;
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

    //Masih ada getter dan setter yang belum lengkap

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
        if (this.onHand.size() < 8){
            this.onHand.add(this.deck.drawCard());
        } else {
            // Skip draw phase
        }
    }

    public void resetPower(){
        this.curAir = 0;
        this.curFire = 0;
        this.curEarth = 0;
        this.curWater = 0;
        this.curEnergy = 0;
        for(Card currentCard : landFieldCards){
            switch(currentCard.getElement()){
                case AIR:
                    this.maxAir +=1;
                case WATER:
                    this.maxWater +=1;
                case FIRE:
                    this.maxFire +=1;
                case EARTH:
                    this.maxEarth +=1;
                case ENERGY:
                    this.maxEnergy +=1;
            }
        }
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

    public void useAura (SkillFieldCard skillFieldCard,CharacterFieldCard target,Player targetPlayer){//Precondition: skillFieldCard is an auracard
        ((AuraCard)skillFieldCard.getSkillCard()).Effect(target);
        ((SkillFieldCard) skillFieldCard).setOwner((CharacterFieldCard) target);
        target.getSkills().add(skillFieldCard);
    }

    public void useDestroyer(SkillFieldCard skillFieldCard,CharacterFieldCard target,Player targetPlayer){//TargetPlayer can be currentPlayer or Opposite Player
        for (SkillFieldCard skills : target.getSkills()){
            targetPlayer.getSkillFieldCard().remove(skills);
            target.getSkills().remove(skills);
        }
        targetPlayer.getCharacterFieldCard().remove(target);
    }

    public void usePowerUp(SkillFieldCard skillFieldCard,CharacterFieldCard target,Player targetPlayer){//Precondition, target is currentPlayer's card
        target.addSkills(skillFieldCard);
        ((SkillFieldCard) skillFieldCard).setOwner((CharacterFieldCard) target);
        target.getSkills().add(skillFieldCard);
//        targetPlayer.getSkillFieldCard().add(skillFieldCard);
    }

    //    public void deployCharacterCard(CharacterCard characterCard,int position){
//        if ((this.turn.getPhase() == Phase.MAIN1) || (this.turn.getPhase() == Phase.MAIN2)){
//            if (this.onHand.contains(characterCard)){
//                if (deployAble(characterCard.getElement(), characterCard.getPower())){
//                    if (this.characterFieldCards.size() <= 8){
//                        this.characterFieldCards.add(new CharacterFieldCard(characterCard,position,0));
//                        usePower(characterCard.getElement(), characterCard.getPower());
//                    } else {
//
//                    }
//                } else {
//                    //Lempar Exception
//                 }
//
//            } else {
//                //Lempar exception
//            }
//        } else {
//
//        }
//    }
//
//    public void changeCharacterCardPosition(CharacterFieldCard characterFieldCard){
//        if ((this.turn.getPhase() == Phase.MAIN1) || (this.turn.getPhase() == Phase.MAIN2)){
//            if (this.characterFieldCards.contains(characterFieldCard)){
//                if (characterFieldCard.getIsRotateAble() == 1){
//                    characterFieldCard.rotate();
//                } else {
//
//                }
//            } else {
//                //Kartu yang diklik berupa kartu lawan sehingga tidak valid untuk diganti position
//            }
//        } else {
//
//        }
//    }
//
//    public void deployLandCard(LandCard landCard){
//        if (this.onHand.remove(landCard)){
//            this.landFieldCards.add(landCard);
//            addPower(landCard.getElement());
//            this.isLandCardDeployed = true;
//        } else {
//            //Lempar exception
//        }
//    }
//
//    public void deploySkillCard(SkillCard skillCard,CharacterFieldCard characterFieldCard){
//        // !!!! Perlu cek kondisi apakah field sudah penuh !!!
//        if ((this.turn.getPhase() == Phase.MAIN1) || (this.turn.getPhase() == Phase.MAIN2)){
//            if (this.characterFieldCards.contains(characterFieldCard)){
//                if (deployAble(skillCard.getElement(), skillCard.getPower())){
//                    if (this.skillFieldCards.size() <= 8){
//                        this.skillFieldCards.add(skillCard);
//                        //Pemanggilan fungsi useSkillOnCard()
//                        usePower(skillCard.getElement(), skillCard.getPower());
//                    } else {
//
//                    }
//                } else {
//                    //Lempar Exception
//                }
//            } else {
//
//            }
//        } else{
//
//        }
//    }
//
//    public void dumpSkillCard(SkillCard skillCard){
//        if ((this.turn.getPhase() == Phase.MAIN1) || (this.turn.getPhase() == Phase.MAIN2)){
//            if (this.skillFieldCards.contains(skillCard)){
//                this.skillFieldCards.remove(skillCard);
//            } else {
//
//            }
//        } else {
//
//        }
//    }

    /**
     * Battle Phase
     */

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
            opponent.getCharacterFieldCard().remove(opponentCharacterCard);
            //dump the opponentSkillCard
            for (SkillFieldCard skills : opponent.getSkillFieldCard()){
                if(opponentCharacterCard.getSkills().contains(skills)){
                    opponent.getSkillFieldCard().remove(skills);
                    opponentCharacterCard.getSkills().remove(skills);
                }
            }
            //Check if attack has powerup skill and available to use it
            if (opponentCharacterCard.getPosition() == 0 && characterFieldCard.hasPowerUp()){
                opponent.setHp(opponent.getHp() - characterFieldCard.getCharacterCard().getAttack());
            }
            characterFieldCard.setBattleAvailability(0); //Setiap karakter hanya boleh attack maksimal 1 kali
            return true;
        } else {
            return false;
        }
    }
    public void attackOpponentPlayer(CharacterFieldCard characterFieldCard,Player opponent){
        opponent.setHp(opponent.getHp() - characterFieldCard.getCharacterCard().getAttack());
        characterFieldCard.setIsRotatable(0);
        characterFieldCard.setBattleAvailability(0); //Setiap karakter hanya boleh attack maksimal 1 kali
    }
}
