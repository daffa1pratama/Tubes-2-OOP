package com.avatarduel;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import com.avatarduel.board.Board;
import com.avatarduel.card.Element;
import com.avatarduel.card.CharacterCard;
import com.avatarduel.card.LandCard;
import com.avatarduel.card.AuraCard;
import com.avatarduel.card.DestroyCard;
import com.avatarduel.card.PowerUpCard;
import com.avatarduel.card.CardCollection;
import com.avatarduel.util.CSVReader;

public class AvatarDuel extends Application {
  private CardCollection characterCardCollection;
  private CardCollection landCardCollection;
  private CardCollection auraCardCollection;
  private static final String CHARACTER_CSV_FILE_PATH = "card/data/character.csv";
  private static final String LAND_CSV_FILE_PATH = "card/data/land.csv";
  private static final String AURA_CSV_FILE_PATH = "card/data/skill_aura.csv";

  public void loadCards() throws IOException, URISyntaxException {
    characterCardCollection = new CardCollection();
    landCardCollection = new CardCollection();
    auraCardCollection = new CardCollection();
    File characterCSVFile = new File(getClass().getResource(CHARACTER_CSV_FILE_PATH).toURI());
    File landCSVFile = new File(getClass().getResource(LAND_CSV_FILE_PATH).toURI());
    File auraCSVFile = new File(getClass().getResource(AURA_CSV_FILE_PATH).toURI());

    CSVReader characterReader = new CSVReader(characterCSVFile, "\t");
    characterReader.setSkipHeader(true);
    List<String[]> characterRows = characterReader.read();
    for (String[] row : characterRows) {
      CharacterCard l = new CharacterCard(row[1], row[3], Element.valueOf(row[2]), Integer.parseInt(row[5]), Integer.parseInt(row[6]), Integer.parseInt(row[7]));
      characterCardCollection.addCard(l);
    }
    CSVReader landReader = new CSVReader(landCSVFile, "\t");
    landReader.setSkipHeader(true);
    List<String[]> landRows = landReader.read();
    for (String[] row : landRows) {
      LandCard l = new LandCard(row[1], row[3], Element.valueOf(row[2]));
      landCardCollection.addCard(l);
    }
    CSVReader auraReader = new CSVReader(auraCSVFile, "\t");
    auraReader.setSkipHeader(true);
    List<String[]> auraRows = auraReader.read();
    for (String[] row : auraRows) {
      AuraCard l = new AuraCard(row[1], row[3], Element.valueOf(row[2]), Integer.parseInt(row[6]), Integer.parseInt(row[7]), Integer.parseInt(row[5]));
      auraCardCollection.addCard(l);
    }
  }

  @Override
  public void start(Stage stage) throws Exception {
    Text text = new Text();
    text.setText("Loading...");
    text.setX(50);
    text.setY(50);
    
    Group root = new Group();
    root.getChildren().add(text);

    Scene scene = new Scene(root, 1280, 720);

    stage.setTitle("Avatar Duel");
    stage.setScene(scene);
    stage.show();

    try {
      this.loadCards();
    } catch (Exception e) {
      Alert errorAlert = new Alert(AlertType.ERROR);
      errorAlert.setHeaderText("Card loading failed");
      errorAlert.setContentText("Failed to load cards: " + e);
      errorAlert.showAndWait();
    }
    
    Board board = new Board(characterCardCollection, landCardCollection, auraCardCollection);
    board.runGame();
    text.setText("Avatar Duel!");
    Button button = new Button("Test");
    button.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent actionEvent) {
        CharacterCard aang = new CharacterCard("Aang", "Botak, gundul", Element.AIR, 100, 100, 1);
        Text test = new Text();
        test.setX(100);
        test.setY(100);
        test.setText(aang.CardInfo());
        root.getChildren().add(test);
      }
    });
    root.getChildren().add(button);
  }

  public static void main(String[] args) {
    launch();
  }
}