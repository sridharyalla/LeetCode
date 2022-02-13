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
    int maxDepth = 0;
    boolean result = true;
    public boolean isBalanced(TreeNode root) {
        depth(root);
        return result;
    }
    
    int depth(TreeNode node){
        if( node == null)
            return 0;
        
        int ldepth = depth(node.left);
        int rdepth = depth(node.right);
        
        if( Math.abs(ldepth - rdepth) > 1)
            result=false;
        
        return 1 + Math.max(ldepth,rdepth);
        
    }
}