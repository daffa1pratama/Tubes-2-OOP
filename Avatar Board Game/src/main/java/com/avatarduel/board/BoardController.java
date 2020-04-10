package com.avatarduel.board;

import java.io.IOException;
import java.util.Optional;
import java.util.List;

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
import com.avatarduel.player.*;

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
        initializeClick();
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

    public void displayCard(Card card) {
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
    }

    public void displayHandCard(Card card, int player, int x){
        try{
            FXMLLoader fieldCardLoader = new FXMLLoader(getClass().getResource("/com/avatarduel/views/FieldCard.fxml"));
            Pane handCard = (Pane) fieldCardLoader.load();
            handCard.setPrefSize(66, 91);
            handCard.setClip(new Rectangle(handCard.getPrefWidth(), handCard.getPrefHeight()));
            FieldCardController fieldCardController = fieldCardLoader.getController();
            fieldCardController.setFieldCard(card);
            if (player == 1){
                handCardA.add(handCard,x,2,1,1);
                // handCardA.add(handCard,x,0,1,1);
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
            this.displayCard(card);
        });

        pane.setOnMouseExited((MouseEvent t) -> {
            cardDetail.setCenter(new Pane());
        });
    }
    public void initializeClick(){
//        handCardA.setOnMouseClicked((new EventHandler<MouseEvent>(){
//            @Override
//            public void handle(MouseEvent event){
//            Node clickedNode = event.getPickResult().getIntersectedNode();
//            Node parent = clickedNode.getParent();
//            while (parent != handCardA) {
//                clickedNode = parent;
//                parent = clickedNode.getParent();
//            }
//            Integer colIndex = GridPane.getColumnIndex(clickedNode);
//            Integer rowIndex = GridPane.getRowIndex(clickedNode);
//            if (rowIndex == 0){//CharacterFieldCard
//                Alert alert = new Alert(Alert.AlertType.CONFIRMATION,"Choose what to do with this card",new ButtonType("Attack"), new ButtonType("Rotate"),ButtonType.CANCEL);
//                alert.setTitle("Character Card Clicked");
//                alert.setResizable(false);
//                Optional<ButtonType> result = alert.showAndWait();
//                if ( !result.isPresent()) {//Alert diexit tanpa ada button diklik
//
//                } else if(result.get() == alert.getButtonTypes().get(0) ){//Attack
//
//                } else {//Rotate
//
//                }
//            } else if (rowIndex == 1){//SkillFieldCard
//                Alert alert = new Alert(Alert.AlertType.CONFIRMATION,"Choose what to do with this card",new ButtonType("Discard"),ButtonType.CANCEL);
//                alert.setTitle("Skill Card Clicked");
//                alert.setResizable(false);
//                Optional<ButtonType> result = alert.showAndWait();
//                if ( !result.isPresent()) {//Alert diexit tanpa ada button diklik
//
//                } else if(result.get() == alert.getButtonTypes().get(0) ){//Discard
//
//                }
//            } else {//rowIndex == 2 HandCard
//                Alert alert = new Alert(Alert.AlertType.CONFIRMATION,"Choose what to do with this card",new ButtonType("Deploy"),new ButtonType("Discard"),ButtonType.CANCEL);
//                alert.setTitle("HandCard clicked");
//                alert.setResizable(false);
//                Optional<ButtonType> result = alert.showAndWait();
//                if ( !result.isPresent()) {//Alert diexit tanpa ada button diklik
//
//                } else if(result.get() == alert.getButtonTypes().get(0) ){//Deploy
//
//                } else if(result.get() == alert.getButtonTypes().get(1)){//Discard
//
//                }//BUTTON CANCEL tersedia bawaan Javafx
//            }
//           }
//            //            System.out.println("Mouse clicked cell: " + colIndex + " And: " + rowIndex);
//        }));
//        handCardB.setOnMouseClicked((new EventHandler<MouseEvent>(){
//            @Override
//            public void handle(MouseEvent event){
//                Node clickedNode = event.getPickResult().getIntersectedNode();
//                Node parent = clickedNode.getParent();
//                while (parent != handCardB) {
//                    clickedNode = parent;
//                    parent = clickedNode.getParent();
//                }
//                Integer colIndex = GridPane.getColumnIndex(clickedNode);
//                Integer rowIndex = GridPane.getRowIndex(clickedNode);
////            System.out.println("Mouse clicked cell: " + colIndex + " And: " + rowIndex);
//            Alert alert = new Alert(Alert.AlertType.CONFIRMATION,"Choose what to do with this card",new ButtonType("DEPLOY"),new ButtonType("DISCARD"),ButtonType.CANCEL);
//            alert.setTitle("Card Clicked");
//            alert.setResizable(false);
//            alert.showAndWait();
//            }
//        }));
    }

    public void updateHandCardDisplay(List<Card> p1, List<Card> p2) {
        for (int i = 0; i < p1.size(); i++) {
            displayHandCard(p1.get(i), 1, i);
        }
        for (int i = 0; i < p2.size(); i++) {
            displayHandCard(p2.get(i), 2, i);
        }
    }

    public void updatePlayerData(Player p1, Player p2) {

    }

    public void initializeGame(Board board) {
        updateHandCardDisplay(board.getP1().getOnHand(), board.getP2().getOnHand());
        updatePlayerData(board.getP1(), board.getP2());
    }
}