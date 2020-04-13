package com.avatarduel.board;

import java.io.IOException;
import java.util.Optional;
import java.util.List;
import javafx.scene.paint.Color;
import javafx.geometry.HPos;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
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
import javafx.scene.control.ButtonType;
import javafx.scene.control.Button;

import com.avatarduel.card.*;
import com.avatarduel.player.*;

import javax.swing.*;

public class BoardController {
    @FXML
    private AnchorPane dataPane;

    @FXML
    private AnchorPane battlePane;

    @FXML
    private BorderPane cardDetail;

    @FXML
    private GridPane handCardA, characterFieldCardA;

    @FXML
    private GridPane handCardB, characterFieldCardB;

    private String colorCard;

    @FXML
    private TextField deckCountA, hpA, landA, airA, fireA, earthA, waterA, energyA;
    
    @FXML
    private TextField deckCountB, hpB, landB, airB, fireB, earthB, waterB, energyB;

    @FXML
    private Button endTurnButton;

    private Board board;

    @FXML
    public void initialize() {
        colorCard = "";
        initializeClick();
    }

    public void displayCard(CharacterCard card) {
        try {
            FXMLLoader cardLoader = new FXMLLoader(getClass().getResource("/com/avatarduel/views/Card.fxml"));
            Pane cardDetailPane = cardLoader.load();
            CardController cardController = cardLoader.getController();
            cardController.setCard(card);
            Element cardElement = card.getElement();
            switch (cardElement) {
                case AIR :
                    this.colorCard = "F3D06F";
                    break;
                case WATER :
                    this.colorCard = "01BAEB";
                    break;
                case FIRE :
                    this.colorCard = "D13539";
                    break;
                case EARTH :
                    this.colorCard = "65C387";
                    break;
                case ENERGY :
                    this.colorCard = "A57FBB";
                    break;
            }
            cardDetailPane.setStyle("-fx-background-color: #" + colorCard + "; -fx-border-color: BLACK;");
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
            Element cardElement = card.getElement();
            switch (cardElement) {
                case AIR :
                    this.colorCard = "F3D06F";
                    break;
                case WATER :
                    this.colorCard = "01BAEB";
                    break;
                case FIRE :
                    this.colorCard = "D13539";
                    break;
                case EARTH :
                    this.colorCard = "65C387";
                    break;
                case ENERGY :
                    this.colorCard = "A57FBB";
                    break;
            }
            cardDetailPane.setStyle("-fx-background-color: #" + colorCard + "; -fx-border-color: BLACK;");
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
            Element cardElement = card.getElement();
            switch (cardElement) {
                case AIR :
                    this.colorCard = "F3D06F";
                    break;
                case WATER :
                    this.colorCard = "01BAEB";
                    break;
                case FIRE :
                    this.colorCard = "D13539";
                    break;
                case EARTH :
                    this.colorCard = "65C387";
                    break;
                case ENERGY :
                    this.colorCard = "A57FBB";
                    break;
            }
            cardDetailPane.setStyle("-fx-background-color: #" + colorCard + "; -fx-border-color: BLACK;");
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
            Element cardElement = card.getElement();
            switch (cardElement) {
                case AIR :
                    this.colorCard = "F3D06F";
                    break;
                case WATER :
                    this.colorCard = "01BAEB";
                    break;
                case FIRE :
                    this.colorCard = "D13539";
                    break;
                case EARTH :
                    this.colorCard = "65C387";
                    break;
                case ENERGY :
                    this.colorCard = "A57FBB";
                    break;
            }
            cardDetailPane.setStyle("-fx-background-color: #" + colorCard + "; -fx-border-color: BLACK;");
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
            Element cardElement = card.getElement();
            switch (cardElement) {
                case AIR :
                    this.colorCard = "F3D06F";
                    break;
                case WATER :
                    this.colorCard = "01BAEB";
                    break;
                case FIRE :
                    this.colorCard = "D13539";
                    break;
                case EARTH :
                    this.colorCard = "65C387";
                    break;
                case ENERGY :
                    this.colorCard = "A57FBB";
                    break;
            }
            cardDetailPane.setStyle("-fx-background-color: #" + colorCard + "; -fx-border-color: BLACK;");
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
//            handCard.setPrefSize(66, 80);
            handCard.setClip(new Rectangle(handCard.getPrefWidth(), handCard.getPrefHeight()));
            FieldCardController fieldCardController = fieldCardLoader.getController();
            fieldCardController.setFieldCard(card);
            Element cardElement = card.getElement();
            switch (cardElement) {
                case AIR :
                    this.colorCard = "F3D06F";
                    break;
                case WATER :
                    this.colorCard = "01BAEB";
                    break;
                case FIRE :
                    this.colorCard = "D13539";
                    break;
                case EARTH :
                    this.colorCard = "65C387";
                    break;
                case ENERGY :
                    this.colorCard = "A57FBB";
                    break;
            }
            if (player == 1){
                handCardA.add(handCard,x,0,1,1);
            } else { //player == 2
                handCardB.add(handCard,x,0,1,1);
            }
            handCard.setStyle("-fx-background-color: #" + colorCard + "; -fx-border-color: BLACK;");
            addHoverEvent(card, handCard);
            Player currentPlayer = board.getCurrentPlayer();
            handCard.setOnMouseClicked(e -> {
                Card clickedCard = currentPlayer.getOnHand().get(x);
                System.out.println("Mouse clicked card " + clickedCard.getName());
                if (currentPlayer.canDeploy(clickedCard)) {
                    System.out.println("YOU CAN DEPLOY!");
                    ButtonType deploy = new ButtonType("Deploy");
                    ButtonType discard = new ButtonType("Discard");
                    Alert alert = new Alert(AlertType.CONFIRMATION, "Choose what you want to do with this card.", deploy, discard,ButtonType.CANCEL);
                    alert.showAndWait().ifPresent(response -> {
                        if (response == deploy) {
                            currentPlayer.addToField(clickedCard);
                        } else if (response == discard) {
                            currentPlayer.discardCardOnHand(clickedCard);
                        }
                        updateBoard();
                    });
                } else {
                    ButtonType discard = new ButtonType("Discard");
                    Alert alert = new Alert(AlertType.CONFIRMATION, "Choose what you want to do with this card.", discard);
                    alert.showAndWait().ifPresent(response -> {
                        if (response == discard) {
                            currentPlayer.discardCardOnHand(clickedCard);
                        }
                        updateBoard();
                    });
                }
            });
        } catch (IOException e) {
            System.out.println("Exception: " + e);
        }
    }

