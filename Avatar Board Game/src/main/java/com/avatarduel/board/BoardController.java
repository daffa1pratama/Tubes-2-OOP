package com.avatarduel.board;

import java.io.IOException;
import java.util.List;

import com.avatarduel.fieldcard.CharacterFieldCard;
import com.avatarduel.fieldcard.FieldCard;
import com.avatarduel.fieldcard.FieldCardController;
import com.avatarduel.fieldcard.SkillFieldCard;
import com.avatarduel.util.CardReader;
import javafx.scene.image.ImageView;

import javafx.fxml.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Button;

import com.avatarduel.card.*;
import com.avatarduel.player.*;

/**
 * Controller for Board.
 * @author Kelompok 9 K3
 */
public class BoardController {

    @FXML
    private BorderPane cardDetail;

    @FXML
    private GridPane handCardA, characterFieldCardA, skillFieldCardA;

    @FXML
    private GridPane handCardB, characterFieldCardB, skillFieldCardB;

    @FXML
    private TextField deckCountA, hpA, landA, airA, fireA, earthA, waterA, energyA, messageA;
    
    @FXML
    private TextField deckCountB, hpB, landB, airB, fireB, earthB, waterB, energyB, messageB;

    @FXML
    private Button endTurnButton, nextPhaseButton, discardButton;

    @FXML
    private TextField playerText, phaseText;

    private Board board;

    /**
     * Contains the card which is selected by the user. Null if user did not selected yet.
     */
    private FieldCard selected1, selected2;

    /**
     * Initializer for the board.
     * Initializes the click event handler for buttons.
     */
    @FXML
    public void initialize() {
        this.playerText.setText("PLAYER A");
        this.phaseText.setText(Phase.DRAW.toString());
        initializeClick();
    }

    /**
     * Displays character card at the card detail pane.
     * @param card CharacterCard to display.
     */
    public void displayCard(CharacterCard card) {
        try {
            FXMLLoader cardLoader = new FXMLLoader(getClass().getResource("/com/avatarduel/views/Card.fxml"));
            Pane cardDetailPane = cardLoader.load();
            CardController cardController = cardLoader.getController();
            cardController.setCard(card);
            cardDetailPane.setStyle("-fx-background-color: #F3D06F; -fx-border-color: BLACK;");
            cardDetail.setCenter(cardDetailPane);
        } catch (IOException e) {
            System.out.println("Exception: " + e);
        }
    }

    /**
     * Displays land card at the card detail pane.
     * @param card LandCard to display.
     */
    public void displayCard(LandCard card) {
        try {
            FXMLLoader cardLoader = new FXMLLoader(getClass().getResource("/com/avatarduel/views/Card.fxml"));
            Pane cardDetailPane = cardLoader.load();
            CardController cardController = cardLoader.getController();
            cardController.setCard(card);
            cardDetailPane.setStyle("-fx-background-color: #65C387; -fx-border-color: BLACK;");
            cardDetail.setCenter(cardDetailPane);
        } catch (IOException e) {
            System.out.println("Exception: " + e);
        }
    }

    /**
     * Displays aura card at the card detail pane.
     * @param card AuraCard to display.
     */
    public void displayCard(AuraCard card) {
        try {
            FXMLLoader cardLoader = new FXMLLoader(getClass().getResource("/com/avatarduel/views/Card.fxml"));
            Pane cardDetailPane = cardLoader.load();
            CardController cardController = cardLoader.getController();
            cardController.setCard(card);
            cardDetailPane.setStyle("-fx-background-color: #01BAEB; -fx-border-color: BLACK;");
            cardDetail.setCenter(cardDetailPane);
        } catch (IOException e) {
            System.out.println("Exception: " + e);
        }
    }

    /**
     * Displays destroy card at the card detail pane.
     * @param card DestroyCard to display.
     */
    public void displayCard(DestroyCard card) {
        try {
            FXMLLoader cardLoader = new FXMLLoader(getClass().getResource("/com/avatarduel/views/Card.fxml"));
            Pane cardDetailPane = cardLoader.load();
            CardController cardController = cardLoader.getController();
            cardController.setCard(card);
            cardDetailPane.setStyle("-fx-background-color: #D13539; -fx-border-color: BLACK;");
            cardDetail.setCenter(cardDetailPane);
        } catch (IOException e) {
            System.out.println("Exception: " + e);
        }
    }

