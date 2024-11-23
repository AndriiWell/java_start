package msjava2lesson;

import msjava2lesson.moveZeroes.Solution;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        taskMoveZeros();
    }

    private static void taskMoveZeros() {
        Solution solution = new Solution();

        int[] aNumInputA = {0,1,0,3,12};
        System.out.println("aNumInputA");
        System.out.println(Arrays.toString(aNumInputA));

        int[] aNumOutput = solution.moveZeroes(aNumInputA);
        System.out.println("aNumOutput");
        System.out.println(Arrays.toString(aNumOutput));
        System.out.println("\n");


        int[] aNumInputB = {0};
        System.out.println("aNumInputB");
        System.out.println(Arrays.toString(aNumInputB));

        aNumOutput = solution.moveZeroes(aNumInputB);
        System.out.println("aNumOutput");
        System.out.println(Arrays.toString(aNumOutput));
        System.out.println("\n");


        int[] aNumInputC = {0,0,1,0,0,0,9,9,0,0,0,0,0,6};
        System.out.println("aNumInputC");
        System.out.println(Arrays.toString(aNumInputC));

        aNumOutput = solution.moveZeroes(aNumInputC);
        System.out.println("aNumOutput");
        System.out.println(Arrays.toString(aNumOutput));
        System.out.println("\n");


        int[] aNumInputD = {3,0};
        System.out.println("aNumInputD");
        System.out.println(Arrays.toString(aNumInputD));

        aNumOutput = solution.moveZeroes(aNumInputD);
        System.out.println("aNumOutput");
        System.out.println(Arrays.toString(aNumOutput));
        System.out.println("\n");


        int[] aNumInputE= {3,0,0,0,0,0,0};
        System.out.println("aNumInputE");
        System.out.println(Arrays.toString(aNumInputE));

        aNumOutput = solution.moveZeroes(aNumInputE);
        System.out.println("aNumOutput");
        System.out.println(Arrays.toString(aNumOutput));
        System.out.println("\n");


        int[] aNumInputF = {3,4,5,6,7,9,0};
        System.out.println("aNumInputF");
        System.out.println(Arrays.toString(aNumInputF));

        aNumOutput = solution.moveZeroes(aNumInputF);
        System.out.println("aNumOutput");
        System.out.println(Arrays.toString(aNumOutput));
        System.out.println("\n");


        int[] aNumInputG = {0,0,0,0,0,0,1};
        System.out.println("aNumInputG");
        System.out.println(Arrays.toString(aNumInputG));

        aNumOutput = solution.moveZeroes(aNumInputG);
        System.out.println("aNumOutput");
        System.out.println(Arrays.toString(aNumOutput));
        System.out.println("\n");


        int[] aNumInputH = {1,0,0,0,0,0,1};
        System.out.println("aNumInputH");
        System.out.println(Arrays.toString(aNumInputH));

        aNumOutput = solution.moveZeroes(aNumInputH);
        System.out.println("aNumOutput");
        System.out.println(Arrays.toString(aNumOutput));

        int[] aNumInputExcept = {};
        solution.moveZeroes(aNumInputExcept);
    }
}