    public void displayFlippedHandCard(int player, int x) {
        Rectangle rectangle = new Rectangle(64, 80);
        rectangle.setFill(Color.web("#ed4b00"));    // nanti diganti yaw stylenya
        if (player == 1){
            handCardA.setHalignment(rectangle, HPos.CENTER);
            handCardA.add(rectangle,x,2,1,1);
        } else { //player == 2
            handCardB.setHalignment(rectangle, HPos.CENTER);
            handCardB.add(rectangle,x,0,1,1);
        }
    }

    public void displayCharacterFieldCard(CharacterFieldCard card, int player, int x) {
        try{
            FXMLLoader fieldCardLoader = new FXMLLoader(getClass().getResource("/com/avatarduel/views/FieldCard.fxml"));
            Pane characterFieldCard = (Pane) fieldCardLoader.load();
            characterFieldCard.setClip(new Rectangle(characterFieldCard.getPrefWidth(), characterFieldCard.getPrefHeight()));
            FieldCardController fieldCardController = fieldCardLoader.getController();
            fieldCardController.setFieldCard(card);
            Element cardElement = card.getCharacterCard().getElement();
            switch (cardElement) {
                case AIR :
                    this.colorCard = "F3D06F";
                    break;
                case WATER :
                    this.colorCard = "01BAEB";
                    break;
                case FIRE :
                    this.colorCard = "D13539";
                    break;
                case EARTH :
                    this.colorCard = "65C387";
                    break;
                case ENERGY :
                    this.colorCard = "A57FBB";
                    break;
            }

            if (player == 1){
                characterFieldCardA.add(characterFieldCard,x,0,1,1);
            } else { //player == 2
                characterFieldCardB.add(characterFieldCard,x,0,1,1);
            }
            if (card.getPosition() == 0){
                characterFieldCard.setRotate(90);
            }else {
                characterFieldCard.setRotate(0);
            }
            characterFieldCard.setStyle("-fx-background-color: #" + colorCard + "; -fx-border-color: BLACK;");
            addHoverEvent(card, characterFieldCard);
            Player currentPlayer = board.getCurrentPlayer();
            characterFieldCard.setOnMouseClicked(e -> {
                CharacterFieldCard clickedCard = currentPlayer.getCharacterFieldCard().get(x);
                System.out.println("Mouse clicked card " + clickedCard.getCharacterCard().getName());
                ButtonType discard = new ButtonType("Discard");
                ButtonType attack = new ButtonType("Attack");
                ButtonType rotate = new ButtonType("Rotate");
                Alert alert = new Alert(AlertType.CONFIRMATION, "Choose what you want to do with this character card.",attack,rotate,discard,ButtonType.CANCEL);
                if (card.getIsRotateAble()==0){
                    alert.getDialogPane().lookupButton(rotate).setDisable(true);
                }
                if (card.getPosition()==0){
                    alert.getDialogPane().lookupButton(attack).setDisable(true);
                }
                alert.showAndWait().ifPresent(response -> {
                    if (response == attack) {

                    } else if (response == discard) {
                        currentPlayer.discardCharacterCardOnField(card);
                    } else if (response == rotate){
                        card.setPositionValue();
                    } else {
                        //Tombol CANCEL
                    }
                  updateBoard();
                });

            });
        }catch (IOException e) {
            System.out.println("Exception: " + e);
        }
    }

