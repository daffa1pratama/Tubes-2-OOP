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

import javafx.fxml.FXML;

public class FieldCardController {
    @FXML
    private ImageView cardImage;

    @FXML
    private Text cardName;

    @FXML
    public void initialize() {

    }

    public void setFieldCard(CharacterCard card){
            cardName.setText(card.getName());
            Image newImage = new Image(card.getPathName());
            cardImage.setImage(newImage);
    }

    public void click(){
            cardImage.setOnMouseClicked((new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println("cliked..");
            }
        }));
    }
}