    /**
     * Displays powerup card at the card detail pane.
     * @param card PowerUpCard to display.
     */
    public void displayCard(PowerUpCard card) {
        try {
            FXMLLoader cardLoader = new FXMLLoader(getClass().getResource("/com/avatarduel/views/Card.fxml"));
            Pane cardDetailPane = cardLoader.load();
            CardController cardController = cardLoader.getController();
            cardController.setCard(card);
            cardDetailPane.setStyle("-fx-background-color: #A57FBB; -fx-border-color: BLACK;");
            cardDetail.setCenter(cardDetailPane);
        } catch (IOException e) {
            System.out.println("Exception: " + e);
        }
    }

    /**
     * Calls the appropriate function to display a card at the card detail pane according to its type.
     * @param card Card to display.
     */
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

    /**
     * Displays the cards on player's hand in their hand card pane.
     * When the card is hovered, the details of the card will appear on the detail pane.
     * @param card Card to display
     * @param player Player who owns the card
     * @param x Index of the player's hand card pane where the card will be displayed.
     */
    public void displayHandCard(Card card, int player, int x){
        try{
            FXMLLoader fieldCardLoader = new FXMLLoader(getClass().getResource("/com/avatarduel/views/FieldCard.fxml"));
            Pane handCard = fieldCardLoader.load();
            handCard.setClip(new Rectangle(handCard.getPrefWidth(), handCard.getPrefHeight()));
            FieldCardController fieldCardController = fieldCardLoader.getController();
            fieldCardController.setFieldCard(card);
            String colorCard = "";

            if (card instanceof CharacterCard) {
                colorCard = "F3D06F"; // yellow
            } else if (card instanceof LandCard) {
                colorCard = "65C387"; // green
            } else if (card instanceof AuraCard) {
                colorCard = "01BAEB"; // blue
            } else if (card instanceof DestroyCard) {
                colorCard = "D13539"; // red
            } else if (card instanceof PowerUpCard) {
                colorCard = "A57FBB"; // purple
            }

            if (player == 1){
                handCardA.add(handCard,x,0,1,1);
            } else { //player == 2
                handCardB.add(handCard,x,0,1,1);
            }
            String style = "-fx-background-color: #" + colorCard + "; -fx-border-color: BLACK;";
            handCard.setStyle(style);
            addHoverEvent(card, handCard);
            Player currentPlayer = board.getCurrentPlayer();
            handCard.setOnMouseClicked(e -> {
                clearSelected();
                Card clickedCard = currentPlayer.getOnHand().get(x);
                ButtonType deploy = new ButtonType("Deploy");
                Alert alert = new Alert(AlertType.CONFIRMATION, "Do you want to deploy this card?", deploy, ButtonType.CANCEL);
                boolean isLand = card instanceof LandCard;
                if ((isLand && currentPlayer.getIsLandCardDeployed()) || (!currentPlayer.canDeploy(clickedCard)) || (board.getPhase() != Phase.MAIN)){
                    alert.getDialogPane().lookupButton(deploy).setDisable(true);
                }
                if (board.getPhase() == Phase.MAIN) {
                    alert.showAndWait().ifPresent(response -> {
                        if (response == deploy) {
                            currentPlayer.addToField(board.getTurn(), clickedCard);
                            if (isLand) {
                                currentPlayer.setIsLandCardDeployed(true);
                            }
                        }
                        updateBoard();
                    });
                }
            });
        } catch (IOException e) {
            System.out.println("Exception: " + e);
        }
    }

    /**
     * Displays the cards on player's hand in their hand card pane, but flipped.
     * Flipped cards can't be hovered.
     * @param player Player who owns the card
     * @param x Index of the player's hand card pane where the flipped card will be displayed.
     */
    public void displayFlippedHandCard(int player, int x) {
        ImageView backCard = new ImageView("/com/avatarduel/card/image/backCard.png");
        backCard.setFitHeight(80);
        backCard.setFitWidth(64);
        if (player == 1){
            handCardA.add(backCard, x, 0, 1, 1);
        } else { //player == 2
            handCardB.add(backCard, x, 0, 1, 1);
        }
    }

