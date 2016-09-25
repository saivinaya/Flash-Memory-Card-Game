/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package a3_task1;

import java.util.*;
import java.io.Console;
/**
 * This is used to call the actual class and its methods which initializes the game deck and then allows to play the game.
 * @author VinayaSaiD
 */
public class A3_Task1 {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MemoryGame game = new MemoryGame();
        String[][] cardsDisplay = game.initializeCards();
        game.showCards(cardsDisplay);
    }
}
/**
 * This class has 3 methods, InitializeCards() is used to initialize the deck with the set of cards that are available
 * ShowCards() which takes the initialized 2D Array and is used to play the interactive game and 
 * addElement() takes the x & y position and the 2D array and 
 * is used to add the position of cards that have already been matched so as to not let the user enter the same positions again and again.
 * @author VinayaSaiD
 */
class MemoryGame{
    private String[] cards = {"A", "A", "Q", "Q", "K", "K", "J", "J", "2", "2", "5", "5", "6", "6", "9", "9"};
    
    public String[][] initializeCards(){
        String[][] cardsInitialize = new String[4][4];
        Random rand = new Random();
        ArrayList<String> finishedIndices = new ArrayList<String>();
        finishedIndices.add(Integer.toString(16));
        int randomIndex;
        for(int i=0;i<4;i++) {
                for(int j=0;j<4;j++) {
                    do{
                    randomIndex = rand.nextInt((15 - 0) + 1) + 0;
                    }
                    while(finishedIndices.contains(Integer.toString(randomIndex)));
                    cardsInitialize[i][j] = cards[randomIndex];
                    finishedIndices.add(Integer.toString(randomIndex));
                }
        }
        for(int i=0;i<4;i++) {
                for(int j=0;j<4;j++) {
                     System.out.print(cardsInitialize[i][j]+" ");
                }
                    System.out.println();
            }
        return cardsInitialize;
    }
    
    public void showCards(String[][] initializedArray){
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
        String cont = "y";
        int[][] openedArray = {{0,0}};
        while(cont.equals("y") || cont.equals("Y"))
        { 
            System.out.println("----------------------------------");
            for(int i=0;i<4;i++) {
                for(int j=0;j<4;j++) {
                     System.out.print(arrayGame[i][j]+" ");
                }
                    System.out.println();
            }
            Console cnsl = System.console();
            String[][] tempArray = new String[4][4];
            boolean alreadyMatched1 = true;
            while (alreadyMatched1 == true) {
                System.out.println("Please enter the row and column (separated by comma) of the first Card to pick:");
                card1=input1.nextLine();
                System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                String[] coordinate1 = card1.split(",");
                x1 = Integer.parseInt(coordinate1[0]);
                y1 = Integer.parseInt(coordinate1[1]);
                if (x1 > 4 || y1 > 4) {
                    alreadyMatched1 = true;
                    System.out.println("Wrong input. Please try again.");
                }
                else {
                    for(int i=0;i<4;i++) {
                        for(int j=0;j<4;j++) {
                             tempArray[i][j] = arrayGame[i][j];
                        }
                    }
                    tempArray[x1-1][y1-1] = initializedArray[x1-1][y1-1];
                    for(int i=0;i<4;i++) {
                        for(int j=0;j<4;j++) {
                             System.out.print(tempArray[i][j]+" ");
                        }
                            System.out.println();
                    }
                    for (int i=0;i < (openedArray.length);i++){
                        if (x1 == openedArray[i][0] && y1 == openedArray[i][1]) {
                            alreadyMatched1 = true;
                            System.out.println("Card already matched. pick a new card");
                            break;
                           }
                        else{
                            alreadyMatched1 = false;
                        }
                    }
                }
            }
            
            boolean alreadyMatched2 = true;
            while (alreadyMatched2 == true){
                System.out.println("Please enter the row and column (separated by comma) of the second Card to pick:");
                card2=input2.nextLine();
                System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                String[] coordinate2 = card2.split(",");
                x2 = Integer.parseInt(coordinate2[0]);
                y2 = Integer.parseInt(coordinate2[1]);
                if (x2 > 4 || y2 > 4) {
                    alreadyMatched2 = true;
                    System.out.println("Wrong input. Please try again");
                }
                else{
                    tempArray[x2-1][y2-1] = initializedArray[x2-1][y2-1];
                    for(int i=0;i<4;i++) {
                        for(int j=0;j<4;j++) {
                             System.out.print(tempArray[i][j]+" ");
                        }
                            System.out.println();
                    }
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
                }
            }

            if (initializedArray[x1-1][y1-1].equals(initializedArray[x2-1][y2-1])){
                arrayGame[x1-1][y1-1] = initializedArray[x1-1][y1-1];
                arrayGame[x2-1][y2-1] = initializedArray[x2-1][y2-1];
                System.out.println("Good Flip! Match Found!");
                openedArray = addElement(openedArray,x1,y1);
                openedArray = addElement(openedArray,x2,y2);
                counter++;
            }
            else{
                System.out.println("Not a match. Try again.");
                //System.out.println("The cards you picked are:");
                //System.out.println("At (" + (x1) + "," + (y1) + ") is: " + initializedArray[x1-1][y1-1]);
                //System.out.println("At (" + (x2) + "," + (y2) + ") is: " + initializedArray[x2-1][y2-1]);
            }
            if (counter==8)
            {
                System.out.println("Congratulations!! Game Finished!");
                System.exit(0);
            }
            else
            {   cont = "";
                while (!(cont.equals("y") || cont.equals("Y") || cont.equals("N") || cont.equals("n"))) {
                    
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
        System.out.println("Thank you for playing.");
    }
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
