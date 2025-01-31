/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ce190770_v03;

import java.util.HashMap;
import java.util.Scanner;

/**
 * S01 - Student marking program Class responsible for calculating and managing
 * student grades
 *
 * @author Dinh Cong Phuc - CE190770 - 30/Jan/2025
 */
public class GradeStudent {

    // Scanner object for reading user input
    Scanner sc = new Scanner(System.in);
    // Variable to track total weight of all components
    int totalWeight;
    // Variable to store weighted midterm score
    double weightedMidTermScore;
    // Variable to store weighted final exam score
    double weightedFinalExamScore;
    // Variable to store weighted homework score
    double weightedHomeworkScore;
    // Variable to store final grade
    double grade;
    // Variable to store minimum grade threshold
    double minGrade;

    /**
     * Main method to execute the grade calculation process
     */
    public void run() {
        // Display welcome message
        begin();
        // Print newline for formatting
        System.out.print("\n");
        // Process midterm grades
        midTerm();
        // Print newline for formatting
        System.out.print("\n");
        // Process final term grades
        finalTerm();
        // Print newline for formatting
        System.out.print("\n");
        // Process homework grades
        homework();
        // Print newline for formatting
        System.out.print("\n");
        // Generate and display final report
        report();
    }

    /**
     * Displays the initial welcome message
     */
    public void begin() {
        // Print welcome message
        System.out.println("This program reads exam/homework scores and reports your overall course grade");
    }

    /**
     * Handles midterm grade calculation
     */
    public void midTerm() {
        // Variable for midterm weight
        int weightMidTerm;
        // Variable for raw score
        int score;
        // Variable for score shift selection
        int scoreShiftSelection;

        // Print section header
        System.out.println("Midterm:");

        // Get weight input from user
        System.out.print("Weight (0-100)? ");
        weightMidTerm = addWeight(InputValidation.intInputLimit(0, 100));

        // Get score input from user
        System.out.print("Score earned? ");
        score = inputScore(100);

        // Ask if scores should be shifted
        System.out.print("Were score shifted (1=yes, 2=no)? ");
        scoreShiftSelection = InputValidation.intInputLimit(1, 2);

        // Handle score shifting based on user selection
        switch (scoreShiftSelection) {
            case 1:
                // Get shift amount
                System.out.print("Shift amount? ");
                // Get positive shift value
                int shift = InputValidation.intInputUnsigned();
                // Apply shift while ensuring score doesn't exceed 100
                if (score + shift > 100) {
                    score = 100;
                } else {
                    score += shift;
                }
                break;
            case 2:
                break;
        }

        // Calculate weighted score
        weightedMidTermScore = ((double) score / 100) * weightMidTerm;
        // Display total points
        System.out.printf("Total points = %d / 100\n", score);
        // Display weighted score
        System.out.printf("Weighted score = %.1f / %d\n", weightedMidTermScore, weightMidTerm);
    }

    /**
     * Handles final exam grade calculation
     */
    public void finalTerm() {
        // Variable for final term weight
        int weightFinalTerm;
        // Variable for raw score
        int score;
        // Variable for score shift selection
        int scoreShiftSelection;

        // Print section header
        System.out.println("Final: ");

        // Get weight input from user
        System.out.print("Weight (0-100)? ");
        weightFinalTerm = addWeight(InputValidation.intInputLimit(0, 100));

        // Get score input from user
        System.out.print("Score earned? ");
        score = inputScore(100);

        // Ask if scores should be shifted
        System.out.print("Were score shifted (1=yes, 2=no)? ");
        scoreShiftSelection = InputValidation.intInputLimit(1, 2);

        // Handle score shifting based on user selection
        switch (scoreShiftSelection) {
            case 1:
                // Get shift amount
                System.out.print("Shift amount? ");
                // Get positive shift value
                int shift = InputValidation.intInputUnsigned();
                // Apply shift while ensuring score doesn't exceed 100
                if (score + shift > 100) {
                    score = 100;
                } else {
                    score += shift;
                }
                break;
            case 2:
                break;
        }

        // Calculate weighted score
        weightedFinalExamScore = ((double) score / 100) * weightFinalTerm;
        // Display total points
        System.out.printf("Total points = %d / 100\n", score);
        // Display weighted score
        System.out.printf("Weighted score = %.1f / %d\n", weightedFinalExamScore, weightFinalTerm);
    }

