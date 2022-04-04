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
        ListNode kthNode1 = head;
        ListNode kthNode2 = head;
        for(int i =1; i < k;i++){
            kthNode1=kthNode1.next;
        }
        
        ListNode pos = kthNode1;
        while(pos.next != null){
            pos = pos.next;
            kthNode2 = kthNode2.next;
        }
        
        int temp = kthNode1.val;
        kthNode1.val = kthNode2.val;
        kthNode2.val = temp;
        return head;
    }
}