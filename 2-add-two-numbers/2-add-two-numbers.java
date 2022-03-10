/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 
 
 [9,9,9,9,9,9,9]
 [9,9,9,9]
  8 9 9 9 0 0 0 1
 
 
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry =0;
        ListNode head = new ListNode();
        ListNode result = head;
        while( l1 != null || l2 != null){
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;
            int sum = x+y+carry;
            carry =0;
            if( sum > 9){
                carry =1;
                sum %= 10;
            }
            if( l1 != null) l1 = l1.next;
            if( l2 != null) l2 = l2.next;
            head.next = new ListNode(sum);
            head = head.next;
        }
        if (carry != 0){
            head.next = new ListNode(carry);
        }
        return result.next; 
    }
}