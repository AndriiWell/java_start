package msjava2lesson;

import msjava2lesson.moveZeroes.Solution;
import msjava2lesson.reverselinkedlist.ListNode;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        taskReverseLinkedList();
        taskMoveZeros();
    }

    private static void linkedListPrint(ListNode node) {
        if (node != null) {
            System.out.print("Head:");
        }

        while (node != null) {
            System.out.print(node.val + " -> ");
            node = node.next;
        }
        System.out.println("No pointer, the end...");
    }

    /**
     * https://leetcode.com/problems/reverse-linked-list/description/
     */
    private static void taskReverseLinkedList() {
        firstWayToFillLinkedListAndReverse();
        secondWayToFillLinkedListAndReverse();
        thirdWayToFillLinkedListAndReverse();
        forthWayToFillLinkedListAndReverse();
        oneElementInLinkedListAndReverse();
        zeroElementInLinkedListAndReverse();

        // Questions
        String[] s = new String[]{"sasd"};
        String[] ss = {"asd"}; // is present the difference between two of them?
    }

    private static void zeroElementInLinkedListAndReverse() {
        ListNode nodeOneElement = null;

        // Show original list.
        System.out.println("iteratively");
        System.out.print("Origin:   ");
        linkedListPrint(nodeOneElement);

        // Reverse
        msjava2lesson.reverselinkedlist.Solution reverseSolution = new msjava2lesson.reverselinkedlist.Solution();
        ListNode reversedList = reverseSolution.reverseList(nodeOneElement);
        System.out.print("Reversed: ");
        linkedListPrint(reversedList);

        // Recursively reverse.
        nodeOneElement = null;

        // Show original list.
        System.out.println("iteratively");
        System.out.print("Origin:   ");
        linkedListPrint(nodeOneElement);

        // Recursively reverse.
        reverseSolution = new msjava2lesson.reverselinkedlist.Solution();
        reversedList = reverseSolution.reverseListRecursively(nodeOneElement);
        System.out.print("Reversed: ");
        linkedListPrint(reversedList);
        System.out.println("\n");
    }

    private static void oneElementInLinkedListAndReverse() {
        ListNode nodeOneElement = new ListNode(1);

        // Show original list.
        System.out.println("iteratively");
        System.out.print("Origin:   ");
        linkedListPrint(nodeOneElement);

        // Reverse
        msjava2lesson.reverselinkedlist.Solution reverseSolution = new msjava2lesson.reverselinkedlist.Solution();
        ListNode reversedList = reverseSolution.reverseList(nodeOneElement);
        System.out.print("Reversed: ");
        linkedListPrint(reversedList);

        // Recursively reverse.
        nodeOneElement = new ListNode(1);

        // Show original list.
        System.out.println("iteratively");
        System.out.print("Origin:   ");
        linkedListPrint(nodeOneElement);

        // Recursively reverse.
        reverseSolution = new msjava2lesson.reverselinkedlist.Solution();
        reversedList = reverseSolution.reverseListRecursively(nodeOneElement);
        System.out.print("Reversed: ");
        linkedListPrint(reversedList);
        System.out.println("\n");
    }

    private static void forthWayToFillLinkedListAndReverse() {
        // Iteratively reverse.
        int[] arrayForLinkedList = new int[]{10,100,1000,4000,5000};
        ListNode headArray;
        ListNode nodeArray = null; // Leave of the list.
        for(int i = arrayForLinkedList.length-1; i >= 0; i--){
            nodeArray = new ListNode(arrayForLinkedList[i], nodeArray);
        }
        headArray = nodeArray;

        // Show original list.
        System.out.println("iteratively");
        System.out.print("Origin:   ");
        linkedListPrint(headArray);

        // Reverse
        msjava2lesson.reverselinkedlist.Solution reverseSolution = new msjava2lesson.reverselinkedlist.Solution();
        ListNode reversedList = reverseSolution.reverseList(headArray);
        System.out.print("Reversed: ");
        linkedListPrint(reversedList);

        // Recursively reverse.
        arrayForLinkedList = new int[]{10,100,1000,4000,5000};
        nodeArray = null; // Leave of the list.
        for(int i = arrayForLinkedList.length-1; i >= 0; i--){
            nodeArray = new ListNode(arrayForLinkedList[i], nodeArray);
        }
        headArray = nodeArray;

        // Show original list.
        System.out.println("Recursively");
        System.out.print("Origin:   ");
        linkedListPrint(headArray);

        // Recursively reverse.
        reverseSolution = new msjava2lesson.reverselinkedlist.Solution();
        reversedList = reverseSolution.reverseListRecursively(headArray);
        System.out.print("Reversed: ");
        linkedListPrint(reversedList);
        System.out.println("\n");
    }

    private static void thirdWayToFillLinkedListAndReverse() {
        // Iteratively reverse.
        int size = 10;
        ListNode head = null; // Should be filled by root element.
        ListNode node = new ListNode(size); // The leave
        while(size-- != 0){
            node = new ListNode(size, node);
            if(size == 0) {
                head = node;
            }
        }

        // Show original list.
        System.out.println("iteratively");
        System.out.print("Origin:   ");
        linkedListPrint(head);

        // Reverse
        msjava2lesson.reverselinkedlist.Solution reverseSolution = new msjava2lesson.reverselinkedlist.Solution();
        ListNode reversedList = reverseSolution.reverseList(head);
        System.out.print("Reversed: ");
        linkedListPrint(reversedList);

        // Recursively reverse.
        size = 10;
        head = null; // Should be filled by root element.
        node = new ListNode(size); // The leave
        while(size-- != 0){
            node = new ListNode(size, node);
            if(size == 0) {
                head = node;
            }
        }

        // Show original list.
        System.out.println("iteratively");
        System.out.print("Origin:   ");
        linkedListPrint(head);

        // Recursively reverse.
        reverseSolution = new msjava2lesson.reverselinkedlist.Solution();
        reversedList = reverseSolution.reverseListRecursively(head);
        System.out.print("Reversed: ");
        linkedListPrint(reversedList);
        System.out.println("\n");
    }

    private static void secondWayToFillLinkedListAndReverse() {
        ListNode reversedList;
        msjava2lesson.reverselinkedlist.Solution reverseSolution;
        // Iteratively reverse.
        ListNode node2 = new ListNode(2);
        ListNode node1 = new ListNode(1, node2);
        ListNode nodeHead1 = new ListNode(0, node1);

        // Show original list.
        System.out.println("iteratively");
        System.out.print("Origin:   ");
        linkedListPrint(nodeHead1);

        // Reverse
        reverseSolution = new msjava2lesson.reverselinkedlist.Solution();
        reversedList = reverseSolution.reverseList(nodeHead1);
        System.out.print("Reversed: ");
        linkedListPrint(reversedList);

        // Recursively reverse.
        node2 = new ListNode(2);
        node1 = new ListNode(1, node2);
        nodeHead1 = new ListNode(0, node1);

        // Show original list.
        System.out.println("Recursively");
        System.out.print("Origin:   ");
        linkedListPrint(nodeHead1);

        // Recursively reverse.
        reverseSolution = new msjava2lesson.reverselinkedlist.Solution();
        reversedList = reverseSolution.reverseListRecursively(nodeHead1);
        System.out.print("Reversed: ");
        linkedListPrint(reversedList);
        System.out.println("\n");
    }

    private static void firstWayToFillLinkedListAndReverse() {
        // Iteratively Reverse
        // Fill list by some data.
        ListNode nodeHead = new ListNode(1); // Head
        nodeHead.next = new ListNode(2);

        ListNode nodeA = nodeHead.next;
        nodeA.next = new ListNode(3);

        ListNode nodeB = nodeA.next;
        nodeB.next = new ListNode(4);

        ListNode nodeC = nodeB.next;
        nodeC.next = new ListNode(5);

        // Show original list.
        System.out.println("iteratively");
        System.out.print("Origin:   ");
        linkedListPrint(nodeHead);

        // Iteratively Reverse
        msjava2lesson.reverselinkedlist.Solution reverseSolution = new msjava2lesson.reverselinkedlist.Solution();
        ListNode reversedList = reverseSolution.reverseList(nodeHead);
        System.out.print("Reversed: ");
        linkedListPrint(reversedList);

        // Recursively reverse.
        // 1st way to fill linked list.
        nodeHead = new ListNode(1); // Head
        nodeHead.next = new ListNode(2);

        nodeA = nodeHead.next;
        nodeA.next = new ListNode(3);

        nodeB = nodeA.next;
        nodeB.next = new ListNode(4);

        nodeC = nodeB.next;
        nodeC.next = new ListNode(5);

        // Show original list.
        System.out.println("Recursively");
        System.out.print("Origin:   ");
        linkedListPrint(nodeHead);
        // Recursively reverse.
        ListNode reversedListRecursively = reverseSolution.reverseListRecursively(nodeHead);
        System.out.print("Reversed: ");
        linkedListPrint(reversedListRecursively);
        System.out.println("\n");
    }

    /**
     * https://leetcode.com/problems/move-zeroes/description/
     */
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
        System.out.println("Exception EXPECTED");
        solution.moveZeroes(aNumInputExcept);
    }
}
