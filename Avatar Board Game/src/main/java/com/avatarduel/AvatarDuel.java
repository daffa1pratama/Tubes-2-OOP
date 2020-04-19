package com.avatarduel;

import com.avatarduel.util.CardReader;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import com.avatarduel.board.*;

/**
 * AvatarDuel is the main class of this project that launch the application
 */
public class AvatarDuel extends Application {
  private BoardController boardController;

  /**
   * Method to start the stage.
   * @param stage is the stage of the game
   * @throws Exception when there is an error happening
   */
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
    stage.setTitle("Avatar Duel Board Game");
    stage.setScene(scene);
  }

  /**
   * main method to launch the program
   * @param args Main program arguments
   */
  public static void main(String[] args) {
    launch();
  }
}

