/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<Integer,List<Integer>> graph = new HashMap<>();
        buildGraph(graph,root,null);
        Queue<Integer> q = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        if( !graph.containsKey(target.val))
            return result;
        q.offer(target.val);
        int distance=0;
        Set<Integer> visited = new HashSet<>();
        while( !q.isEmpty()){
            if( distance == k)
                return new ArrayList<Integer>(q);
            int size = q.size();
            
            for(int i=0; i < size; i++){
                int node = q.poll();
                visited.add(node);
                List<Integer> neighbours = graph.getOrDefault(node, new ArrayList<>());
                for(int n : neighbours){
                    if( !visited.contains(n))
                    q.add(n);
                }
            }
            distance++;
        }
        return result;
    }
    
    void buildGraph(Map<Integer,List<Integer>> graph, TreeNode node, TreeNode parent) {
        if( node == null)
            return;
        
        List<Integer> neighbours = graph.computeIfAbsent(node.val, v -> new ArrayList<Integer>());
        if(parent != null)
            neighbours.add(parent.val);
        if(node.left != null)
            neighbours.add(node.left.val);
        if(node.right != null)
            neighbours.add(node.right.val);
        
        buildGraph(graph, node.left,node);
        buildGraph(graph, node.right,node);
        }
}