    /**
     * Displays a deployed character card in the player's character field.
     * @param card CharacterFieldCard to display.
     * @param player Player who owns the card
     * @param x Index of the player's character field pane where the character card will be displayed.
     */
    public void displayCharacterFieldCard(CharacterFieldCard card, int player, int x) {
        try {
            FXMLLoader fieldCardLoader = new FXMLLoader(getClass().getResource("/com/avatarduel/views/FieldCard.fxml"));
            Pane characterFieldCard = fieldCardLoader.load();
            characterFieldCard.setClip(new Rectangle(characterFieldCard.getPrefWidth(), characterFieldCard.getPrefHeight()));
            FieldCardController fieldCardController = fieldCardLoader.getController();
            fieldCardController.setFieldCard(card);
            if (player == 1) {
                characterFieldCardA.add(characterFieldCard, x, 0, 1, 1);
            } else { //player == 2
                characterFieldCardB.add(characterFieldCard, x, 0, 1, 1);
            }
            if (card.getPosition() == 0) {
                characterFieldCard.setRotate(90);
            } else {
                characterFieldCard.setRotate(0);
            }
            String style = "-fx-background-color: #F3D06F;";
            if (selected1 instanceof CharacterFieldCard && card == selected1) {
                style += " -fx-border-color: BLACK; -fx-border-width: 5;";
            } else if (selected1 instanceof SkillFieldCard && ((SkillFieldCard) selected1).getOwner() == card) {
                style += " -fx-border-color: YELLOW; -fx-border-width: 5;";
            }
            characterFieldCard.setStyle(style);
            addHoverEvent(card, characterFieldCard);
            characterFieldCard.setOnMouseClicked(e -> {
                if (selected1 == null) selected1 = card;
                else selected2 = card;
                updateBoard();
            });
        } catch (IOException e) {
            System.out.println("Exception: " + e);
        }
    }

    /**
     * Displays a deployed skill card in the player's skill field.
     * @param card SkillFieldCard to display.
     * @param player Player who owns the card
     * @param x Index of the player's skill field pane where the skill card will be displayed.
     */
    public void displaySkillFieldCard(SkillFieldCard card, int player, int x) {
        try {
            FXMLLoader fieldCardLoader = new FXMLLoader(getClass().getResource("/com/avatarduel/views/FieldCard.fxml"));
            Pane skillFieldCard = fieldCardLoader.load();
            skillFieldCard.setClip(new Rectangle(skillFieldCard.getPrefWidth(), skillFieldCard.getPrefHeight()));
            FieldCardController fieldCardController = fieldCardLoader.getController();
            fieldCardController.setFieldCard(card);
            String colorCard = "";

            if (card.getSkillCard() instanceof AuraCard) {
                colorCard = "01BAEB";
            } else if (card.getSkillCard() instanceof DestroyCard) {
                colorCard = "D13539";
            } else if (card.getSkillCard() instanceof PowerUpCard) {
                colorCard = "A57FBB";
            }

            if (player == 1) {
                skillFieldCardA.add(skillFieldCard, x, 0, 1, 1);
            } else { //player == 2
                skillFieldCardB.add(skillFieldCard, x, 0, 1, 1);
            }
            String style = "-fx-background-color: #" + colorCard + ";";
            if (selected1 instanceof SkillFieldCard && card == selected1) {
                style += " -fx-border-color: BLACK; -fx-border-width: 5;";
            } else if (selected1 instanceof CharacterFieldCard && card.getOwner() == selected1) {
                style += " -fx-border-color: YELLOW; -fx-border-width: 5;";
            }
            skillFieldCard.setStyle(style);
            addHoverEvent(card, skillFieldCard);
            skillFieldCard.setOnMouseClicked(e -> {
                if (selected1 == null) selected1 = card;
                else selected2 = card;
                updateBoard();
            });
        } catch (IOException e) {
            System.out.println("Exception: " + e);
        }
    }

