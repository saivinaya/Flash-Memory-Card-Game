/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package a3_task1;

import java.io.Console;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * This class has 3 methods, InitializeCards() is used to initialize the deck with the set of cards that are available
 * ShowCards() which takes the initialized 2D Array and is used to play the interactive game and 
 * addElement() takes the x & y position and the 2D array and 
 * is used to add the position of cards that have already been matched so as to not let the user enter the same positions again and again.
 * @author VinayaSaiD
 */
public class MemoryGame {
    // given set of cards that needs to be suffled 
    private String[] cards = {"A", "A", "Q", "Q", "K", "K", "J", "J", "2", "2", "5", "5", "6", "6", "9", "9"};
    
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
        //printArray(cardsInitialize);
        return cardsInitialize;
    }
    
    // This is to print any 2D array String array
    public void printArray(String[][] arrayToPrint){
        for(int i=0;i<4;i++) {
                for(int j=0;j<4;j++) {
                     System.out.print(arrayToPrint[i][j]+" ");
                }
                    System.out.println();
            }
    }
    
    public void showCards(String[][] initializedArray){
        // display matrix to the players
        String arrayGame[][]={ {"$","$","$","$"}, 
                               {"$","$","$","$"}, 
                               {"$","$","$","$"}, 
                               {"$","$","$","$"} }; 
        String card1;
        int x1 = 0,y1 = 0;
        String card2;
        int x2 = 0,y2 = 0;
        int counter=0;
        Scanner input = new Scanner(System.in);
        Scanner input1 = new Scanner(System.in);
        Scanner input2 = new Scanner(System.in);
        // variable to take in if the player want to continue playing
        String cont = "y";
        // maintain the coordinates of cards that are laready opened 16*2 2D matrix will be used
        int[][] openedArray = {{0,0}};
        while(cont.equals("y") || cont.equals("Y"))
        { 
            System.out.println("----------------------------------");
            //Display the puzzle to the player
            printArray(arrayGame);
            //Console cnsl = System.console();
            // Temporary array to display the picked card in the puzzle
            String[][] tempArray = new String[4][4];
            boolean alreadyMatched1 = true;
            // loop to repeat if the entered coordinate is already matched
            while (alreadyMatched1 == true) {
                System.out.println("Please enter the row and column (separated by comma without space) of the first Card to pick:");
                card1=input1.nextLine();
                System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                // split the 2 coordinates
                String[] coordinate1 = card1.split(",");
                // make them as integers
                x1 = Integer.parseInt(coordinate1[0]);
                y1 = Integer.parseInt(coordinate1[1]);
                // As the board is 4 * 4 checking if the entered coordinates are valid
                if (x1 > 4 || y1 > 4) {
                    alreadyMatched1 = true;
                    System.out.println("Wrong input. Please try again.");
                }
                // if they are valid continue
                else {
                    // checking if the selected card is already matched
                    for (int i=0;i < (openedArray.length);i++){
                        if (x1 == openedArray[i][0] && y1 == openedArray[i][1]) {
                            alreadyMatched1 = true;
                            System.out.println("Card already matched. Pick a new card.");
                            break;
                           }
                        else{
                            alreadyMatched1 = false;
                        }
                    }
                    // Generating the temporary array from the actual
                    for(int i=0;i<4;i++) {
                        for(int j=0;j<4;j++) {
                             tempArray[i][j] = arrayGame[i][j];
                        }
                    }
                    // adding the selected card to the temporary display
                    tempArray[x1-1][y1-1] = initializedArray[x1-1][y1-1];
                    // printing the board with the selected card
                    printArray(tempArray);
                }
            }
            
            boolean alreadyMatched2 = true;
            while (alreadyMatched2 == true){
                System.out.println("Please enter the row and column (separated by comma without space) of the second Card to pick:");
                card2=input2.nextLine();
                System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                // split the 2 coordinates
                String[] coordinate2 = card2.split(",");
                // make them as integers
                x2 = Integer.parseInt(coordinate2[0]);
                y2 = Integer.parseInt(coordinate2[1]);
                // As the board is 4 * 4 checking if the entered coordinates are valid
                if (x2 > 4 || y2 > 4) {
                    alreadyMatched2 = true;
                    System.out.println("Wrong input. Please try again");
                }
                // if they are valid continue
                else{
                    // checking if the selected card is already matched
                    for (int i=0;i < (openedArray.length);i++){
                            if (x2 == openedArray[i][0] && y2 == openedArray[i][1]) {
                                alreadyMatched2 = true;
                                System.out.println("Card already matched. Pick a new card.");
                                break;
                               }
                            else{
                                alreadyMatched2 = false;
                            }
                    }
                    // adding the selected card to the temporary display
                    tempArray[x2-1][y2-1] = initializedArray[x2-1][y2-1];
                    // printing the board with the selected card
                    printArray(tempArray);
                }
            }
            // checking if the selected cards are same or not
            if (initializedArray[x1-1][y1-1].equals(initializedArray[x2-1][y2-1])){
                // assigning to the board the matched cards and display them permanently
                arrayGame[x1-1][y1-1] = initializedArray[x1-1][y1-1];
                arrayGame[x2-1][y2-1] = initializedArray[x2-1][y2-1];
                System.out.println("Good Flip! Match Found!");
                // maintaining an array to know which are laready matched
                openedArray = addElement(openedArray,x1,y1);
                openedArray = addElement(openedArray,x2,y2);
                // so, after 8 matches the user wins so maintaining this count
                counter++;
            }
            // If its not a match printing the same.
            else{
                System.out.println("Not a match. Try again.");
            }
            // Once 8 matches are done, the game is finisihed
            if (counter==8)
            {
                // Display the final message that he won the game
                System.out.println("Congratulations!! Game Finished!");
                //exit out of the game once won
                System.exit(0);
            }
            // if the entire puzzle is not done we need to continue the loop.
            else
            {   cont = "";
                while (!(cont.equals("y") || cont.equals("Y") || cont.equals("N") || cont.equals("n"))) {
                    // Asking if the player want to continue
                    System.out.println("Do you want to continue the game. Please enter Y or N: ");
                    cont = input.next();
                    System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                   
                }
                //Runtime.getRuntime().exec("cls");
                //System.out.print("\f");
                //System.out.flush();
                //cnsl.flush();
            }
        }
        // if the user quits the game. Diplay this message
        System.out.println("Thank you for playing.");
    }
    
    // This is used to add the already matched coordinates to an array
    public int[][] addElement(int[][] openedArray, int x, int y) {
        int[][] result = new int[openedArray.length+1][2];
        for (int i =0;i< openedArray.length; i++)
                {
                    result[i][0] = openedArray[i][0];
                    result[i][1] = openedArray[i][1];
                }
        result[openedArray.length][0] = x;
        result[openedArray.length][1] = y;
        return result;
    }
}
