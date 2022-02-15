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
    
    int maxCount = 0;
    public int[] findFrequentTreeSum(TreeNode root) {
        HashMap<Integer,Integer> map = new HashMap<>();
        // pupulate map
        traverse(root, map);
        List<Integer> ansList = new ArrayList<>();
        // get number items having max freq
        
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            if( entry.getValue() == maxCount){
                ansList.add(entry.getKey());
            } 
        }
        
        int[]  ans = new int[ansList.size()];
        int i=0;
        for(int n : ansList) {
            ans[i++] = n;
        }
        return ans;
    }
    
    int traverse(TreeNode node, HashMap<Integer,Integer> map){
        
        if (node == null)
            return 0;
        
        int l = traverse(node.left, map);
        int r = traverse(node.right, map);
        
        int sum = l + r + node.val;
        
        map.put(sum, map.getOrDefault(sum,0)+1);
        
        maxCount = Math.max(maxCount, map.get(sum));
        
        return sum;
        
    }
}