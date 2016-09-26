/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package a3_task1;

import java.util.ArrayList;
import java.util.Random;

/**
 * This class is used to build the puzzle with the deck of cards and 
 * has one method InitializeCards() which is used to initialize the deck with the set of cards that are available
 * @author VinayaSaiD
 */
public class CardDeck {
    // given set of cards that needs to be suffled 
    private static String[] cards = {"A", "A", "Q", "Q", "K", "K", "J", "J", "2", "2", "5", "5", "6", "6", "9", "9"};
    
    public String[][] initializeCards(){
        String[][] cardsInitialize = new String[4][4];
        Random rand = new Random();
        ArrayList<String> finishedIndices = new ArrayList<String>();
        finishedIndices.add(Integer.toString(16));
        int randomIndex;
        // generate the matrix from the given cards using 2 for loops
        for(int i=0;i<4;i++) {
                for(int j=0;j<4;j++) {
                    // generating the random number between 0 and 15 to select cards from the deck
                    do{
                    randomIndex = rand.nextInt((15 - 0) + 1) + 0;
                    }
                    // repeat generating variable if that position is already used in building the puzzle
                    while(finishedIndices.contains(Integer.toString(randomIndex)));
                    // adding cards to the puzzle
                    cardsInitialize[i][j] = cards[randomIndex];
                    // maintaning the indicies which are alreay used and added to puzzle
                    finishedIndices.add(Integer.toString(randomIndex));
                }
        }
        // This is to print the initialized puzzle, you can use this for your testing purpose
        //MemoryGame gamz = new MemoryGame();
        //gamz.printArray(cardsInitialize);
        return cardsInitialize;
    }
    
}
