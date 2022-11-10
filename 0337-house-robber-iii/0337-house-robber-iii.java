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
    public int rob(TreeNode root) {
        
        return robHelper(root, new HashMap<TreeNode, Integer>());
        
    }
    
    public int robHelper(TreeNode node, HashMap<TreeNode, Integer> memo) {
        if (node == null)
            return 0;
        
        int total = 0;
        
        if (node.left != null) {
            total += robHelper(node.left.left, memo) + robHelper(node.left.right, memo);
        }
        if (node.right != null) {
            total += robHelper(node.right.right, memo) + robHelper(node.right.left, memo);
        }
        
        if (memo.containsKey(node))
            return memo.get(node);
        
        memo.put(node, Math.max(node.val + total, robHelper(node.left, memo) + robHelper(node.right, memo)));
        return memo.get(node);
        
        
    }
}