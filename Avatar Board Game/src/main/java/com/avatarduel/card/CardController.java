package com.avatarduel.card;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.image.*;

import com.avatarduel.card.*;

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
    public void initialize() {

    }
    public void setCard(CharacterCard card) {
        cardName.setText(card.getName());
        cardDescription.setText(card.getDescription());
        cardAttack.setText(Integer.toString(card.getAttack()));
        cardDefense.setText(Integer.toString(card.getDefense()));
        cardPower.setText(Integer.toString(card.getPower()));
//        Image newImage = new Image("/com/avatarduel/card/image/character/Huu.png");
        // GANTI PATH DI CSV SEMUA JADI KEK GINI^^^^
        Image newImage = new Image(card.getPathName());
        cardImage.setImage(newImage);
        Image elementImage;
        if (card.getElement() == Element.AIR) {
            elementImage = new Image("/com/avatarduel/card/image/element/AirElement.png");
        } else if (card.getElement() == Element.WATER) {
            elementImage = new Image("/com/avatarduel/card/image/element/WaterElement.png");
        } else if (card.getElement() == Element.FIRE) {
            elementImage = new Image("/com/avatarduel/card/image/element/FireElement.png");
        } else {
            elementImage = new Image("/com/avatarduel/card/image/element/EarthElement.png");
        }
        cardElement.setImage(elementImage);
    }

//    public void setFieldCard(CharacterCard card){
//        cardName.setText(card.getName());
//        Image newImage = new Image(card.getPathName());
//        cardImage.setImage(newImage);
//        Image elementImage;
//        if (card.getElement() == Element.AIR) {
//            elementImage = new Image("/com/avatarduel/card/image/element/AirElement.png");
//        } else if (card.getElement() == Element.WATER) {
//            elementImage = new Image("/com/avatarduel/card/image/element/WaterElement.png");
//        } else if (card.getElement() == Element.FIRE) {
//            elementImage = new Image("/com/avatarduel/card/image/element/FireElement.png");
//        } else {
//            elementImage = new Image("/com/avatarduel/card/image/element/EarthElement.png");
//        }
//        cardElement.setImage(elementImage);
//    }
//
//    public void clicked(){
//        handCardA.setOnMouseClicked((new EventHandler<MouseEvent>() {
//            @Override
//            public void handle(MouseEvent event) {
//                System.out.println("cliked..");
//            }
//        }));
//    }
}