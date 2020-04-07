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
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.control.*;
import javafx.scene.layout.*;

import com.avatarduel.card.*;

public class BoardController {
    @FXML
    private AnchorPane dataPane;

    @FXML
    private AnchorPane battlePane;

    @FXML
    private BorderPane cardDetail;

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
}