    /**
     * Add hover event to a card on hand.
     * @param card Card to hover.
     * @param pane The card's pane. In this case, the hand card pane.
     */
    public void addHoverEvent(Card card, Pane pane) {
        pane.setOnMouseEntered((MouseEvent t) -> this.displayCard(card));
        pane.setOnMouseExited((MouseEvent t) -> cardDetail.setCenter(new Pane()));
    }

    /**
     * Add hover event to a card on the character field.
     * @param card CharacterFieldCard to hover.
     * @param pane The card's pane. In this case, the character field pane.
     */
    public void addHoverEvent(CharacterFieldCard card,Pane pane) {
        pane.setOnMouseEntered((MouseEvent t) -> this.displayCard(card.getCharacterCard()));
        pane.setOnMouseExited((MouseEvent t) -> cardDetail.setCenter(new Pane()));
    }

    /**
     * Add hover event to a card on the skill field.
     * @param card SkillFieldCard to hover.
     * @param pane The card's pane. In this case, the skill field pane.
     */
    public void addHoverEvent(SkillFieldCard card,Pane pane) {
        pane.setOnMouseEntered((MouseEvent t) -> this.displayCard(card.getSkillCard()));
        pane.setOnMouseExited((MouseEvent t) -> cardDetail.setCenter(new Pane()));
    }

    /**
     * @param board Board where the game takes place.
     */
    public void setBoard(Board board) {
        this.board = board;
    }

    /**
     * Initializes click event handlers for endTurnButton, nextPhaseButton, discardButton,
     * characterFieldCardA and characterFieldCardB.
     */
    public void initializeClick(){
        endTurnButton.setOnAction((e -> {
            clearSelected();
            clearMessage();
            board.switchTurn();
            updateBoard();
            board.getCurrentPlayer().setIsLandCardDeployed(false);
            updateCharacterFieldCardAttackAvailability(board.getCurrentPlayer().getCharacterFieldCard());
            nextPhaseButton.setDisable(false);
        }));
        nextPhaseButton.setOnAction((e -> {
            clearSelected();
            clearMessage();
            board.nextPhase();
            updateBoard();
            if (board.getPhase() == Phase.BATTLE){
                nextPhaseButton.setDisable(true);
            }
        }));
        discardButton.setOnAction((event -> {
            if (selected1 == null){
                sendMessage("Please click on your card before clicking this button");
            } else {
                if (selected1.getField() != board.getTurn()){
                    sendMessage("You can only discard your own card");
                    clearSelected();
                } else {
                    if (board.getPhase() == Phase.MAIN){
                        if (selected1 instanceof CharacterFieldCard){
                            sendMessage("Discard fail.You can only discard skill Card");
                        } else {
                            board.getCurrentPlayer().discardSkillFieldCard((SkillFieldCard) selected1);
                            clearSelected();
                        }
                        updateBoard();
                    } else {
                        sendMessage("Discard fail. Wrong Phase");
                        clearSelected();
                    }
                }
            }
        }));
        characterFieldCardA.setOnMouseClicked(event -> {
            if ((board.getTurn()==2) && (board.getOppositePlayer().getCharacterFieldCard().isEmpty() &&
                selected1!= null && selected1.getField()==board.getTurn() &&
                selected1 instanceof CharacterFieldCard && ((CharacterFieldCard) selected1).getPosition() == 1) && board.getPhase()==Phase.BATTLE){
                board.getCurrentPlayer().attackOpponentPlayer((CharacterFieldCard)selected1,board.getOppositePlayer());
                sendMessage("You opponent's hp is dropping");
                updateBoard();
            }
        });
        characterFieldCardB.setOnMouseClicked(event -> {
            if ((board.getTurn()==1) && (board.getOppositePlayer().getCharacterFieldCard().isEmpty() &&
                    selected1!= null && selected1.getField()==board.getTurn() &&
                    selected1 instanceof CharacterFieldCard && ((CharacterFieldCard) selected1).getPosition() == 1) && board.getPhase()==Phase.BATTLE){
                board.getCurrentPlayer().attackOpponentPlayer((CharacterFieldCard)selected1,board.getOppositePlayer());
                sendMessage("You opponent's hp is dropping");
                updateBoard();
            }
        });
    }

