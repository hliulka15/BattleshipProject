import java.util.*;

public class Squarelotron {
    int[][] squarelotron;
    int size;

    public static void main(String[] args) {
        Squarelotron squarelotron = new Squarelotron(7);
        squarelotron =  squarelotron.mainDiagonalFlip(3);
        squarelotron.printSquarelotron();


    }

    Squarelotron(int n) {
        this.size = n;
        this.squarelotron = new int[size][size];

        int currentValue = 1;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                squarelotron[i][j] += currentValue;
                currentValue++;
            }
        }
    }

    void printSquarelotron(){
         //prints the squarelotron
         for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(squarelotron[i][j] + " ");
            }
            System.out.println();
        }
    }

    Squarelotron upsideDownFlip(int ring){
        Squarelotron flippedRing = new Squarelotron(size);
        int max = size - ring;
		int min = ring - 1;
        for (int i = 0; i < size; i++){
            for (int j = 0; j < size; j++){
                if(((i== min || i == max) && (j>= min && j <= max)) || ((j== min || j == max) && (i>= min && i <= max))){
                	flippedRing.squarelotron[i][j] = squarelotron[size - i - 1][j];
                }
                else{
                	flippedRing.squarelotron[i][j] = squarelotron[i][j];
                }
            }
        }
        return flippedRing;
    }

    Squarelotron mainDiagonalFlip(int ring) {
        Squarelotron flippedRing = new Squarelotron(this.size);
        int max = size - ring;
		int min = ring - 1;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (((i== min || i == max) && (j>= min && j <= max)) || ((j== min || j == max) && (i>= min && i <= max))) {
                	flippedRing.squarelotron[i][j] = squarelotron[j][i];
                }
                else {
                	flippedRing.squarelotron[i][j] = squarelotron[i][j];
                }
            }
        }
        return flippedRing;
    }

    void rotateRight(int numberOfTurns){
        for (int n = 0; n < Math.abs(numberOfTurns); n++) {
            Squarelotron rotatedRing = new Squarelotron(size);
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    rotatedRing.squarelotron[j][size - i - 1] = squarelotron[i][j];
                }
            }
            squarelotron = Arrays.copyOf(rotatedRing.squarelotron, rotatedRing.size);
        }
    }
};