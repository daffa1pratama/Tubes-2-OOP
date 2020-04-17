package com.avatarduel;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

import com.avatarduel.card.*;
import com.avatarduel.board.*;

public class AvatarDuel extends Application {
  private BoardController boardController;

  @Override
  public void start(Stage stage) throws Exception {
    CardReader cardReader = CardReader.getInstance();
    Board board = new Board(cardReader);
    stage.show();
    FXMLLoader boardLoader = new FXMLLoader(getClass().getResource("views/Board.fxml"));
    Parent root = boardLoader.load();
    boardController = boardLoader.getController();
//    boardController.setCardReader(cardReader);
    boardController.setBoard(board);
    boardController.updateBoard();

    Scene scene = new Scene(root);
    stage.setTitle("Avatar Duel");
    stage.setScene(scene);
  }

  public static void main(String[] args) {
    launch();
  }
}

