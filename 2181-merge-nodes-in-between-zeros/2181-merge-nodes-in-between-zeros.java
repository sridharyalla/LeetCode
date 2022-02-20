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
class Solution {
    public ListNode mergeNodes(ListNode head) {
        ListNode result = new ListNode();
        ListNode dummy = result;
        head = head.next;
        
        int sum =0;
        while( head != null) {
            if ( head.val != 0) {
                sum += head.val;
            } else {
                result.next = new ListNode(sum);
                result = result.next;
                sum = 0;
            }
            head = head.next;
        }
        
        return dummy.next;
    }
    
}