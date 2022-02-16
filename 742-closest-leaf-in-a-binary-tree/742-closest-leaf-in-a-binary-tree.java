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
    public int findClosestLeaf(TreeNode root, int k) {
     
        // Build Graph
        
        Map<Integer, List<TreeNode>> graph = new HashMap<>();
        
        
        Queue<TreeNode> q = new LinkedList<>();
        dfs(root, graph, q, k);
        Set<TreeNode> visited = new HashSet<>();
        
        while(!q.isEmpty()){
            TreeNode node = q.poll();
            
            if( visited.contains(node))
                continue;
            
            if(node.left == null && node.right==null)
                    return node.val;
            
            visited.add(node);
            
            List<TreeNode> neighbours = graph.get(node.val);
            if( neighbours == null)
                continue;
            
            for(TreeNode neigbour : neighbours) {
                q.add(neigbour);
            }
        }
        
        return -1;
    }
    
     void dfs(TreeNode node, Map<Integer, List<TreeNode>> graph, Queue<TreeNode> q, int k){
         if( node == null)
             return;
         
         if( k == node.val)
             q.add(node);
         
         if(node.left != null){
             graph.computeIfAbsent(node.val, v -> new ArrayList<>()).add(node.left);
             graph.computeIfAbsent(node.left.val, v -> new ArrayList<>()).add(node);
         }
         
        if(node.right != null){
             graph.computeIfAbsent(node.val, v -> new ArrayList<>()).add(node.right);
             graph.computeIfAbsent(node.right.val, v -> new ArrayList<>()).add(node);
         }
         
         dfs ( node.left, graph, q, k);
         dfs ( node.right, graph, q, k);
     }
}