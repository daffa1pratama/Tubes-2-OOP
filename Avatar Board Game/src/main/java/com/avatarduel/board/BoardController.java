package com.avatarduel.board;

import java.io.IOException;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.input.MouseEvent;

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

    public void displayCard(LandCard card) {
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

    public void displayCard(AuraCard card) {
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

    public void displayCard(DestroyCard card) {
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

    public void displayCard(PowerUpCard card) {
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
            FXMLLoader fieldCardLoader = new FXMLLoader(getClass().getResource("/com/avatarduel/views/FieldCard.fxml"));
            Pane handCard = (Pane) fieldCardLoader.load();
            handCard.setPrefSize(66, 91);
            handCard.setClip(new Rectangle(handCard.getPrefWidth(), handCard.getPrefHeight()));
            FieldCardController fieldCardController = fieldCardLoader.getController();
            fieldCardController.setFieldCard(card);
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

    public void Hover(Card card, Pane pane) {
        pane.setOnMouseEntered((MouseEvent t) -> {
            if (card instanceof CharacterCard) {
                this.displayCard((CharacterCard) card);
            } else if (card instanceof LandCard) {
                this.displayCard((LandCard) card);
            } else if (card instanceof AuraCard) {
                this.displayCard((AuraCard) card);
            } else if (card instanceof DestroyCard) {
                this.displayCard((DestroyCard) card);
            } else if (card instanceof PowerUpCard) {
                this.displayCard((PowerUpCard) card);
            }
        });

        pane.setOnMouseExited((MouseEvent t) -> {
            cardDetail.setCenter(new Pane());
        });
    }
    public void click(){
        handCardA.setOnMouseClicked((new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event){
            Node clickedNode = event.getPickResult().getIntersectedNode();
            Node parent = clickedNode.getParent();
            while (parent != handCardA) {
                clickedNode = parent;
                parent = clickedNode.getParent();
            }
            Integer colIndex = GridPane.getColumnIndex(clickedNode);
            Integer rowIndex = GridPane.getRowIndex(clickedNode);
//            System.out.println("Mouse clicked cell: " + colIndex + " And: " + rowIndex);
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Card Clicked");
            alert.setHeaderText("Choose what to do with your card");
            alert.setResizable(false);
            alert.setContentText("Blablabla");
            alert.showAndWait();
           }
        }));
        handCardB.setOnMouseClicked((new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event){
                Node clickedNode = event.getPickResult().getIntersectedNode();
                Node parent = clickedNode.getParent();
                while (parent != handCardB) {
                    clickedNode = parent;
                    parent = clickedNode.getParent();
                }
                Integer colIndex = GridPane.getColumnIndex(clickedNode);
                Integer rowIndex = GridPane.getRowIndex(clickedNode);
//            System.out.println("Mouse clicked cell: " + colIndex + " And: " + rowIndex);
            }
        }));
    }

    
// public void clickGrid(javafx.scene.input.MouseEvent event) {
//   }
  
//   if (clickedNode != gridmane) {
//     // click on descendant node
//     Node parent = clickedNode.getParent();
//     while (parent != gridmane) {
//         clickedNode = parent;
//         parent = clickedNode.getParent();
//     }
//     Integer colIndex = GridPane.getColumnIndex(clickedNode);
//     Integer rowIndex = GridPane.getRowIndex(clickedNode);
//     System.out.println("Mouse clicked cell: " + colIndex + " And: " + rowIndex);
//   }
    // public void fieldOnClick(){
    //     FXMLLoader fieldCardLoader = new FXMLLoader(getClass().getResource("/com/avatarduel/views/FieldCard.fxml"));
    //     FieldCardController fieldCardController = fieldCardLoader.getController();
    //     fieldCardController.click();
    // }




}