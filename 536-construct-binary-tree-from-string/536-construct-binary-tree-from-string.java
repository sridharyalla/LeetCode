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
    int i =0;
    public TreeNode str2tree(String s) {
        if (s == null || s.isEmpty())
            return null;
        
        return build("("  + s + ")");
    }
    
    TreeNode build(String str){
        if ( i >= str.length())
            return null;

        int start =i+1;
        int end = i+1;
        while (end < str.length() && (Character.isDigit(str.charAt(end)) || str.charAt(end) == '-')){
            end++;
        }
        int val = Integer.parseInt(str.substring(start, end));
        TreeNode node = new TreeNode(val);
        i = end;
        if (str.charAt(i) == '('){
            node.left = build(str);
            if( i< str.length() && str.charAt(i) == '(') {
                node.right = build(str);
            }
        }
        i++;
        return node;
    }
}