/** 
 * 206: reverse linked list
 *
 * Reverse a singled linked list
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null, cur = head, next = null;
        
        while (cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
}
/*      head
NULL    [1] --> [2] --> [3] --> NULL
 ^prev   ^cur                    ^next     
 
NULL    [1] --> [2] --> [3] --> NULL
 ^prev   ^cur    ^next
 
NULL<-- [1]     [2] --> [3] --> NULL
 ^prev   ^cur    ^next 

NULL<-- [1]     [2] --> [3] --> NULL
         ^prev   ^cur    ^next 
 etc
*/
