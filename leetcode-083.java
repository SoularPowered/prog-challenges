/**
 * 83. Remove Duplicates from Sorted List
 * Given a sorted linked list, delete all duplicates such that each element appear only once. 
 * 
 * For example,
 *  Given 1->1->2, return 1->2.
 *  Given 1->1->2->3->3, return 1->2->3.
 *
 *
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode    cur = head, 
                    nextNonDup = (head == null) ? null : head.next;
        
        while (nextNonDup != null) {
            nextNonDup = cur.next;
            while (nextNonDup != null && cur.val == nextNonDup.val) 
                nextNonDup = nextNonDup.next;
            cur.next = nextNonDup;
            cur = nextNonDup;
        }
        
        return head;
    }
}
