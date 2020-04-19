package com.avatarduel.fieldcard;

import javafx.scene.text.Text;
import javafx.scene.image.*;

import com.avatarduel.card.*;

import javafx.fxml.FXML;

/**
 * Controller for card that are displayed
 * @author Kelompok 9 K3
 * */

public class FieldCardController {
    @FXML
    private ImageView cardImage;

    @FXML
    private Text cardName;

    @FXML
    private ImageView cardElement;

    /**
     * Initializer for the card.
     */
    @FXML
    public void initialize() {

    }

    /**
     * Load the all the information(card name, card element and it's image) of a card which is going to be displayed
     * @param card Which card will set into FieldCard
     */
    public void setFieldCard(Card card){
        cardName.setText(card.getName());
        Image elementImage;
        if (card.getElement() == Element.AIR) {
            elementImage = new Image("/com/avatarduel/card/image/element/AirElement.png");
        } else if (card.getElement() == Element.WATER) {
            elementImage = new Image("/com/avatarduel/card/image/element/WaterElement.png");
        } else if (card.getElement() == Element.FIRE) {
            elementImage = new Image("/com/avatarduel/card/image/element/FireElement.png");
        } else if (card.getElement() == Element.EARTH) {
            elementImage = new Image("/com/avatarduel/card/image/element/EarthElement.png");
        } else {
            elementImage = new Image("/com/avatarduel/card/image/element/EnergyElement.png");
        }
        cardElement.setImage(elementImage);
        try {
            Image newImage = new Image(card.getImagePath());
            cardImage.setImage(newImage);
        } catch (Exception e) {
            System.out.println(card.getImagePath());
        }
    }

    /**
     * @param card is the card instane of CharacterFieldCard that is going to be display
     * Load the all the information(card name, card element and it's image) of a character card which is going to be displayed
     */
    public void setFieldCard(CharacterFieldCard card) {
        cardName.setText(card.getCharacterCard().getName());
        Image elementImage;
        if (card.getCharacterCard().getElement() == Element.AIR) {
            elementImage = new Image("/com/avatarduel/card/image/element/AirElement.png");
        } else if (card.getCharacterCard().getElement() == Element.WATER) {
            elementImage = new Image("/com/avatarduel/card/image/element/WaterElement.png");
        } else if (card.getCharacterCard().getElement() == Element.FIRE) {
            elementImage = new Image("/com/avatarduel/card/image/element/FireElement.png");
        } else if (card.getCharacterCard().getElement() == Element.EARTH) {
            elementImage = new Image("/com/avatarduel/card/image/element/EarthElement.png");
        } else {
            elementImage = new Image("/com/avatarduel/card/image/element/EnergyElement.png");
        }
        cardElement.setImage(elementImage);
        try {
            Image newImage = new Image(card.getCharacterCard().getImagePath());
            cardImage.setImage(newImage);
        } catch (Exception e) {
            System.out.println(card.getCharacterCard().getImagePath());
        }
    }

    /**
     * @param card is the card instance of SkillFieldCard that is going to be displayed
     * Load the all the information(card name, card element and it's image) of a skill card which is going to be displayed
     */
    public void setFieldCard(SkillFieldCard card) {
        cardName.setText(card.getSkillCard().getName());
        Image elementImage;
        if (card.getSkillCard().getElement() == Element.AIR) {
            elementImage = new Image("/com/avatarduel/card/image/element/AirElement.png");
        } else if (card.getSkillCard().getElement() == Element.WATER) {
            elementImage = new Image("/com/avatarduel/card/image/element/WaterElement.png");
        } else if (card.getSkillCard().getElement() == Element.FIRE) {
            elementImage = new Image("/com/avatarduel/card/image/element/FireElement.png");
        } else if (card.getSkillCard().getElement() == Element.EARTH) {
            elementImage = new Image("/com/avatarduel/card/image/element/EarthElement.png");
        } else {
            elementImage = new Image("/com/avatarduel/card/image/element/EnergyElement.png");
        }
        cardElement.setImage(elementImage);
        try {
            Image newImage = new Image(card.getSkillCard().getImagePath());
            cardImage.setImage(newImage);
        } catch (Exception e) {
            System.out.println(card.getSkillCard().getImagePath());
        }
    }
}