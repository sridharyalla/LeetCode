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
    public int goodNodes(TreeNode root) {
        if( root == null)
            return 0;
        goodNodes(root,root.val);
        return result;
    }
    
    void goodNodes(TreeNode node, int max){
        if( node == null)
            return;
        max = Math.max(max,node.val);
        goodNodes(node.left, max);
        if( max <= node.val){
            result++;
        }
        goodNodes(node.right,max);
    }
}