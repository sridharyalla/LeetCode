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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        traverse(root,"",ans);
        return ans;
    }
    void traverse(TreeNode root, String current, List<String> result){
        if(root == null)
            return;
        
        if(current.equals(""))
            current += root.val;
        else
            current += "->" +root.val;
        
        if(root.left == null && root.right == null)
            result.add(current);
        
        traverse(root.left, current, result);
        traverse(root.right, current, result);
    }
}