/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ce190770_v03;

/**
 * S01 - Student marking program
 * Main class that serves as the entry point for the grade calculation program
 *
 * @author Dinh Cong Phuc - CE190770 - 30/Jan/2025
 */
public class CE190770_V03 {

    /**
     * Main method that initializes and runs the grade calculation program
     *
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        // Create a new instance of GradeStudent class
        GradeStudent grdStd = new GradeStudent();
        // Call the run method to start the program
        grdStd.run();
    }

}
