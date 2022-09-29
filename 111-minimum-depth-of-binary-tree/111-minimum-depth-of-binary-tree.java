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
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        int count = 1;
        
        Queue<TreeNode> frontier = new LinkedList<>();
        frontier.offer(root);
        
        while (!frontier.isEmpty()) {
            
            int fSize = frontier.size();
            
            for (int i = 0; i < fSize; i++){
                TreeNode popped = frontier.poll();
                
                if (popped.left == null && popped.right == null)
                    return count;
                if (popped.left != null)
                    frontier.offer(popped.left);
                if (popped.right != null)
                    frontier.offer(popped.right);
            }
            count++;
                
            
        }
        return count;
        
    }
}