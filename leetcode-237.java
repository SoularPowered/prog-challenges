/**
 * 237. Delete Node in a Linked List
 * Supposed the linked list is 1 -> 2 -> 3 -> 4
 * and you are given the third node with value 3, 
 * the linked list should become 1 -> 2 -> 4 after calling your function. 
 *
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void deleteNode(ListNode node) {
        ListNode nextNode = node.next;
        int nextVal = nextNode.val;
        node.val = nextVal;
        node.next = nextNode.next;
    }
}
