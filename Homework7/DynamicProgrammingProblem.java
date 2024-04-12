// Jake Reeder
// CS 318 Homework 7

package Homework7;

public class DynamicProgrammingProblem {
    
    // Solution to the String Transformation Problem
    // Finding the most operations (insert, replace, delete) needed to 
    // transform one string into another.
    public static int[][] StringTransformation(String string1, String string2) {
        // initialize Memoize table
        int[][] solutionMatrix = new int[string1.length()+1][string2.length()+1];

        //fill out base cases of table
        for (int i = 0; i < string2.length()+1; i++) {
            solutionMatrix[0][i] = i;
        }
        for (int i = 1; i < string1.length()+1; i++) {
            solutionMatrix[i][0] = i;
        }

        //fill out the rest of table
        for (int i = 1; i < string1.length()+1; i++) {
            for (int j = 1; j < string2.length()+1; j++) {
                //Check to see of characters are the same
                if (string1.charAt(i-1) == string2.charAt(j-1)) {
                    solutionMatrix[i][j] = solutionMatrix[i-1][j-1];
                }
                else {
                    // finding minimum of three surounding values.
                    int min = Math.min(solutionMatrix[i][j-1], solutionMatrix[i-1][j-1]);
                    min = Math.min(min, solutionMatrix[i-1][j]);
                    solutionMatrix[i][j] = min+1;
                }
            }
        }

        return solutionMatrix;
    }

    public static void print2D(int mat[][])
    {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    //Test Code
    public static void main(String args[]) {
        
        int[][] solution = StringTransformation("Goober", "Goofy");
        print2D(solution);
        
    }
}
