/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ce190770_v03;

import java.util.Scanner;

/**
 * V03 - Student marking program. Input validation utility class Contains
 * methods for validating user input
 *
 * @author Dinh Cong Phuc - CE190770 - 30/Jan/2025
 */
public class InputValidation {

    // Scanner object for reading user input
    static Scanner sc = new Scanner(System.in);

    /**
     * Gets and validates integer input from user
     *
     * @return valid integer input from user
     */
    public static int getIntInput() {
        // Loop until valid input is received
        while (true) {
            try {
                // Parse user input as integer
                int in = Integer.parseInt(sc.nextLine().trim());
                return in;
            } catch (Exception e) {
                // Display error message for invalid input
                System.out.print("Input is not a valid integer. Please try again: ");
            }
        }
    }

    /**
     * Gets and validates double input from user
     *
     * @return valid double input from user
     */
    public static double getDoubleInput() {
        // Loop until valid input is received
        while (true) {
            try {
                // Parse user input as double
                double in = Double.parseDouble(sc.nextLine().trim());
                return in;
            } catch (Exception e) {
                // Display error message for invalid input
                System.out.print("Input is not a valid double. Please try again: ");
            }
        }
    }

    /**
     * Validates integer input within specified range
     *
     * @param min Minimum allowed value
     * @param max Maximum allowed value
     * @return Valid integer within range
     */
    public static int intInputLimit(int min, int max) {
        // Loop until valid input is received
        while (true) {
            // Get integer input
            int in = getIntInput();
            // Check if input is within range
            if (in < min || in > max) {
                System.out.printf("Input must be between %d-%d.\n", min, max);
            } else {
                return in;
            }
        }
    }

    /**
     * Validates positive integer input
     *
     * @return Valid positive integer
     */
    public static int intInputUnsigned() {
        // Loop until valid input is received
        while (true) {
            // Get integer input
            int in = getIntInput();
            // Check if input is positive
            if (in < 0) {
                System.out.print("Input must be larger than 0, Please try again. ");
            } else {
                return in;
            }
        }
    }
}
