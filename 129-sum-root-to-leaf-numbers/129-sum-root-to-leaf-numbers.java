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
    int result =0;
    public int sumNumbers(TreeNode root) {
        helper(root,0);
        return result;
    }
    
    void helper( TreeNode node, int sum) {
        if( node == null)
            return;
        
        sum = (sum * 10) + node.val;
        helper( node.left, sum);
        helper( node.right, sum);
        
        if( node.left == null && node.right == null){
            result += sum;
        }       
    }
}