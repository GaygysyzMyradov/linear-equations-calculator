package com.company;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.print("Input the Number of Equations m: ");
        int m = input.nextInt();

        System.out.print("Input the Number of Unknowns n: ");
        int n = input.nextInt();

        //Checking if the given dimensions are for Square Matrix, if not then Print a Message
        if (m == n){
            int[][] matrixA = new int[m][n];
            getMatrixA(matrixA);

            int[] vectorB = new int[m];
            getVectorb(vectorB);

            double[] vectorX = new double[n];
            setVectorX(vectorX);

            System.out.println("\nThe Given Matrix:\n");
            printMatrix(matrixA, vectorB);

            boolean[] visited = new boolean[m];
            Arrays.fill(visited, true);

            //If the given Matrix is Diagonally Dominant, then we Proceed with finding X's
            //If we get False in return, then we proceed with Making the Matrix Diagonally Dominant
            if (checkDiagonalDominance(matrixA, visited)) {
                System.out.println("The Matrix is Diagonally Dominant\n");

                findUnknownX(matrixA, vectorX, vectorB);

                for (int i = 0; i < vectorX.length; i++) {
                    System.out.println("X" + (i+1) + " = " + vectorX[i]);
                }
            }
            else {
                System.out.println("The Matrix is Not Diagonally Dominant\n");

                //If it is possible to make Diagonally Dominant matrix, then we proceed with finding X's
                //If we get False in return, then we Print a Message.
                if (makeDiagonallyDominant(matrixA, vectorB, visited)){
                    findUnknownX(matrixA, vectorX, vectorB);

                    for (int i = 0; i < vectorX.length; i++) {
                        System.out.println("X" + (i+1) + " = " + vectorX[i]);
                    }
                }
                else
                    System.out.println("The Matrix CAN NOT be Made Diagonally Dominant");
            }
        }
        else {
            System.out.println("\nNumber of Equations and Unknowns Should be the Same,");
            System.out.println("Please Try Again!");
        }
    }

    //Getting the elements of Matrix A
    static void getMatrixA(int[][] matrixA){
        System.out.println("\nInput the Matrix A: ");
        for (int i = 0; i < matrixA.length; i++) {
            for (int j = 0; j < matrixA[0].length; j++) {
               matrixA[i][j] = input.nextInt();
            }
        }
    }

    //Getting the elements of Vector B
    static void getVectorb(int[] vectorB){
        System.out.println("\nInput the Vector B: ");

        for (int i = 0; i < vectorB.length; i++)
            vectorB[i]= input.nextInt();
    }

    //Setting the elements of Vector X to 0 so that it will be ready for first Iteration for finding X's
    static void setVectorX(double[]vectorX){
       Arrays.fill(vectorX, 0);
    }

    //Method to Print a Passed Matrix and Vector B
    static void printMatrix(int[][] matrixA, int[] vectorB){
        for (int i = 0; i < matrixA.length; i++) {
            for (int j = 0; j < matrixA[0].length; j++)
                System.out.print(matrixA[i][j] + " ");

            System.out.print(" X" + (i+1) + "  " + (vectorB[i]));
            System.out.println();
        }
        System.out.println();
    }

    //Method to check Diagonal Dominance
    static boolean checkDiagonalDominance(int[][]matrix, boolean[] visited){

        int sum; boolean check = true;
        for (int i = 0; i < matrix.length; i++) {
            sum = 0;
            for (int j = 0; j < matrix[0].length; j++) {
                if (i != j)
                    sum += Math.abs(matrix[i][j]);
            }
            if (sum > Math.abs(matrix[i][i])) {
                visited[i] = false;
                check = false;
            }
        }
        return check;
    }

    //Method to check if it is possible to make the Matrix Diagonally Dominant or Not
    //The algorithm used here is basically trying all the possibilities,
    //which means, Lets say we have 4x4 Matrix A and it has 3 rows which are not Diagonally Dominant.
    //So, algorithm will try out all the permutations to create New Matrix and
    //check if any of them make the whole Matrix Diagonally Dominant.
    //This algorithm might not be the most Efficient one but,
    //It will Definitely decide if it is Possible to make the given Matrix Diagonally Dominant or Not.
    static boolean makeDiagonallyDominant(int[][] matrixA, int[] vectorB, boolean[] visited){

        int[] permutation = new int[matrixA[0].length+1];
        int index, n = permutation.length-1;
        boolean decision;

        //Initializing the permutation array so that it will eliminate the obvious non answer ones
        //Example with 4x4 Matrix: Instead of starting from 0 0 0 0, it will start from 3 2 1 0. These numbers are indexes of Rows.
        //If 3 is in the 0th index of Permutation array, then that means, 3rd Index row has to be put to the 0th index row of Matrix A.
        for (int i = 0; i < n; i++)
            permutation[i] = n-i-1;


        do {
            decision = true;

            //FOR loop to find out if all the elements of permutation array is Unique or Not.
            //If the permutation is Unique, then it will proceed with next checking point before creating New Matrix.
            //If it is not Unique, then it will just break and proceed to the next Permutation.
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (permutation[i] == permutation[j]) {
                        decision = false;
                        break;
                    }
                }
            }

            //Another condition before proceeding to creating new matrix,
            //we need to make sure that the Permutation is not changing any already Dominant rows.
            //That's why we are using Visited Array which has the Labels for each row.
            //If let's say 2nd Row is the only Dominant row in the Matrix A. Then Visited[2] is True.
            //So for the 3x3 matrix, We have only 2 permutations left. First: 0 1 2 and 1 0 2.
            //It is 2 permutations because the row 2 has to be intact.
            //So Index 2 element of Permutation array should always be 2 and for that we are using the following FOR loop.
            if (decision)
                for (int i = 0; i < n; i++) {
                    if (visited[i] && permutation[i] != i) {
                        decision = false;
                        break;
                    }
                }



            //Once we check all the conditions above, and if we still get True,
            //then we can proceed with creating a New Matrix based on to the Permutation we got.

            //If we get True as a return from createNewMatrix, then we stop all the loops and the method,
            //as we already got 1 answer that makes the Whole Matrix Diagonally Dominant.
            //If that happens, then we return True to continue with finding the X's.

            //If we get False from createNewMatrix method in return, we try and pass another Permutation.
            //At the end of trying and passing all Permutations and if we still did not get a True,
            //then we return False, indicating it is not possible to Make the Matrix Diagonally Dominant
            if (decision && createNewMatrix(matrixA, vectorB, visited, permutation)) {
                return true;
            }

            //The following loop is used to generate new Permutations.
            //Ex: If the current permutation is 3 2 1 0 then it will make it 0 3 1 0, after that 1 3 1 0 and so on.
            index = 0;
            while (permutation[index] == n-1){
                index++;
                permutation[index-1] = 0;
            }
            permutation[index]++;
        }while (index < n);
        return false;
    }

    //Method to Create a New Matrix according to the Passed Permutation
    static boolean createNewMatrix(int[][]matrixA, int[] vectorB, boolean[] visited, int[] permutation){

        //Using Two Back Up array so that we don't mess with our original Matrix A.
        int[][] tempMatrix = new int[matrixA.length][matrixA[0].length];
        int[][] newMatrix = new int[matrixA.length][matrixA[0].length];

        //Using Two Back Up array so that we don't mess with our original Vector B.
        int[] tempVector = new int[vectorB.length];
        int[] newVector = new int[vectorB.length];

        //Copying Matrix A to Matrix tempMatrix and newMatrix.
        //Copying Vector B to Array tempVector and newVector.
        for (int i = 0; i < matrixA.length; i++) {
            for (int j = 0; j < matrixA[0].length; j++) {
                tempMatrix[i][j] = matrixA[i][j];
                newMatrix[i][j] = matrixA[i][j];
            }
            tempVector[i] = vectorB[i];
            newVector[i] = vectorB[i];
        }

        //Using for loop to create a new Matrix and new Vector according to the passed Permutation
        for (int i = 0; i < matrixA[0].length; i++) {
            if (!visited[i] && permutation[i] != i) {
                for (int j = 0; j < matrixA.length; j++) {
                    newMatrix[i][j] = tempMatrix[permutation[i]][j];
                }
                newVector[i] = tempVector[permutation[i]];
            }
        }

        //Once we pass the newly created newMatrix to CheckDiagonalDominance and if we get True as a Return,
        //then we assign our new Matrix to our Original matrixA then pass it to print
        //and Update the user that the matrix is made Diagonally Dominant.
        //After printing, we return True to the makeDiagonallyDominant method to proceed with finding the X's

        //Current Method will always return False until the we get True from checkDiagonalDominance method in return.
        if (checkDiagonalDominance(newMatrix, visited)){
            System.out.println("The Newly Made Diagonally Dominant Matrix: ");
            for (int i = 0; i < newMatrix.length; i++) {
                for (int j = 0; j < newMatrix[0].length; j++) {
                    matrixA[i][j] = newMatrix[i][j];
                }
                vectorB[i] = newVector[i];
            }
            printMatrix(matrixA, vectorB);
            return true;
        }
        return false;
    }

    //Method to find Unknown X's
    static void findUnknownX(int[][]matrixA, double[]vectorX, int[]vectorB){
        double epsilon = 0.005, error;

        double[] tempArray = new double[vectorX.length];
        Double[] tempArrayMax = new Double[vectorX.length];
        Double tempMax, vectorXMax = 0.0;

        while(true) {
            Arrays.fill(tempArray, 0);

            //Finding Xr and Storing them in an Array called tempArray
            for (int i = 0; i < vectorX.length; i++) {
                for (int j = 0; j < matrixA[0].length; j++) {
                    if (i != j)
                        tempArray[i] -= (matrixA[i][j] * vectorX[j]);
                }
                tempArray[i] = (vectorB[i] + tempArray[i]) / matrixA[i][i];

                //Rounding the values of tempArray to 3 Decimal Places
                tempArray[i] = Math.round(tempArray[i] * 1000);
                tempArray[i] = tempArray[i] / 1000;
            }

            //Finding the Greatest Absolute Value of tempArray elements.
            for (int i = 0; i < tempArray.length; i++)
                tempArrayMax[i] = Math.abs(tempArray[i]);

            //Using 'max' Method of Collections class which accepts the Object of Double class
            //tempMax is used to store the Largest Absolute Value X of the Current Iteration
            tempMax = Collections.max(Arrays.asList(tempArrayMax));

            //Finding Error for the current Iteration
            error = Math.abs(tempMax - vectorXMax);

            //Comparing the found Error and deciding to Break the Loop or Continue the Loop
            if (error <= epsilon) {
                for (int i = 0; i < vectorX.length; i++) {
                    vectorX[i] = tempArray[i];
                }
                break;
            }
            else {
                //Assigning tempArray to vectorX,
                //so that we can use vectorX in the next iteration to compare as X(k-1)
                for (int i = 0; i < vectorX.length; i++)
                    vectorX[i] = tempArray[i];

                vectorXMax = tempMax;
            }
        }
   }
}

