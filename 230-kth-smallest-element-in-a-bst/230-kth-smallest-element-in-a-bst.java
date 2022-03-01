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
    int resut = -1;
    int processed = 0;
    public int kthSmallest(TreeNode root, int k) {
        if(root == null)
            return -1;
        kthSmallest(root.left,k);
        processed++;
        if(processed == k ){
            resut = root.val;
            return root.val;
        }
            
        kthSmallest(root.right,k);
        return resut;
    }
}