/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        HashMap<Node,Node> map = new HashMap<>();
        Node copyHead = new Node(0);
        Node dummy = copyHead;
        Node oldHead = head;
        while(head != null){
            Node newNode = new Node(head.val);
            copyHead.next = newNode;
            map.put(head,newNode);
            head = head.next;
            copyHead = copyHead.next;
        }
        copyHead = dummy.next;
        head = oldHead;
        while(head != null){
            map.get(head).random = map.get(head.random);
            head = head.next;
        }
        
        return dummy.next;
    }
}