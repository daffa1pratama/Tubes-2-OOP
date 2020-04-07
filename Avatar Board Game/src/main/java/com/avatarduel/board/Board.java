package com.avatarduel.board;

import com.avatarduel.deck.Deck;
import com.avatarduel.player.Player;
import com.avatarduel.card.CardCollection;
import com.avatarduel.card.CharacterCard;
import com.avatarduel.card.Card;
import com.avatarduel.card.Element;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.text.*;
import javafx.scene.control.*;
import javafx.scene.Group;

public class Board {

    private Player p1;
    private Player p2;
    private Player winner;
    private Player currentPlayer;
    private int turn; //1 or 2

    //MAIN BOARD IMPLEMENTS HERE

    public Board(CardCollection characterCardCollection, CardCollection landCardCollection, CardCollection auraCardCollection) {
        this.p1 = new Player("P1", characterCardCollection, landCardCollection, auraCardCollection);
        this.p2 = new Player("P2", characterCardCollection, landCardCollection, auraCardCollection);
        this.turn = 1;
        this.winner = null;
        this.currentPlayer = this.p1;
        this.turn = 1;
    }

    public void printCards() {
        // Careful. Both decks will be emptied. For debugging purposes only.
        System.out.println("Player 1:");
        Deck D1 = this.p1.getDeck();
        for (int i = 0; i < D1.getDeckSize(); i++) {
            Card C = D1.drawCard();
            C.InfoCard();
        }
        System.out.println();
        System.out.println("Player 2:");
        Deck D2 = this.p2.getDeck();
        for (int i = 0; i < D2.getDeckSize(); i++) {
            Card C = D2.drawCard();
            C.InfoCard();
        }
    }

//    public void runGame(Group root) {
//        // main game algo
//        Button button = new Button("Test");
//        button.setOnAction(new EventHandler<ActionEvent>() {
//        @Override
//        public void handle(ActionEvent actionEvent) {
//            CharacterCard aang = new CharacterCard("Aang", "Botak, gundul", Element.AIR, 100, 100, 1);
//            Text test = new Text();
//            test.setX(100);
//            test.setY(100);
//            test.setText(aang.CardInfo());
//            root.getChildren().add(test);
//        }
//        });
//        root.getChildren().add(button);
//    }
}
