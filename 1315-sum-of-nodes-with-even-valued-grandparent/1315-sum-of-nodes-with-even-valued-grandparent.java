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
    public int sumEvenGrandparent(TreeNode root) {
        
        if( root == null)
            return 0;
        
        int sum=0;
         if ( root.left != null){
             if(root.val %2 == 0 && root.left.left != null)
                 sum += root.left.left.val;
             if(root.val %2 == 0 && root.left.right != null)
                 sum += root.left.right.val;
         }
          if ( root.right != null){
             if(root.val %2 == 0 && root.right.left != null)
                  sum += root.right.left.val;
             if(root.val %2 == 0 && root.right.right != null)
                  sum += root.right.right.val;
         }
        
        return sum + sumEvenGrandparent(root.left) + sumEvenGrandparent(root.right);
    }
}