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
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        return createBST(0, list.size()-1, list);
    }
    
    void inorder(TreeNode root, List<Integer> list){
        if (root == null)
            return;
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }
    
    TreeNode createBST(int l, int r, List<Integer> list){
        if( l > r)
            return null;
        
        TreeNode node = new TreeNode();
        int mid = l + ((r-l)/2);
        node.val = list.get(mid);
        node.left = createBST(l, mid-1, list);
        node.right = createBST(mid+1, r, list);
        return node;
    }
    
}