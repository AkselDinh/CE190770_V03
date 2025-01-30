/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ce190770_v03;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author Dinh Cong Phuc - CE190770
 */
public class GradeStudent {
    Scanner sc = new Scanner(System.in);
    int totalWeight;
    double weightedMidTermScore;
    double weightedFinalExamScore;
    double weightedHomeworkScore;
    double grade;
    
    
    public void run(){
        begin();
        System.out.print("\n");
        midTerm();
        System.out.print("\n");
        finalTerm();
        System.out.print("\n");
        homework();
        System.out.print("\n");
        report();
    }
    
    public void begin(){
        System.out.println("This program reads exam/homework scores and reports your overall course grade");
    }
    
    public void midTerm(){
        int weightMidTerm;
        int score;
        int scoreShiftSelection;
        
        System.out.println("Midterm:");
        
        System.out.print("Weight (0-100)? ");
        weightMidTerm = addWeight(InputValidation.intInputLimit(0, 100));
        
        System.out.print("Score earned? ");
        score = inputScore(100);
        
        System.out.print("Were score shifted (1=yes, 2=no)? ");
        scoreShiftSelection = InputValidation.intInputLimit(1, 2);

        switch (scoreShiftSelection) {
            case 1:
                System.out.print("Shift amount? ");

                int shift = InputValidation.intInputUnsigned();
                if (score + shift > 100) {
                    score = 100;
                } else {
                    score += shift;
                }
                break;
            case 2:
                break;
        }
        
        weightedMidTermScore = ((double)score/100) * weightMidTerm;
        System.out.printf("Total points = %d / 100\n", score);
        System.out.printf("Weighted score = %.1f / %d\n", weightedMidTermScore, weightMidTerm);
    }
    
    public void finalTerm(){
        int weightFinalTerm;
        int score;
        int scoreShiftSelection;
        
        System.out.println("Midterm:");
        
        System.out.print("Weight (0-100)? ");
        weightFinalTerm = addWeight(InputValidation.intInputLimit(0, 100));
        
        System.out.print("Score earned? ");
        score = inputScore(100);
        
        System.out.print("Were score shifted (1=yes, 2=no)? ");
        scoreShiftSelection = InputValidation.intInputLimit(1, 2);

        switch (scoreShiftSelection) {
            case 1:
                System.out.print("Shift amount? ");

                int shift = InputValidation.intInputUnsigned();
                if (score + shift > 100) {
                    score = 100;
                } else {
                    score += shift;
                }
                break;
            case 2:
                break;
        }
        
        weightedFinalExamScore = ((double)score/100) * weightFinalTerm;
        System.out.printf("Total points = %d / 100\n", score);
        System.out.printf("Weighted score = %.1f / %d\n", weightedFinalExamScore, weightFinalTerm);
    }
    
    public void homework(){
        int weightHomework;
        int assignments;
        int sections;
        int sectionsPoints;
        int score;
        HashMap<String, int[]> assignmentScore = new HashMap<>();
        
        System.out.println("Homework: ");
        System.out.print("Weight (0-100)? ");
        weightHomework = addWeight(InputValidation.intInputLimit(0, 100));
        
        System.out.print("Number of assignments? ");
        assignments = InputValidation.intInputUnsigned();
        
        for(int i = 0; i < assignments; i++){
            System.out.printf("Assignment %d score and max? ",i+1);
            ArrayList<String> arl = new ArrayList<>();
            String input = sc.nextLine();
            
        }
    }
    
    public void report(){
        
    }
    
    public int addWeight(int weight){
        if (totalWeight >= 100) {
            System.out.println("Total weight already equal 100, exceeding not allowed, automatically set this weight to 0");
            return 0;
        } else {
            int total = totalWeight + weight;
            if (total > 100) {
                System.out.printf("Total weight exceed allowed limit, automatically set total weight to 100\n");
                totalWeight = 100;
                return 0;
            } else {
                totalWeight += weight;
                return weight;
            }
        }
    }
    
    public int inputScore(int max){
        while(true){
            int score = InputValidation.intInputLimit(0, max);
            if(score < 0 || score > max){
                System.out.printf("Score must be between 0-%d\n", max);
            } else {
                return score;
            }
        }
    }
}
