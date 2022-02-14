/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> getLonelyNodes(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        getLonelyNodes(root, null, result);
        return result;
    }
    
    void getLonelyNodes(TreeNode node, TreeNode parent, List<Integer> result){
        
        if( node == null)
            return;
            
        if(parent  != null && parent.left != null && parent.right ==null )
            result.add(parent.left.val);
        
        if(parent  != null && parent.right != null && parent.left ==null )
            result.add(parent.right.val);
        
        getLonelyNodes(node.left, node, result);
        getLonelyNodes(node.right, node, result);
    }
    
    
}