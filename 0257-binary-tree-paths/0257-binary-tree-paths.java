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
    public List<String> binaryTreePaths(TreeNode root) {
        
        List<String> paths = new ArrayList<>();
        Stack<String> path = new Stack<>();
        
        visited(root, path, paths);
        
        return paths;
        
    }
    
    public void visited(TreeNode node, Stack<String> path, List<String> paths) {
        if (node == null) return;
        if (node.left == null && node.right == null) {
            path.push(node.val + "");
            paths.add(String.join("->", path));
            path.pop();
        }
        path.push(node.val + "");
        visited(node.left, path, paths);
        visited(node.right, path, paths);
        path.pop();
    }
}