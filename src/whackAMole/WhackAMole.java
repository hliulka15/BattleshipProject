package whackAMole;
import java.util.*;

public class WhackAMole {
	int score = 0;
	int molesLeft;
	int attemptsLeft;
	char[][] moleGrid;


	public static void main (String[] args) {
        /*In order to play this game you need to create a main method. 
        Begin by creating a 10 by 10 grid where you randomly place the moles. Place a total of 10 moles.
        Now allow the user (remember how to use Scanner?) to enter the x and y coordinates of where they would like to take a whack. 
        Tell them they have a maximum of 50 attempts to get all the moles. 
        At any point in the game, they can input coordinates of -1, -1 in order to indicate that they are giving up. If the user gives up they get to see the entire grid.   */
		WhackAMole whackAMole = new WhackAMole(50, 10);

        whackAMole.molesLeft = 10;

        Random r = new Random();
		int i = 0;
		while(i < whackAMole.molesLeft) {
			int x = r.nextInt(whackAMole.moleGrid.length);
			int y = r.nextInt(whackAMole.moleGrid.length);
            if (whackAMole.place(x, y)){
                i++;
            }
		}

        whackAMole.printGridToUser();
        
        Scanner keyboard = new Scanner(System.in);

        while(whackAMole.attemptsLeft > 0) {
            if(whackAMole.molesLeft == 0) {
                System.out.println("winner! Score: " + whackAMole.score);
            }

            System.out.print("\n\nYou have " + whackAMole.attemptsLeft + " attempts Left.\n\n");

			System.out.print("Enter x-coordinate: ");

			int xCoordinate = keyboard.nextInt();

			System.out.print("Enter y-coordinate: ");

			int yCoordinate = keyboard.nextInt();
            
            if (xCoordinate  == -1 && yCoordinate  == -1) {
				whackAMole.printGrid();
				break;	
			} else {
				whackAMole.whack(yCoordinate, xCoordinate);
			}
		}
		if (whackAMole.attemptsLeft == 0) {
			System.out.print("\nSorry, you lose. Score is " + whackAMole.score + "\nSolution: \n");
			whackAMole.printGrid();
		}

        keyboard.close();
	}

	WhackAMole(int numAttempts, int gridDimension) {
		this.attemptsLeft = numAttempts;
		this.moleGrid  = new char[gridDimension][gridDimension];
        // fill board with *
		for(int i = 0; i < gridDimension; i++) {
			Arrays.fill(moleGrid[i], '*');
		}
	}
		
	boolean place(int x, int y) {
		if (moleGrid[x][y] == '*') {
			moleGrid[x][y] = 'M';
			return true;
		} else {
			return false;
		}
	}

	void whack(int x, int y) {
		if (x < 1 || x > moleGrid.length || y < 1 || y > moleGrid.length) {
			System.out.print("Invalid coordinates, try again! \n");
		} else if (moleGrid[x-1][y-1] == 'M') {
			molesLeft--;
			score++;
			System.out.print("Mole Whacked! " + molesLeft + " moles left to find.\n");
			moleGrid[x-1][y-1] = 'W';
		} else {
			System.out.print("No mole here.\n");
		}
        attemptsLeft--;
		printGridToUser();
	}

	void printGridToUser() {
		for(int x = 0; x < moleGrid.length; x++) {
			for(int y = 0; y < moleGrid.length; y++) {
				if(moleGrid[x][y] == 'M') {
					System.out.print("*" + " ");
				} else {
					System.out.print(moleGrid[x][y] + " ");
				}
			}
			System.out.print(System.lineSeparator());
		}
	}

	void printGrid() {
		for(int x = 0; x < moleGrid.length; x++) {
			for(int y = 0; y < moleGrid.length; y++) {
				System.out.print(moleGrid[x][y] + " ");
			}
			System.out.print(System.lineSeparator());
		}
	}

}

