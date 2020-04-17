package com.avatarduel.card;

import javafx.fxml.*;
import javafx.scene.text.Text;
import javafx.scene.control.*;
import javafx.scene.image.*;

/**
 * Controller for card.
 *
 * @author Kelompok 9 K3
 */
public class CardController {
    @FXML
    private ImageView cardImage;

    @FXML
    private ImageView cardElement;

    @FXML
    private Text cardName;

    @FXML
    private TextArea cardDescription;

    @FXML
    private Text cardAttack;

    @FXML
    private Text cardDefense;

    @FXML
    private Text cardPower;

    @FXML
    private Text cardType;

    @FXML
    public void initialize() {

    }

    /**
     * Displays character card information on the detailed card pane.
     * @param card CharacterCard to display.
     */
    public void setCard(CharacterCard card) {
        cardName.setText(card.getName());
        cardDescription.setText(card.getDescription());
        cardAttack.setText(Integer.toString(card.getAttack()));
        cardDefense.setText(Integer.toString(card.getDefense()));
        cardPower.setText(Integer.toString(card.getPower()));
        Image newImage = new Image(card.getImagePath());
        cardImage.setImage(newImage);
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
        cardType.setText("[ C ]");
    }

    /**
     * Displays land card information on the detailed card pane.
     * @param card LandCard to display.
     */
    public void setCard(LandCard card) {
        cardName.setText(card.getName());
        cardDescription.setText(card.getDescription());
        cardAttack.setText("-");
        cardDefense.setText("-");
        cardPower.setText("-");
        Image newImage = new Image(card.getImagePath());
        cardImage.setImage(newImage);
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
        cardType.setText("[ L ]");
    }

    /**
     * Displays aura card information on the detailed card pane.
     * @param card AuraCard to display.
     */
    public void setCard(AuraCard card) {
        cardName.setText(card.getName());
        cardDescription.setText(card.getDescription());
        cardAttack.setText(Integer.toString(card.getAttack()));
        cardDefense.setText(Integer.toString(card.getDefense()));
        cardPower.setText(Integer.toString(card.getPower()));
        Image newImage = new Image(card.getImagePath());
        cardImage.setImage(newImage);
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
        cardType.setText("[ A ]");
    }

    /**
     * Displays destroy card information on the detailed card pane.
     * @param card DestroyCard to display.
     */
    public void setCard(DestroyCard card) {
        cardName.setText(card.getName());
        cardDescription.setText(card.getDescription());
        cardPower.setText(Integer.toString(card.getPower()));
        cardAttack.setText("-");
        cardDefense.setText("-");
        Image newImage = new Image(card.getImagePath());
        cardImage.setImage(newImage);
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
        cardType.setText("[ D ]");
    }

    /**
     * Displays powerup card information on the detailed card pane.
     * @param card PowerUpCard to display.
     */
    public void setCard(PowerUpCard card) {
        cardName.setText(card.getName());
        cardDescription.setText(card.getDescription());
        cardPower.setText(Integer.toString(card.getPower()));
        cardAttack.setText("-");
        cardDefense.setText("-");
        Image newImage = new Image(card.getImagePath());
        cardImage.setImage(newImage);
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
        cardType.setText("[ P ]");
    }
}