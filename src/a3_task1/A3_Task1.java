/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package a3_task1;

import java.util.*;
import java.io.Console;
/**
 * This is used to call the actual class and its methods which initializes the game deck and then allows to play the game
 * 
 * @author VinayaSaiD
 */
public class A3_Task1 {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        CardDeck puzzle = new CardDeck();
        // Initialize the cards to play te game from the set provided
        String[][] cardsDisplay = puzzle.initializeCards();
        MemoryGame game = new MemoryGame();
        // calling the interactive game
        game.showCards(cardsDisplay);
    }
}
