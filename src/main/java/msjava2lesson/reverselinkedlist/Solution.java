package msjava2lesson.reverselinkedlist;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode tempNode;
        ListNode previousNode = null; // Node of `next` field value after reverse the HEAD of list.

        while(head != null){
            tempNode = head.next; // Save next item to pass it later at next iteration.
            head.next = previousNode; // Reverse the list item pointer.
            // Current node is changed(reversed), below changes for next iteration.
            previousNode = head; // Set current node as next(reverse) for next iteration.
            head = tempNode;
        }
        return previousNode;
    }

    public ListNode reverseListRecursively(ListNode head) {

        if (head.next == null || head == null)
            return head;

        ListNode node = reverseListRecursively(head.next);

        head.next.next = head;
        head.next = null;

        return node;
    }
}