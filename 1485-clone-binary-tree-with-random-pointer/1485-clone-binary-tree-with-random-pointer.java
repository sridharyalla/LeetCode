/**
 * Definition for Node.
 * public class Node {
 *     int val;
 *     Node left;
 *     Node right;
 *     Node random;
 *     Node() {}
 *     Node(int val) { this.val = val; }
 *     Node(int val, Node left, Node right, Node random) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *         this.random = random;
 *     }
 * }
 */

class Solution {
    public NodeCopy copyRandomBinaryTree(Node root) {
        HashMap<Node,NodeCopy> map = new HashMap<>();
        return dfs (root, map);
    }
    
    NodeCopy dfs(Node node, HashMap<Node,NodeCopy> map){
        if( node == null)
            return null;
        
        if(map.containsKey(node)){
            return map.get(node);
        }
        
        NodeCopy copyNode = new NodeCopy(node.val);
        map.put(node, copyNode);

        
        copyNode.left = dfs(node.left, map);
        copyNode.right = dfs(node.right, map);
        copyNode.random = dfs(node.random, map);
        
        return copyNode;
            
    }
}