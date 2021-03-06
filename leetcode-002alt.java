/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode n1 = l1;
        ListNode n2 = l2;
        ListNode answerHead = null, answer = null;
        int current = 0, carry = 0;
        
        while (n1 != null || n2 != null || carry == 1) {
            current = carry;
            carry = 0;
            if (n1 != null) {
                current += n1.val;
                n1 = n1.next;
            }
            if (n2 != null) {
                current += n2.val;
                n2 = n2.next;
            }
            if (current > 9) {
                carry = 1;
                current = current - 10;
            }
            if (answer == null) {
                answerHead = new ListNode(current);
                answer = answerHead;
            } else {
                answer.next = new ListNode(current);
                answer = answer.next;
            }
        }
        
        return answerHead;
    }
}