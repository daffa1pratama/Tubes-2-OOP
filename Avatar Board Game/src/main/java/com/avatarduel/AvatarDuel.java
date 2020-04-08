package com.avatarduel;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.fxml.*;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.DragEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.control.*;
import javafx.scene.layout.*;

import com.avatarduel.card.*;
import com.avatarduel.util.*;
import com.avatarduel.board.*;

import javax.swing.text.html.ImageView;

public class AvatarDuel extends Application {
  private BoardController boardController;
  private CardCollection characterCardCollection;
  private CardCollection landCardCollection;
  private CardCollection auraCardCollection;
  private CardCollection destroyCardCollection;
  private CardCollection powerupCardCollection;
  private static final String CHARACTER_CSV_FILE_PATH = "card/data/character.csv";
  private static final String LAND_CSV_FILE_PATH = "card/data/land.csv";
  private static final String AURA_CSV_FILE_PATH = "card/data/skill_aura.csv";
  private static final String DESTROY_CSV_FILE_PATH = "card/data/skill_destroy.csv";
  private static final String POWERUP_CSV_FILE_PATH = "card/data/skill_powerup.csv";

  public void loadCards() throws IOException, URISyntaxException {
    characterCardCollection = new CardCollection();
    landCardCollection = new CardCollection();
    auraCardCollection = new CardCollection();
    destroyCardCollection = new CardCollection();
    powerupCardCollection = new CardCollection();
    File characterCSVFile = new File(getClass().getResource(CHARACTER_CSV_FILE_PATH).toURI());
    File landCSVFile = new File(getClass().getResource(LAND_CSV_FILE_PATH).toURI());
    File auraCSVFile = new File(getClass().getResource(AURA_CSV_FILE_PATH).toURI());
    File destroyCSVFile = new File(getClass().getResource(DESTROY_CSV_FILE_PATH).toURI());
    File powerupCSVFile = new File(getClass().getResource(POWERUP_CSV_FILE_PATH).toURI());

    CSVReader characterReader = new CSVReader(characterCSVFile, "\t");
    characterReader.setSkipHeader(true);
    List<String[]> characterRows = characterReader.read();
    for (String[] row : characterRows) {
      CharacterCard l = new CharacterCard(row[1], row[3], Element.valueOf(row[2]), row[4],Integer.parseInt(row[5]), Integer.parseInt(row[6]), Integer.parseInt(row[7]));
      characterCardCollection.addCard(l);
    }
    CSVReader landReader = new CSVReader(landCSVFile, "\t");
    landReader.setSkipHeader(true);
    List<String[]> landRows = landReader.read();
    for (String[] row : landRows) {
      LandCard l = new LandCard(row[1], row[3], Element.valueOf(row[2]),row[4]);
      landCardCollection.addCard(l);
    }
    CSVReader auraReader = new CSVReader(auraCSVFile, "\t");
    auraReader.setSkipHeader(true);
    List<String[]> auraRows = auraReader.read();
    for (String[] row : auraRows) {
      AuraCard l = new AuraCard(row[1], row[3], Element.valueOf(row[2]),row[4], Integer.parseInt(row[6]), Integer.parseInt(row[7]), Integer.parseInt(row[5]));
      auraCardCollection.addCard(l);
    }
    CSVReader destroyReader = new CSVReader(destroyCSVFile, "\t");
    destroyReader.setSkipHeader(true);
    List<String[]> destroyRows = destroyReader.read();
    for (String[] row : destroyRows) {
      DestroyCard l = new DestroyCard(row[1], row[3], Element.valueOf(row[2]),row[4], Integer.parseInt(row[6]), Integer.parseInt(row[7]), Integer.parseInt(row[5]));
      destroyCardCollection.addCard(l);
    }
    CSVReader powerupReader = new CSVReader(powerupCSVFile, "\t");
    powerupReader.setSkipHeader(true);
    List<String[]> powerupRows = powerupReader.read();
    for (String[] row : powerupRows) {
      PowerUpCard l = new PowerUpCard(row[1], row[3], Element.valueOf(row[2]),row[4], Integer.parseInt(row[6]), Integer.parseInt(row[7]), Integer.parseInt(row[5]));
      powerupCardCollection.addCard(l);
    }
  }

  @Override
  public void start(Stage stage) throws Exception {
    try {
      this.loadCards();
    } catch (Exception e) {
      Alert errorAlert = new Alert(AlertType.ERROR);
      errorAlert.setHeaderText("Card loading failed");
      errorAlert.setContentText("Failed to load cards: " + e);
      errorAlert.showAndWait();
    }
    Board board = new Board(characterCardCollection, landCardCollection, auraCardCollection);
    stage.show();
    FXMLLoader boardLoader = new FXMLLoader(getClass().getResource("views/Board.fxml"));
    Parent root = boardLoader.load();
    boardController = boardLoader.getController();
//    for (int i=0;i<=7;i++){
//      boardController.displayHandCard((CharacterCard) characterCardCollection.getCardAt(i+1),1,i);
//      boardController.displayHandCard((CharacterCard) characterCardCollection.getCardAt(i+9),2,i);
//    }
    Card test = characterCardCollection.getCardAt(3);
    if (test instanceof CharacterCard) {
      boardController.displayCard((CharacterCard) test);
    } else if (test instanceof LandCard) {
      boardController.displayCard((LandCard) test);
    } else if (test instanceof AuraCard) {
      boardController.displayCard((AuraCard) test);
    } else if (test instanceof DestroyCard) {
      boardController.displayCard((DestroyCard) test);
    } else if (test instanceof PowerUpCard) {
      boardController.displayCard((PowerUpCard) test);
    }

   boardController.fieldOnClick();

    Scene scene = new Scene(root);
    stage.setTitle("Avatar Duel");
    stage.setScene(scene);
  }

  public static void main(String[] args) {
    launch();
  }
}