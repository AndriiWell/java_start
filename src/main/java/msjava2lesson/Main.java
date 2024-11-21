package msjava2lesson;

import msjava2lesson.moveZeroes.Solution;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        Solution solution = new Solution();

        int[] a_num_input_a = {0,1,0,3,12};
        System.out.println("a_num_input A");
        System.out.println(Arrays.toString(a_num_input_a));

        int[] a_num_output = solution.moveZeroes(a_num_input_a);
        System.out.println("a_num_output");
        System.out.println(Arrays.toString(a_num_output));
        System.out.println("\n");


        int[] a_num_input_b = {0};
        System.out.println("a_num_input B");
        System.out.println(Arrays.toString(a_num_input_b));

        a_num_output = solution.moveZeroes(a_num_input_b);
        System.out.println("a_num_output");
        System.out.println(Arrays.toString(a_num_output));
        System.out.println("\n");


        int[] a_num_input_c = {0,0,1,0,0,0,9,9,0,0,0,0,0,6};
        System.out.println("a_num_input C");
        System.out.println(Arrays.toString(a_num_input_c));

        a_num_output = solution.moveZeroes(a_num_input_c);
        System.out.println("a_num_output");
        System.out.println(Arrays.toString(a_num_output));
        System.out.println("\n");


        int[] a_num_input_d = {3,0};
        System.out.println("a_num_input D");
        System.out.println(Arrays.toString(a_num_input_d));

        a_num_output = solution.moveZeroes(a_num_input_d);
        System.out.println("a_num_output");
        System.out.println(Arrays.toString(a_num_output));
        System.out.println("\n");


        int[] a_num_input_e= {3,0,0,0,0,0,0};
        System.out.println("a_num_input E");
        System.out.println(Arrays.toString(a_num_input_e));

        a_num_output = solution.moveZeroes(a_num_input_e);
        System.out.println("a_num_output");
        System.out.println(Arrays.toString(a_num_output));
        System.out.println("\n");


        int[] a_num_input_f = {3,4,5,6,7,9,0};
        System.out.println("a_num_input E");
        System.out.println(Arrays.toString(a_num_input_f));

        a_num_output = solution.moveZeroes(a_num_input_f);
        System.out.println("a_num_output");
        System.out.println(Arrays.toString(a_num_output));
        System.out.println("\n");


        int[] a_num_input_g = {0,0,0,0,0,0,1};
        System.out.println("a_num_input G");
        System.out.println(Arrays.toString(a_num_input_g));

        a_num_output = solution.moveZeroes(a_num_input_g);
        System.out.println("a_num_output");
        System.out.println(Arrays.toString(a_num_output));
        System.out.println("\n");


        int[] a_num_input_h = {1,0,0,0,0,0,1};
        System.out.println("a_num_input G");
        System.out.println(Arrays.toString(a_num_input_h));

        a_num_output = solution.moveZeroes(a_num_input_h);
        System.out.println("a_num_output");
        System.out.println(Arrays.toString(a_num_output));

        int[] a_num_input_except = {};
        solution.moveZeroes(a_num_input_except);
    }
}