    public void addHoverEvent(Card card, Pane pane) {
        pane.setOnMouseEntered((MouseEvent t) -> {
            this.displayCard(card);
        });

        pane.setOnMouseExited((MouseEvent t) -> {
            cardDetail.setCenter(new Pane());
        });
    }

    public void addHoverEvent(CharacterFieldCard card,Pane pane) {
        pane.setOnMouseEntered((MouseEvent t) -> {
            this.displayCard(card.getCharacterCard());
        });

        pane.setOnMouseExited((MouseEvent t) -> {
            cardDetail.setCenter(new Pane());
        });
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public void initializeClick(){
        endTurnButton.setOnAction((new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                board.switchTurn();
                updateBoard();
            }
        }));
    }

    public void updateHandCardDisplay(List<Card> p1, List<Card> p2) {
        handCardA.getChildren().clear();
        handCardB.getChildren().clear();
        if (board.getTurn() == 1) {
            for (int i = 0; i < p1.size(); i++) {
                displayHandCard(p1.get(i), 1, i);
            }
            for (int i = 0; i < p2.size(); i++) {
                displayFlippedHandCard(2, i);
            }
        } else {
            for (int i = 0; i < p1.size(); i++) {
                displayFlippedHandCard(1, i);
            }
            for (int i = 0; i < p2.size(); i++) {
                displayHandCard(p2.get(i), 2, i);
            }
        }
    }

    public void updateCharacterFieldCardDisplay(List<CharacterFieldCard> p1, List<CharacterFieldCard> p2) {
        characterFieldCardA.getChildren().clear();
        characterFieldCardB.getChildren().clear();
        for (int i = 0; i < p1.size(); i++) {
            displayCharacterFieldCard(p1.get(i), 1, i);
        }
        for (int i = 0; i < p2.size(); i++) {
            displayCharacterFieldCard(p2.get(i), 2, i);
        }
    }

    public void updatePlayerData(Player p1, Player p2) {
        deckCountA.setText(Integer.toString(p1.getDeck().getDeckCount()));
        hpA.setText(Integer.toString(p1.getHp()));
        airA.setText(Integer.toString(p1.getCurAir()) + " / " + p1.getMaxAir());
        fireA.setText(Integer.toString(p1.getCurFire()) + " / " + p1.getMaxFire());
        earthA.setText(Integer.toString(p1.getCurEarth()) + " / " + p1.getMaxEarth());
        waterA.setText(Integer.toString(p1.getCurWater()) + " / " + p1.getMaxWater());
        energyA.setText(Integer.toString(p1.getCurEnergy()) + " / " + p1.getMaxEnergy());
        if (p1.getIsLandCardDeployed()) landA.setText("YES");
        else landA.setText("NO");

        deckCountB.setText(Integer.toString(p2.getDeck().getDeckCount()));
        hpB.setText(Integer.toString(p2.getHp()));
        airB.setText(Integer.toString(p2.getCurAir()) + " / " + p2.getMaxAir());
        fireB.setText(Integer.toString(p2.getCurFire()) + " / " + p2.getMaxFire());
        earthB.setText(Integer.toString(p2.getCurEarth()) + " / " + p2.getMaxEarth());
        waterB.setText(Integer.toString(p2.getCurWater()) + " / " + p2.getMaxWater());
        energyB.setText(Integer.toString(p2.getCurEnergy()) + " / " + p2.getMaxEnergy());
        if (p2.getIsLandCardDeployed()) landB.setText("YES");
        else landB.setText("NO");
    }

    public void updateBoard() {
        updateHandCardDisplay(board.getP1().getOnHand(), board.getP2().getOnHand());
        updateCharacterFieldCardDisplay(board.getP1().getCharacterFieldCard(), board.getP2().getCharacterFieldCard());
        updatePlayerData(board.getP1(), board.getP2());
    }


}