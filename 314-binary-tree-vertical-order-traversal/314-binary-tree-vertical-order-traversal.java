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
    /**

    **/
    Map<Integer,List<int[]>> map = new TreeMap<>();
    public List<List<Integer>> verticalOrder(TreeNode root) {
        helper(root,0,0);
        List<List<Integer>> result = new ArrayList<>();
        for(List<int[]> l : map.values()){
            Collections.sort(l, Comparator.comparingInt( a -> a[1] ));
            List<Integer> temp = new ArrayList<>();
            for(int[] n : l)
                temp.add(n[0]);
            result.add(temp);
        }
        return result;
    }
    
    void helper(TreeNode node, int column, int level){
        if( node == null)
            return;
        helper(node.left, column-1, level+1);
        map.computeIfAbsent(column, v -> (new ArrayList<int[]>())).add(new int[]{node.val,level});
        helper(node.right, column+1, level+1);

    }
}