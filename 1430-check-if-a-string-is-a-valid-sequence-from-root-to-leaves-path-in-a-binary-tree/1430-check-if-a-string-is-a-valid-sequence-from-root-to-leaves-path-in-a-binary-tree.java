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
    public boolean isValidSequence(TreeNode root, int[] arr) {
        return dfs ( root, arr, 0);
    }
    
    boolean dfs(TreeNode root, int[] arr, int i){
        if( root == null || i >= arr.length)
            return false;
        
        if( i == arr.length-1 && root.val == arr[i] && root.left == null && root.right==null)
            return true;
        
        if( arr[i] != root.val)
            return false;
        return dfs(root.left, arr, i+1 ) || dfs(root.right, arr, i+1 );
    }
}