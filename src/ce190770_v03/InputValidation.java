/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ce190770_v03;

import java.util.Scanner;

/**
 * S01 - Program to insert new elements into an existing array. Input validation
 * utility class Contains methods for validating user input
 *
 * @author Dinh Cong Phuc - CE190770 - 15/Jan/2025
 */
public class InputValidation {

    // Scanner object for reading user input
    static Scanner sc = new Scanner(System.in);

    /**
     * Gets and validates integer input from user Continues to prompt until
     * valid integer is entered
     *
     * @return valid integer input from user
     */
    public static int getIntInput() {
        // Loop until valid double is entered
        while (true) {
            try {
                // Read and parse user input, removing whitespace
                int in = Integer.parseInt(sc.nextLine().trim());
                return in;
                // If exception occur, handles in catch block.
            } catch (Exception e) {
                // Prompt user to retry on invalid input
                System.out.print("Input is not a valid integer. Please try again: ");
            }
        }
    }

    public static double getDoubleInput() {
        // Loop until valid double is entered
        while (true) {
            try {
                // Read and parse user input, removing whitespace
                double in = Double.parseDouble(sc.nextLine().trim());
                return in;
                // If exception occur, handles in catch block.
            } catch (Exception e) {
                // Prompt user to retry on invalid input
                System.out.print("Input is not a valid double. Please try again: ");
            }
        }
    }

    public static int intInputLimit(int min, int max) {
        while (true) {
            int in = getIntInput();
            if (in < min || in > max) {
                System.out.printf("Input must be between %d-%d.\n", min, max);
            } else {
                return in;
            }
        }
    }
    
    public static int intInputUnsigned(){
        while(true){
            int in = getIntInput();
            if(in <= 0){
                System.out.println("Input must be larger than 0.");
            } else {
                return in;
            }
        }
    }
}
