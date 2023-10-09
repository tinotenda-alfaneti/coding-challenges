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
    HashMap<Integer, TreeNode> diffMap = new HashMap<>();
    HashMap<Integer, TreeNode> nodesMap = new HashMap<>();
    public boolean findTarget(TreeNode root, int k) {
        
        traverseTree(root, k);
        
        for (int num : diffMap.keySet()) {
            
            if (nodesMap.containsKey(num)) {
                TreeNode diffNode = diffMap.get(num);
                TreeNode orgNode = nodesMap.get(num);
                if (diffNode != orgNode) return true;
            }
        }
        
        return false;
        
    }
    
    public void traverseTree(TreeNode root, int target) {
        
        if (root == null) return;
        diffMap.put(target - root.val, root);
        nodesMap.put(root.val, root);
        
        if (root.left != null) {
            traverseTree(root.left, target);
        }
        if (root.right != null) {
            traverseTree(root.right, target);
        }
        
    }
}