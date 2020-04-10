package com.avatarduel.player;

import com.avatarduel.card.Card;
import com.avatarduel.card.CharacterCard;
import com.avatarduel.card.SkillCard;
import com.avatarduel.card.CardCollection;
import com.avatarduel.card.Element;
import com.avatarduel.deck.Deck;
import com.avatarduel.card.LandCard;
import com.avatarduel.card.CharacterFieldCard;
import com.avatarduel.player.Turn;


import java.util.List;
import java.util.ArrayList;

public class Player {
    private String name;
    private Deck deck;
    private Turn turn;
    private List<Card> onHand;
    private List<LandCard> landFieldCards;
    private List<CharacterFieldCard> characterFieldCards;
    private List<SkillCard> skillFieldCards;
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
        this.skillFieldCards = new ArrayList<SkillCard>(6);
        this.isLandCardDeployed = false;
        this.hp = 80;
        this.maxFire = 0;
        this.maxEarth = 0;
        this.maxWater = 0;
        this.maxAir = 0;
        this.maxEnergy = 0;
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

    public List<CharacterFieldCard> getCharacterFieldCards() {return this.characterFieldCards;}

    public List<SkillCard> getSkillFieldCards() {return this.skillFieldCards;}

    public boolean getIsLandCardDeployed() { return this.isLandCardDeployed; }

    public int setHp(int newhp){return this.hp = newhp;}

    //Masih ada getter dan setter yang belum lengkap

    public boolean deployAble (Element element,int amount){
        boolean temp=true;
        switch(element){
            case FIRE:
                temp = (this.curFire >= amount) ? true : false;
                break;
            case EARTH:
                temp = (this.curEarth >= amount) ? true : false;
                break;
            case WATER:
                temp = (this.curWater >= amount) ? true : false;
                break;
            case AIR:
                temp = (this.curWater >= amount) ? true : false;
                break;
            case ENERGY:
                temp = (this.curEnergy >= amount) ? true : false;
                break;
        }
        return temp;
    }

    public void addPower (Element element) {
        switch (element) {
            case AIR:
                this.maxAir++;
                break;
            case WATER:
                this.maxWater++;
                break;
            case FIRE:
                this.maxFire++;
                break;
            case EARTH:
                this.maxEarth++;
                break;
            case ENERGY:
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

    public boolean isAttackValid(CharacterFieldCard characterFieldCard,CharacterFieldCard opponentCharacterFieldCard){
        if (opponentCharacterFieldCard.getPosition() == 0 ){
            return (characterFieldCard.getCharacterCard().getAttack() >= opponentCharacterFieldCard.getCharacterCard().getDefense());
        } else {
            return (characterFieldCard.getCharacterCard().getAttack() >= opponentCharacterFieldCard.getCharacterCard().getAttack());
        }
    }
    

    /**
     *Player movement option in DRAW PHASE
     */
    public void drawCard() {
        if (this.onHand.size() < 7){
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
    public void deployCharacterCard(CharacterCard characterCard,int position){
        if ((this.turn.getPhase() == Phase.MAIN1) || (this.turn.getPhase() == Phase.MAIN2)){
            if (this.onHand.contains(characterCard)){
                if (deployAble(characterCard.getElement(), characterCard.getPower())){
                    if (this.characterFieldCards.size() <= 8){
                        this.characterFieldCards.add(new CharacterFieldCard(characterCard,position,0));
                        usePower(characterCard.getElement(), characterCard.getPower());
                    } else {

                    }
                } else {
                    //Lempar Exception
                 }
                
            } else {
                //Lempar exception
            }
        } else {

        }
    }

    public void changeCharacterCardPosition(CharacterFieldCard characterFieldCard){
        if ((this.turn.getPhase() == Phase.MAIN1) || (this.turn.getPhase() == Phase.MAIN2)){
            if (this.characterFieldCards.contains(characterFieldCard)){
                if (characterFieldCard.getIsRotateAble() == 1){
                    characterFieldCard.rotate();
                } else {
                    
                }
            } else {
                //Kartu yang diklik berupa kartu lawan sehingga tidak valid untuk diganti position
            }
        } else {

        }
    }

    public void deployLandCard(LandCard landCard){
        if (this.onHand.remove(landCard)){
            this.landFieldCards.add(landCard);
            addPower(landCard.getElement());
            this.isLandCardDeployed = true;
        } else {
            //Lempar exception
        }
    }

    public void deploySkillCard(SkillCard skillCard,CharacterFieldCard characterFieldCard){
        // !!!! Perlu cek kondisi apakah field sudah penuh !!!
        if ((this.turn.getPhase() == Phase.MAIN1) || (this.turn.getPhase() == Phase.MAIN2)){
            if (this.characterFieldCards.contains(characterFieldCard)){
                if (deployAble(skillCard.getElement(), skillCard.getPower())){
                    if (this.skillFieldCards.size() <= 8){
                        this.skillFieldCards.add(skillCard);
                        //Pemanggilan fungsi useSkillOnCard()
                        usePower(skillCard.getElement(), skillCard.getPower());
                    } else {

                    }
                } else {
                    //Lempar Exception
                }
            } else {

            }
        } else{

        }
    }

    public void dumpSkillCard(SkillCard skillCard){
        if ((this.turn.getPhase() == Phase.MAIN1) || (this.turn.getPhase() == Phase.MAIN2)){
            if (this.skillFieldCards.contains(skillCard)){
                this.skillFieldCards.remove(skillCard);
            } else {

            }
        } else {

        }
    }

    /**
     * Battle Phase
     */
    public void attack(CharacterFieldCard characterFieldCard,CharacterFieldCard opponentCharacterCard, Player opponent){
        //Harus dicek lagi apakah udah ada pemenang game dr proses attack
        if (this.turn.getPhase() == Phase.BATTLE){
            //Apakah perlu cek kepemilikan card ?
            if (characterFieldCard.getBattleAvailability() == 1){
                if (opponent.getCharacterFieldCards().isEmpty()){
                    opponent.setHp(opponent.getHp() - characterFieldCard.getCharacterCard().getAttack());
                    characterFieldCard.setIsRotatable(0);
                    characterFieldCard.setBattleAvailability(0); //Setiap karakter hanya boleh attack maksimal 1 kali
                } else {
                    if (isAttackValid(characterFieldCard,opponentCharacterCard)){
                        opponent.setHp(opponent.getHp() - (characterFieldCard.getCharacterCard().getAttack() - opponentCharacterCard.getCharacterCard().getAttack()));
                        opponent.getCharacterFieldCards().remove(opponentCharacterCard);
                        characterFieldCard.setIsRotatable(0);
                        characterFieldCard.setBattleAvailability(0); //Setiap karakter hanya boleh attack maksimal 1 kali
                    } else {
                        //Lempar exception
                    }
                }
            } else {
    
            }
        } else{

        }
        
    }

    /**
     * Player's movement in Main2 is the same with Player's movement in Main1 
     */

    /**
     * Player's movement in END PHASE
     */

    public void endPhase() {
        this.isLandCardDeployed = false;
        for(CharacterFieldCard currentCard : this.characterFieldCards){
            currentCard.setIsRotatable(1);
            currentCard.setBattleAvailability(1);
        }
        this.turn.setEndTurn(1);
    }

    // public void endTurn() {
    //     // End turn implements later
    // }

    // public void placeCard(Card card) {
    //     // Place card implements later
    // }


}
