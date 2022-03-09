/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 
 
 1 -> 2 -> 3 -> 3 -> 4 ->4 -5
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if( head == null)
            return null;
        
        if(head.next != null && head.val == head.next.val){
            int val = head.val;
            while ( head.next != null && val == head.next.val) {
                head = head.next;
            }
            return deleteDuplicates(head.next);
        } else {
            head.next = deleteDuplicates(head.next);
        }
        return head;
    }
}