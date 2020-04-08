package com.avatarduel.board;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.input.*;

import com.avatarduel.card.*;

public class BoardController {
    @FXML
    private AnchorPane dataPane;

    @FXML
    private AnchorPane battlePane;

    @FXML
    private BorderPane cardDetail;

    @FXML
    private GridPane handCardA;

    @FXML
    private GridPane handCardB;

    @FXML
    public void initialize() {

    }

    public void displayCard(CharacterCard card) {
//        Button button = new Button("TOT");
//        cardDetail.getChildren().add(button);
        try {
            FXMLLoader cardLoader = new FXMLLoader(getClass().getResource("/com/avatarduel/views/Card.fxml"));
            Pane cardDetailPane = cardLoader.load();
            CardController cardController = cardLoader.getController();
            cardController.setCard(card);
            cardDetail.setCenter(cardDetailPane);
        } catch (IOException e) {
            System.out.println("Exception: " + e);
        }
    }

    public void displayHandCard(CharacterCard card,int player,int x){
        try{
            FXMLLoader cardLoader = new FXMLLoader(getClass().getResource("/com/avatarduel/views/FieldCharacterCard.fxml"));
            Pane handCard = (Pane) cardLoader.load();
            handCard.setPrefSize(66, 91);
            handCard.setClip(new Rectangle(handCard.getPrefWidth(), handCard.getPrefHeight()));
            CardController cardController = cardLoader.getController();
            cardController.setFieldCard(card);
            if (player == 1){
                handCardA.add(handCard,x,2,1,1);
            } else { //player == 2
                handCardB.add(handCard,x,0,1,1);
            }
            
            Hover(card, handCard);

        } catch (IOException e) {
            System.out.println("Exception: " + e);
        }
    }

    // public void taroKartu(CharacterCard card,int player,int x){
    //     try{
    //         FXMLLoader cardLoader = new FXMLLoader(getClass().getResource("/com/avatarduel/views/FieldCharacterCard.fxml"));
    //         Pane handCard = (Pane) cardLoader.load();
    //         handCard.setPrefSize(66, 91);
    //         handCard.setClip(new Rectangle(handCard.getPrefWidth(), handCard.getPrefHeight()));
    //         CardController cardController = cardLoader.getController();
    //         cardController.setFieldCard(card);
    //         if (player == 1){
    //             handCardA.add(handCard,x,0,1,1);
    //         } else { //player == 2
    //             handCardB.add(handCard,x,2,1,1);
    //         }
            
    //         Hover(card, handCard);

    //     } catch (IOException e) {
    //         System.out.println("Exception: " + e);
    //     }
    // }

    public void Hover(CharacterCard card, Pane pane) {
        pane.setOnMouseEntered((MouseEvent t) -> {
            displayCard(card);
        });

        pane.setOnMouseExited((MouseEvent t) -> {
            cardDetail.setCenter(new Pane());
        });
    }

    // public void Click() {
    //     cellButton.setOnAction(new EventHandler<ActionEvent>(){

    //         @Override
    //         public void handle(ActionEvent t){
    
    //             Alert alert = new Alert(AlertType.CONFIRMATION);
    //             alert.setTitle("Confirmation Dialog");
    //             alert.setHeaderText("Look, a Confirmation Dialog");
    //             alert.setContentText("Are you ok with this?");
    
    //             Optional<ButtonType> result = alert.showAndWait();
    //             if (result.get() == ButtonType.OK){
    //                 Animal currentAnimal = (Animal) ButtonCell.this.getTableView().getItems().get(ButtonCell.this.getIndex());
    //                 data.remove(currentAnimal);
    //             }
    //         }
    //     });
    }
}