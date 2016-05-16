/**
 * 141. Linked List Cycle
 * Given a linked list, determine if it has a cycle in it. 
 * 
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        
        ListNode fast = head.next, slow = head;

        while (fast != null && slow != null) {
            if (slow == fast) return true;
            fast = (fast.next == null) ? null : fast.next.next;
            slow = slow.next;
        }
        return false;
    }
}
