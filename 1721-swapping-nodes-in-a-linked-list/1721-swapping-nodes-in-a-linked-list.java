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
    public ListNode swapNodes(ListNode head, int k) {
        ListNode kthNodeFirst = head;
        ListNode kthNodeLast = head;
        
        for(int i =1; i < k;i++){
            kthNodeFirst=kthNodeFirst.next;
        }
        
        ListNode pos = kthNodeFirst;
        while(pos.next != null){
            pos = pos.next;
            kthNodeLast = kthNodeLast.next;
        }
        
        int temp = kthNodeFirst.val;
        kthNodeFirst.val = kthNodeLast.val;
        kthNodeLast.val = temp;
        
        return head;
    }
}