package hello;
import java.util.Scanner;

import java.util.*;

public class isPrime {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a positive integer: ");

        int userInput = scanner.nextInt();

        System.out.println("User entered " + userInput);

        int factor = 2;

        while (userInput % factor != 0) {
            factor++;
        }
        if (factor == userInput){
            System.out.println(userInput + " is prime");
        } else {
            System.out.println(userInput + " is not prime. Factor is " + factor);
        }
        

    }
}
