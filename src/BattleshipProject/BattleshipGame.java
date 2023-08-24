package BattleshipProject;

import java.util.Scanner;

public class BattleshipGame {
// We’ll play this game on a 20x20 ocean. This is larger than the ocean in the traditional battleship game.  
// In this game we will have one 8-square Battleship, one 7-square Battlecruiser, two 6-square Cruisers, two 5-square Light Cruisers,
// three 4-square Destroyers and four 3-square Submarines. Finally, unlike the traditional game, A player can shoot 5 times in each turn.

// The BattleshipGame class is the ”main” class–that is, it contains a main method. In this class you will set up the game; 
// accept ”shots” from the user; display the results; print final scores; and ask the user if he/she wants to play again. 
// All input/output is done here (although some of it is done by calling a print() method in the Ocean class.) 
// All computation will be done in the Ocean class and the various Ship classes.

// Note that you want to accept 5 shots from the user. So you need to ensure that you have a well defined format for this. 
// For example you can provide an instruction to the user as follows

// The input format should look like this: 1, 1; 0, 3; 7, 3; 9, 11; 12, 17

// Note you will need to use the split method to parse this input string. See the following link for documentation

// split method


// To aid the user, row numbers should be displayed along the left edge of the array, and column numbers should be displayed along the top.
// Numbers should be 0 to 19, not 1 to 20. The top left corner square should be 0, 0. Use different characters to indicate locations that
// contain a hit, locations that contain a miss, and locations that have never been fired upon.

// Use methods. Don’t cram everything into one or two methods, but try to divide up the work into sensible parts with reasonable names.

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        // Ship empty = new EmptySea();
        Ocean ocean = new Ocean();
        int shotsFired = ocean.getShotsFired();
        int hitCount = ocean.getHitCount();

        System.out.println("Welcome to Battleship!");
        ocean.placeAllShipsRandomly();
        ocean.print();

        while(ocean.getShipsSunk() < 2) {

            System.out.println("Please provide 5 coordinates you wish to attack in the form:  1, 1; 0, 3; 7, 3; 9, 11; 12, 17");

            String[] coordinateSets = {};

            while (coordinateSets.length != 5) {
                String coordinates = keyboard.nextLine();

                coordinateSets = coordinates.split(";");
                
                if (coordinateSets.length != 5) {
                    System.out.println("you must provide 5 coordinates, you provided " + coordinateSets.length);
                }

            }

            // Print the individual coordinate sets
            for (String coordinateSet : coordinateSets) {
                shotsFired++;
                String[] coordinateValues = coordinateSet.split(",");

                // Extract the x and y values
                int x = Integer.parseInt(coordinateValues[0].trim());
                int y = Integer.parseInt(coordinateValues[1].trim());
                if  (ocean.isOccupied(x , y) == true) {
                    ocean.markShot(x, y);
                    System.out.println(coordinateSet.trim() + " Hit!");
                    hitCount++;
                }
                else {
                    ocean.markShot(x, y);
                    System.out.println(coordinateSet.trim() + " Miss");
                }
            }
            ocean.setHitCount(hitCount);
            ocean.setShotsFired(shotsFired);
            ocean.print();
            System.out.println("total shots fired: " + ocean.getShotsFired());
            System.out.println("total ships sunk: " + ocean.getShipsSunk());
        }

        
        


        keyboard.close();

    }

    public void playGame() {
    }
    
}
