package msjava2lesson.reverselinkedlist;
import jakarta.annotation.Nullable;

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
    /**
     * Constraints:
     * The number of nodes in the list is the range [0, 5000].
     * -5000 <= Node.val <= 5000
     */
    private static final int listLengthMax = 5000;

    /**
     * Reverts list, so head becomes the leave.
     *
     * @param head Liked list head. Can be `null`, which represents an empty list.
     * @return ListNode the new head of reversed list. `null`if the input list is empty.
     */
    public ListNode reverseList(@Nullable ListNode head) {
        isLengthValid(head);
        isValueCorrect(head);

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

    /**
     * Reverts recursively list, so head becomes the leave.
     *
     * @param head Liked list head. Can be `null`, which represents an empty list.
     * @return ListNode the new head of reversed list.
     */
    public ListNode reverseListRecursively(@Nullable ListNode head) {
        if (null == head)
            return null;

        isLengthValid(head);
        isValueCorrect(head);

        return reverseListRecursion(head, null);
    }

    /**
     * Changes `next` field of ListNode object.
     *
     * @param current Liked list node. Can be `null` when on of next nodes is null.
     * @param previous Liked list node. Is `null` when 1st enter to the method.
     * @return Liked list head;
     */
    private ListNode reverseListRecursion(@Nullable ListNode current, @Nullable ListNode previous) {
        if(null == current)
            return previous;

        ListNode next = current.next;
        current.next = previous;

        return reverseListRecursion(next, current);
    }

    /**
     * Checks the length constraints for linked list since the passed head.
     *
     * @param head Liked list head.
     */
    private void isLengthValid(@Nullable ListNode head){
        int count = 0;
        while (head != null){
            if(listLengthMax <= ++count)
                throw new LinkListInvalidException("Linked list is out of constraints.");

            head = head.next;
        }
    }

    /**
     * Checks each value of linked list since the passed head.
     *
     * @param head Liked list head.
     */
    private void isValueCorrect(@Nullable ListNode head){
        while (head != null){
            if(-listLengthMax > head.val || listLengthMax < head.val)
                throw new LinkListInvalidException("Linked list node's value is out of constraints.");

            head = head.next;
        }
    }
}
