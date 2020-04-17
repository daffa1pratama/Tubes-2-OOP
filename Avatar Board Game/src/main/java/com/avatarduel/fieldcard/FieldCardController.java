package com.avatarduel.fieldcard;

import javafx.scene.text.Text;
import javafx.scene.image.*;

import com.avatarduel.card.*;

import javafx.fxml.FXML;

public class FieldCardController {
    @FXML
    private ImageView cardImage;

    @FXML
    private Text cardName;

    @FXML
    private ImageView cardElement;

    @FXML
    public void initialize() {

    }

    public void setFieldCard(Card card){
        cardName.setText(card.getName());
//            System.out.println(card.getPathName());
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
            Image newImage = new Image(card.getPathName());
            cardImage.setImage(newImage);
        } catch (Exception e) {
            System.out.println(card.getPathName());
        }
    }

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
            Image newImage = new Image(card.getCharacterCard().getPathName());
            cardImage.setImage(newImage);
        } catch (Exception e) {
            System.out.println(card.getCharacterCard().getPathName());
        }
    }

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
            Image newImage = new Image(card.getSkillCard().getPathName());
            cardImage.setImage(newImage);
        } catch (Exception e) {
            System.out.println(card.getSkillCard().getPathName());
        }
    }
}