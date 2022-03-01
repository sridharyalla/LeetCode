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
    int min = Integer.MAX_VALUE;
    public int minDepth(TreeNode root) {
        if ( root == null)
            return 0;
        helper(root,0);
        return min;
    }
    
    void helper(TreeNode node, int level){
        if ( node == null)
            return;
        
        helper(node.left, level+1);
        if( node.left == null && node.right == null)
            min = Math.min(min,level+1);
        helper(node.right, level+1);
    }
}