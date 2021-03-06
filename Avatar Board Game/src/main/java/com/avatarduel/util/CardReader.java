package com.avatarduel.util;

import com.avatarduel.card.*;
import javafx.scene.control.Alert;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

/**
 * CardReader is a class to read card information from CSV files
 */
public class CardReader {
    private static CardReader instance;
    private CardCollection characterCardCollection;
    private CardCollection landCardCollection;
    private CardCollection auraCardCollection;
    private CardCollection destroyCardCollection;
    private CardCollection powerupCardCollection;
    private static final String CHARACTER_CSV_FILE_PATH = "/com/avatarduel/card/data/character.csv";
    private static final String LAND_CSV_FILE_PATH = "/com/avatarduel/card/data/land.csv";
    private static final String AURA_CSV_FILE_PATH = "/com/avatarduel/card/data/skill_aura.csv";
    private static final String DESTROY_CSV_FILE_PATH = "/com/avatarduel/card/data/skill_destroy.csv";
    private static final String POWERUP_CSV_FILE_PATH = "/com/avatarduel/card/data/skill_powerup.csv";

    /**
     * Constructor of CardReader
     */
    private CardReader() {
        try {
            loadCards();
        } catch (Exception e) {
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setHeaderText("Card loading failed");
            errorAlert.setContentText("Failed to load cards: " + e);
            errorAlert.showAndWait();
        }
    }

    /**
     * Getter instance of CardReader
     * @return Instance of CardReader
     */
    public static CardReader getInstance() {
        if (instance == null) {
            instance = new CardReader();
        }
        return instance;
    }

    /**
     * Read card information from CSV files using CSVReader
     * @throws IOException Throw when there's error when reading files
     * @throws URISyntaxException Throw when file name not found
     */
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
            DestroyCard l = new DestroyCard(row[1], row[3], Element.valueOf(row[2]),row[4], Integer.parseInt(row[5]));
            destroyCardCollection.addCard(l);
        }
        CSVReader powerupReader = new CSVReader(powerupCSVFile, "\t");
        powerupReader.setSkipHeader(true);
        List<String[]> powerupRows = powerupReader.read();
        for (String[] row : powerupRows) {
            PowerUpCard l = new PowerUpCard(row[1], row[3], Element.valueOf(row[2]),row[4], Integer.parseInt(row[5]));
            powerupCardCollection.addCard(l);
        }
    }

    /**
     * Getter character card collection
     * @return Character card collection
     */
    public CardCollection getCharacterCardCollection() { return this.characterCardCollection; }
    /**
     * Getter land card collection
     * @return Land card collection
     */
    public CardCollection getLandCardCollection() { return this.landCardCollection; }
    /**
     * Getter aura card collection
     * @return Aura card collection
     */
    public CardCollection getAuraCardCollection() { return this.auraCardCollection; }
    /**
     * Getter destroy card collection
     * @return Destroy card collection
     */
    public CardCollection getDestroyCardCollection() { return this.destroyCardCollection; }
    /**
     * Getter power up card collection
     * @return Power up card collection
     */
    public CardCollection getPowerupCardCollection() { return this.powerupCardCollection; }
}
