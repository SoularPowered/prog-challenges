/**
 * 21. Merge Two Sorted Lists
 * Merge two sorted linked lists and return it as a new list. 
 * The new list should be made by splicing together the nodes of the first two lists.
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // ListNode newHead = (l1.val < l2.val) ? l1 : l2;
        ListNode newHead, newCur, nextLeft = l1, nextRight = l2;
        
        // Handle null list input
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        
        // Determine the head and remember it, also grab reference to current position in new list
        if (nextLeft.val < nextRight.val) {
            newHead = nextLeft;
            nextLeft = nextLeft.next;
        } else {
            newHead = nextRight;
            nextRight = nextRight.next;
        }
        newCur = newHead;
        
        // First iterate while neither of the lists is empty
        while (nextLeft != null && nextRight != null) {
            if (nextLeft.val < nextRight.val) {
                newCur.next = nextLeft;
                nextLeft = nextLeft.next;
            } else {
                newCur.next = nextRight;
                nextRight = nextRight.next;
            }
            
            newCur = newCur.next;
        }
        
        // Whichever sub-list is NOT empty is the tail of the new list
        ListNode newTail = (nextLeft != null) ? nextLeft : nextRight;
        newCur.next = newTail;

        return newHead;
    }
}
