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

/**
4,5,
**/
class Solution {
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        process(root,result);
        return result;
    }
    
    int process(TreeNode node, List<List<Integer>> result) {
        if( node == null)
            return 0;
        int lheight = process(node.left, result);
        int rheight = process(node.right, result);
        int height = 1 + Math.max(lheight, rheight);
        
        if(result.size()< height)
            result.add(new ArrayList<>());
        
        result.get(height-1).add(node.val);
        
        return height;
    }
}