    /**
     * Sends message to current player.
     * The message will be displayed in the current player's message box.
     * @param text String to send.
     */
    public void sendMessage(String text) {
        if (board.getTurn() == 1) {
            messageA.setText(text);
        } else {
            messageB.setText(text);
        }
    }

    /**
     * Clears current player's message box.
     */
    public void clearMessage() {
        if (board.getTurn() == 1) {
            messageA.setText("");
        } else {
            messageB.setText("");
        }
    }

    /**
     * Clears both selected cards by setting it back to null.
     */
    public void clearSelected() {
        selected1 = null;
        selected2 = null;
    }

    /**
     * Replaces selected1 with selected2.
     * Sets selected2 with null.
     */
    public void updateSelected(){
//        if (selected1 instanceof CharacterFieldCard && selected2 instanceof SkillFieldCard){
//            selected1 = selected2;
//        } else if (selected1 instanceof SkillFieldCard && selected2 instanceof CharacterFieldCard) {
//            selected1 = selected2;
//        } else {
//            selected1 = selected2;
//        }
        selected1 = selected2;
        selected2 = null;
    }

    /**
     * selected1 is guaranteed to be a skill field card.
     * @return selected1's skill type in string.
     */
    public String selectedSkillType(){
        String skillType;
        if (((SkillFieldCard) selected1).getSkillCard() instanceof  AuraCard){
            skillType = "Aura";
        } else if (((SkillFieldCard) selected1).getSkillCard() instanceof  PowerUpCard){
            skillType = "Power up";
        } else {
            skillType = "Destroyer";
        }
        return skillType;
    }

