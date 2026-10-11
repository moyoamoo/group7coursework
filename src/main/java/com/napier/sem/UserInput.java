package com.napier.sem;
import java.util.Scanner;

public class UserInput {

    private static final Scanner scan = new Scanner(System.in);

    /** Get a valid user integer within range
     * @param prompt User prompt
     * @param min Minimum value that user can enter
     * @param max Minimum value that user can enter
     * @return userValue Validated user input
     *
     */
    public int getUserInt(String prompt, int min, int max) {

        boolean validInput = false;
        int userValue = 0;

        // While user input is invalid
        while (!validInput) {
            // Print user prompt
            System.out.print(prompt);
            // If no input, throw exception
            if (!scan.hasNextLine()) {
                throw new IllegalStateException("No input available");
            }

            // Get user input
            String input = scan.nextLine().trim();
            try {
                userValue = Integer.parseInt(input);
                // See if user input is in range of expected values
                if ((userValue < min) || (userValue > max)) {
                    System.out.println("Please enter a number between " + min + " and " + max + ".");
                } else {
                    validInput = true;
                }

            } catch (NumberFormatException e) {
                System.out.println("'" + input + "' is not a valid number.");
            }
        }
        return userValue;
    }
}
