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
    public TreeNode createBinaryTree(int[][] descriptions) {
        HashMap<Integer,TreeNode> map = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();
        for(int[] description : descriptions){
            set.add(description[1]);
            map.computeIfAbsent(description[0], v -> new TreeNode(description[0]));
            map.computeIfAbsent(description[1], v -> new TreeNode(description[1]));
            if(description[2] == 1)
                map.get(description[0]).left= map.get(description[1]);
            else
                map.get(description[0]).right= map.get(description[1]);
        }
        
        int root = -1;
        
        for(int[] arr : descriptions){
            if( !set.contains(arr[0])){
                root = arr[0];
                break;
            }
        }
        
        return map.getOrDefault(root, new TreeNode());
    }
}