package com.avatarduel.player;

import com.avatarduel.card.Card;
import com.avatarduel.card.CharacterCard;
import com.avatarduel.card.SkillCard;
import com.avatarduel.card.Element;
import com.avatarduel.deck.Deck;
import com.avatarduel.card.LandCard;
import com.avatarduel.card.CharacterFieldCard;


import java.util.List;
import java.util.ArrayList;

public class Player {
    private String name;
    private Deck deck;
    private List<Card> onHand;
    private List<LandCard> landFieldCards;
    private List<CharacterFieldCard> characterFieldCards;
    private List<SkillCard> skillFieldCards;
    private int hp;
    private int fire;
    private int earth;
    private int water;
    private int air;
    private int isLandCardDeploy; 

    public Player() {
        this.name = "";
        this.deck = new Deck();
        //Belum diset berapa card batasan
        this.onHand = new ArrayList<Card>();
        this.landFieldCards = new ArrayList<LandCard>();
        this.characterFieldCards = new ArrayList<CharacterFieldCard>();
        this.skillFieldCards = new ArrayList<SkillCard>();
        this.isLandCardDeploy = 0;
        this.hp = 80;
        this.fire = 0;
        this.earth = 0;
        this.water = 0;
        this.air = 0;

    }

    public Player(String name) {
        this.name = name;
        this.deck = new Deck();
        this.hp = 80;
        this.fire = 0;
        this.earth = 0;
        this.water = 0;
        this.air = 0;
    }

    public String getName() { return name; }

    public Deck getDeck() { return deck; }

    public List<Card> getOnHand() { return onHand; }

    public int getHp() { return hp; }
    
    public int getFire() { return fire; }
    
    public int getEarth() { return earth; }
    
    public int getWater() { return water; }
    
    public int getAir() { return air; }

    public List<LandCard> getLandFieldCards(){return this.landFieldCards;}
    public List<CharacterFieldCard> getCharacterFieldCards() {return this.characterFieldCards;}
    public List<SkillCard> getSkillFieldCards() {return this.skillFieldCards;}

    public int setHp(int newhp){return this.hp = newhp;}

    //Masih ada getter dan setter yang belum lengkap

    public boolean deployAble(Element element,int amount){
        boolean temp=true;
        switch(element){
            case FIRE:
                temp = (this.fire >= amount) ? true : false;
                break;
            case EARTH:
                temp = (this.earth >= amount) ? true : false;
                break;
            case WATER:
                temp = (this.water >= amount) ? true : false;
                break;
            case AIR:
                temp = (this.water >= amount) ? true : false;
                break;
        }
        return temp;
    }

    public void addPower(Element element) {
        switch (element) {
            case AIR:
                this.air++;
                break;
            case WATER:
                this.water++;
                break;
            case FIRE:
                this.fire++;
                break;
            case EARTH:
                this.earth++;
                break;
        }
    }

    public void usePower(Element element, int amount) {
        switch (element) {
            case AIR:
                this.air -= amount;
                break;
            case WATER:
                this.water -= amount;
                break;
            case FIRE:
                this.fire -= amount;
                break;
            case EARTH:
                this.earth -= amount;
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
        //Tambahin try and catch
        this.onHand.add(this.deck.drawCard());

    }

    public void resetPower(){
        //Apakah ada cara lain selian di reset jd 0 ?
        this.air = 0;
        this.fire = 0;
        this.earth = 0;
        this.water = 0;
        for(Card currentCard : landFieldCards){
            switch(currentCard.getElement()){
                case AIR:
                    this.air +=1;
                case WATER:
                    this.water +=1;
                case FIRE:
                    this.fire +=1;
                case EARTH:
                    this.earth +=1;
            }
        }
    }

    /**
     * Player movement option in MAIN1
     */
    public void deployCharacterCard(CharacterCard characterCard,int position){
        // !!!! Perlu cek kondisi apakah field sudah penuh !!!
        if (this.onHand.contains(characterCard)){
            if (deployAble(characterCard.getElement(), characterCard.getPower())){
                this.characterFieldCards.add(new CharacterFieldCard(characterCard,position,0));
                usePower(characterCard.getElement(), characterCard.getPower());
            } else {
                //Lempar Exception
            }
            
        } else {
            //Lempar exception
        }
    }

    public void changeCharacterCardPosition(CharacterFieldCard characterFieldCard){
        characterFieldCard.rotate();
    }

    public void deployLandCard(LandCard landCard){
        if (this.onHand.remove(landCard)){
            this.landFieldCards.add(landCard);
            this.isLandCardDeploy = 1;
            addPower(landCard.getElement());
        } else {
            //Lempar exception
        }
    }

    public void deploySkillCard(SkillCard skillCard){
        // !!!! Perlu cek kondisi apakah field sudah penuh !!!
        //Apakah perlu cek .contains()
        if (deployAble(skillCard.getElement(), skillCard.getPower())){
            this.skillFieldCards.add(skillCard);
            usePower(skillCard.getElement(), skillCard.getPower());
        } else {
            //Lempar Exception
        }
    }

    public void dumpSkillCard(SkillCard skillCard){
        this.skillFieldCards.remove(skillCard);
    }

    /**
     * Battle Phase
     */
    public void attack(CharacterFieldCard characterFieldCard,CharacterFieldCard opponentCharacterCard, Player opponent){
        //Harus dicek lagi apakah udah ada pemenang game dr proses attack
        if (characterFieldCard.getBattleAvailability() == 1){
            if (opponent.getCharacterFieldCards().isEmpty()){
                opponent.setHp(opponent.getHp() - characterFieldCard.getCharacterCard().getAttack());
                characterFieldCard.setIsRotatable(0);
            } else {
                if (isAttackValid(characterFieldCard,opponentCharacterCard)){
                    opponent.setHp(opponent.getHp() - (characterFieldCard.getCharacterCard().getAttack() - opponentCharacterCard.getCharacterCard().getAttack()));
                    opponent.getCharacterFieldCards().remove(opponentCharacterCard);
                    characterFieldCard.setIsRotatable(0);
                } else {
                    //Lempar exception
                }
            }
        } else {

        }
        
    }

    /**
     * Player's movement in Main2 is the same with Player's movement in Main1 
     */

    /**
     * Player's movement in END PHASE
     */

    public void endPhase() {
        this.isLandCardDeploy = 0;
        for(CharacterFieldCard currentCard : this.characterFieldCards){
            currentCard.setIsRotatable(1);
            currentCard.setBattleAvailability(1);
        }
    }

    // public void endTurn() {
    //     // End turn implements later
    // }

    // public void placeCard(Card card) {
    //     // Place card implements later
    // }


}