    /**
     * Updates messages and game status according to the selected1 and selected2.
     */
    public void processSelected() {
        if (selected1 == null) return;
        if (selected1.getField() != board.getTurn()) {
            selected1 = null;
            sendMessage("Can't select enemy card.");
        } else if (board.getPhase() == Phase.MAIN) {
            if (selected1 instanceof CharacterFieldCard) {
                if (selected1 == selected2) {
                    ((CharacterFieldCard) selected1).rotate();
                    sendMessage("Successfully changed card position.");
                    clearSelected();
                } else if (selected2 == null) {
                    sendMessage("Click one more time to rotate.");
                } else { // selected2 != selected1
                    if (selected2.getField() != board.getTurn()) {
                        sendMessage("Invalid Move");
                        clearSelected();
                    } else { //selected1 == Character && selected2 == Skill or CharacterCard
                        updateSelected();
                        if (selected1 instanceof CharacterFieldCard){
                            sendMessage("Click one more time to rotate");
                        } else {//selected1 instance of SkillFieldCard
                            if (((SkillFieldCard) selected1).getOwner() == null){
                                String skillType = selectedSkillType();
                                sendMessage("Click card to use" + skillType + " or Click discard button");
                            } else {
                                sendMessage("Skill used.Click discard button to discard");
                            }
                        }

                    }
                }
            } else { // selected1 instance of skillcard
                if (selected1 != null && selected2 != null && selected1 == selected2){
                    clearSelected();
                } else if (selected2 == null) {
                    if (selected1 != null) {
                        if (((SkillFieldCard) selected1).getOwner() == null){
                            String skillType = selectedSkillType();
                            sendMessage("Click card to use " + skillType + " or Click discard button");
                        } else {
                            sendMessage("Skill used.Click discard button to discard");
                        }
                    }
                } else {// selected2 != null
                    if (selected2 instanceof CharacterFieldCard) {
                        //Use Skill card
                        if (selected1 != null) {
                            if (((SkillFieldCard) selected1).getOwner() == null){
                                Player target, notTarget;
                                if (selected2.getField() == 1){
                                    target = board.getP1();
                                    notTarget = board.getP2();
                                } else {
                                    target = board.getP2();
                                    notTarget = board.getP1();
                                }
                                String stringType = selectedSkillType();
                                if (((SkillFieldCard) selected1).getSkillCard() instanceof AuraCard) {
                                    board.getCurrentPlayer().useAura((SkillFieldCard)selected1,(CharacterFieldCard) selected2,target);
                                } else if (((SkillFieldCard) selected1).getSkillCard() instanceof DestroyCard) {
                                    board.getCurrentPlayer().useDestroyer((SkillFieldCard)selected1, (CharacterFieldCard)selected2, target);
                                } else {
                                    board.getCurrentPlayer().usePowerUp((SkillFieldCard)selected1,(CharacterFieldCard)selected2,target);
                                }
                                sendMessage(stringType +" succesfully used");
                                clearSelected();
                            } else {
                                sendMessage("This skill already used.Click discard button to discard");
                            }
                        }
                    } else {// selected2 instanceof SkillCard
                        if (selected2.getField() != board.getTurn()) {//selected2 == enemy's skillFieldCard
                            sendMessage("Invalid Move !!! Wrong Phase");
                            clearSelected();
                        } else {
                            updateSelected();
                            sendMessage("Click any character card to use you Card. Click the discard button if you wish discard");
                        }
                    }
                }
            }
        } else if  (board.getPhase() == Phase.BATTLE){
            if (((CharacterFieldCard) selected1).getBattleAvailability() == 1){
                if (selected1 instanceof CharacterFieldCard){
                    if (((CharacterFieldCard)selected1).getPosition() == 0 ){
                        sendMessage("Defense card cannot do anything in this Phase");
                    } else{
                        if (selected2 == null) {
                            if (board.getOppositePlayer().getCharacterFieldCard().isEmpty()) {
                                sendMessage("No character card in sight. Click on the enemy field to attack its HP!");
                            } else {
                                sendMessage("Click enemy character card to attack");
                            }
                            //Case when attack opponentPlayer if enemy's field card contains no character card is handle in onClick event in enemyGridpane
                        }else {//selected2 != null
                            if (selected2.getField() != board.getTurn()){
                                if (selected2 instanceof CharacterFieldCard){
                                    //Attack
                                    if (((CharacterFieldCard)selected1).getPosition() == 1 ){
                                        if (board.getCurrentPlayer().attack((CharacterFieldCard) selected1, (CharacterFieldCard) selected2, board.getOppositePlayer())){
                                            if (((CharacterFieldCard)selected1).hasPowerUp() && ((CharacterFieldCard)selected2).getPosition() == 0){
                                                sendMessage("You attack successfully with PowerUp skill");
                                            } else{
                                                sendMessage("You attack succesfully on enemy card");
                                            }
                                        } else{
                                            sendMessage("Attack not valid, your card's attack value is too low");
                                        }
                                    } else {
                                        sendMessage("Defense card cannot do anything in this Phase");
                                    }
                                } else {
                                    sendMessage("Cannot attack skill card");
                                }
                                clearSelected();
                            } else {//selected2 is my own card
                                if (selected2 == selected1){
                                    sendMessage("Rotate Fail.Wrong Phase !!!");
                                    clearSelected();
                                } else {
                                    if (selected2 instanceof CharacterFieldCard){
                                        updateSelected();
                                        sendMessage("Click enemy character card to attack");
                                    } else {
                                        updateSelected();
                                        String skillType = selectedSkillType();
                                        sendMessage("Click card to use " + skillType + " or Click discard button");
                                    }
                                }
                            }
                        }
                    }
                }else {
                    sendMessage("This card is currently not available to launch attack.");
                    clearSelected();
                }
            } else{ //selected1 instance of SkillFieldCard
                sendMessage("You cannot do anything with this card in this phase");
                clearSelected();
            }
        } else{//DRAW PHASE
            sendMessage("Nothing you can do in this PHASE. Click Next Phase");
        }
    }

    /**
     * Updates each player's hand card pane according to their on hand card list.
     * @param p1 list of cards on player 1's hand.
     * @param p2 list of cards on player 2's hand.
     */
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

    /**
     * Sets all character field cards to be able to attack.
     * @param cp list of character field cards to be updated.
     */
    public void updateCharacterFieldCardAttackAvailability(List<CharacterFieldCard> cp){
        for (CharacterFieldCard characterFieldCard: cp){
            characterFieldCard.setBattleAvailability(1);
        }
    }

    /**
     * Updates each player's character field according to their character field card list.
     * @param p1 list of character field cards on player 1's character field.
     * @param p2 list of character field cards on player 2's character field.
     */
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