    /**
     * Handles homework grade calculation
     */
    public void homework() {
        // Variable for homework weight
        int weightHomework;
        // Number of assignments
        int assignments;
        // Number of sections attended
        int sections;
        // Points earned from section attendance
        int sectionsPoints;
        // Total score earned
        int score = 0;
        // Maximum possible score
        int totalScore = 0;
        // HashMap to store assignment scores and their maximum values
        HashMap<String, int[]> assignmentScore = new HashMap<>();

        // Print section header
        System.out.println("Homework: ");
        // Get homework weight
        System.out.print("Weight (0-100)? ");
        weightHomework = addWeight(InputValidation.intInputLimit(0, 100));

        // Get number of assignments
        System.out.print("Number of assignments? ");
        assignments = InputValidation.intInputUnsigned();

        // Loop through each assignment to get scores
        for (int i = 0; i < assignments; i++) {
            while (true) {
                // Get assignment score and maximum
                System.out.printf("Assignment %d score and max? ", i + 1);
                String input = sc.nextLine();
                // Split input into score and max
                String[] numbers = input.trim().split(" +");
                try {
                    // Validate input format
                    if (numbers.length != 2) {
                        throw new Exception("Please input only 2 elements: Score & Max");
                    } else {
                        // Parse score and max values
                        int asmScore = Integer.parseInt(numbers[0]);
                        int max = Integer.parseInt(numbers[1]);
                        if (max < 0) {
                            throw new Exception("Max score must be between 0 and 150");
                        } else if (max > 150) {
                            System.out.println("Max score exceed 150, automatically adjusted to 150.");
                            max = 150;
                        }
                        // Validate score range
                        if (asmScore < 0 || asmScore > max) {
                            throw new Exception("Score must be between 0 and 150");
                        }
                        // Store assignment score
                        assignmentScore.put("asm" + (i + 1), new int[]{asmScore, max});
                        break; // Exit the while loop if input is valid
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Please enter valid numbers, try again.");
                } catch (Exception e) {
                    System.out.println(e.getMessage() + ", Please try again.");
                }
            }
        }

        // Get section attendance
        System.out.printf("How many sections did you attend? ");
        sections = InputValidation.intInputUnsigned();
        // Validate and adjust section attendance
        if (sections > 30) {
            System.out.println("Attendance exceed 30, automatically adjusted attend to 30.");
            sections = 30;
        }

        // Calculate total score from assignments
        for (int[] iScore : assignmentScore.values()) {
            score += iScore[0];
            totalScore += iScore[1];
        }

        // Calculate section points
        sectionsPoints = sections * 5;
        // Add section points to total score
        score += sectionsPoints;
        totalScore += 30;
        // Calculate weighted homework score
        weightedHomeworkScore = ((double) score / totalScore) * weightHomework;
        // Display section points
        System.out.printf("Section points = %d / 30\n", sectionsPoints);
        // Display total points
        System.out.printf("Total points = %d / %d\n", score, totalScore);
        // Display weighted score
        System.out.printf("Weighted score = %.1f / %d\n", weightedHomeworkScore, weightHomework);
    }

    /**
     * Generates and displays final grade report
     */
    public void report() {
        // Calculate final grade
        grade = Math.round(weightedMidTermScore + weightedFinalExamScore + weightedHomeworkScore);
        // Determine minimum grade based on total score
        if (grade < 60) {
            minGrade = 0.0;
        } else if (grade >= 60 && grade < 75) {
            minGrade = 0.7;
        } else if (grade >= 75 && grade < 85) {
            minGrade = 2.0;
        } else {
            minGrade = 3.0;
        }

        // Display final percentage
        System.out.printf("Overall percentage = %.1f\n", grade);
        // Display minimum grade
        System.out.printf("Your grade will be at least: %.1f\n", minGrade);
    }

    /**
     * Validates and adds weight while ensuring total doesn't exceed 100
     *
     * @param weight Weight to be added
     * @return Adjusted weight value
     */
    public int addWeight(int weight) {
        // Check if total weight is already at maximum
        if (totalWeight >= 100) {
            System.out.println("Total weight already equal 100, exceeding not allowed, automatically set this weight to 0");
            return 0;
        } else {
            // Calculate new total
            int total = totalWeight + weight;
            // Adjust if total would exceed 100
            if (total > 100) {
                System.out.printf("Total weight exceed allowed limit, automatically adjusted so total weight equal 100\n");
                weight = 100 - totalWeight;
                totalWeight = 100;
                return weight;
            } else {
                // Add weight if within limits
                totalWeight += weight;
                return weight;
            }
        }
    }

    /**
     * Validates score input within specified maximum
     *
     * @param max Maximum allowed score
     * @return Validated score
     */
    public int inputScore(int max) {
        while (true) {
            // Get score input
            int score = InputValidation.intInputLimit(0, max);
            // Validate score range
            if (score < 0 || score > max) {
                System.out.printf("Score must be between 0-%d\n", max);
            } else {
                return score;
            }
        }
    }
}