    /**
     * Updates each player's skill field according to their skill field card list.
     * @param p1 list of skill field cards on player 1's skill field.
     * @param p2 list of skill field cards on player 2's skill field.
     */
    public void updateSkillFieldCardDisplay(List<SkillFieldCard> p1, List<SkillFieldCard> p2) {
        skillFieldCardA.getChildren().clear();
        skillFieldCardB.getChildren().clear();
        for (int i = 0; i < p1.size(); i++) {
            displaySkillFieldCard(p1.get(i), 1, i);
        }
        for (int i = 0; i < p2.size(); i++) {
            displaySkillFieldCard(p2.get(i), 2, i);
        }
    }

    /**
     * Update each player's data fields.
     * @param p1 Player 1.
     * @param p2 Player 2.
     */
    public void updatePlayerData(Player p1, Player p2) {
        deckCountA.setText(Integer.toString(p1.getDeck().getDeckCount()));
        hpA.setText(Integer.toString(p1.getHp()));
        airA.setText(p1.getCurAir() + " / " + p1.getMaxAir());
        fireA.setText(p1.getCurFire() + " / " + p1.getMaxFire());
        earthA.setText(p1.getCurEarth() + " / " + p1.getMaxEarth());
        waterA.setText(p1.getCurWater() + " / " + p1.getMaxWater());
        energyA.setText(p1.getCurEnergy() + " / " + p1.getMaxEnergy());
        if (p1.getIsLandCardDeployed()) landA.setText("YES");
        else landA.setText("NO");

        deckCountB.setText(Integer.toString(p2.getDeck().getDeckCount()));
        hpB.setText(Integer.toString(p2.getHp()));
        airB.setText(p2.getCurAir() + " / " + p2.getMaxAir());
        fireB.setText(p2.getCurFire() + " / " + p2.getMaxFire());
        earthB.setText(p2.getCurEarth() + " / " + p2.getMaxEarth());
        waterB.setText(p2.getCurWater() + " / " + p2.getMaxWater());
        energyB.setText(p2.getCurEnergy() + " / " + p2.getMaxEnergy());
        if (p2.getIsLandCardDeployed()) landB.setText("YES");
        else landB.setText("NO");
    }

    /**
     * Check if there is a winner in the game.
     * If yes, pops up an alert box displaying the winner of the game.
     * Allows user to restart the game if the game finishes.
     */
    public void checkWinner() {
        if (board.getP1().getHp() <= 0 || board.getP1().getDeck().isDeckEmpty()) {
            ButtonType restart = new ButtonType("Restart Game");
            Alert alert = new Alert(AlertType.CONFIRMATION, "Player 2 Wins!", restart);
            alert.showAndWait().ifPresent(response -> {
                if (response == restart) {
                    CardReader cardReader = CardReader.getInstance();
                    nextPhaseButton.setDisable(false);
                    board = new Board(cardReader);
                    messageA.clear();
                    messageB.clear();
                    updateBoard();
                }
            });
        } else if (board.getP2().getHp() <= 0 || board.getP2().getDeck().isDeckEmpty()) {
            ButtonType restart = new ButtonType("Restart Game");
            Alert alert = new Alert(AlertType.CONFIRMATION, "Player 1 Wins!", restart);
            alert.showAndWait().ifPresent(response -> {
                if (response == restart) {
                    CardReader cardReader = CardReader.getInstance();
                    nextPhaseButton.setDisable(false);
                    board = new Board(cardReader);
                    messageA.clear();
                    messageB.clear();
                    updateBoard();
                }
            });
        }
    }

    /**
     * Updates the board.
     */
    public void updateBoard() {
        processSelected();
        updateHandCardDisplay(board.getP1().getOnHand(), board.getP2().getOnHand());
        updateCharacterFieldCardDisplay(board.getP1().getCharacterFieldCard(), board.getP2().getCharacterFieldCard());
        updateSkillFieldCardDisplay(board.getP1().getSkillFieldCard(), board.getP2().getSkillFieldCard());
        updatePlayerData(board.getP1(), board.getP2());
        checkWinner();
        if (board.getTurn() == 1) this.playerText.setText("PLAYER A");
        else this.playerText.setText("PLAYER B");
        this.phaseText.setText(board.getPhase().toString());
    }
}