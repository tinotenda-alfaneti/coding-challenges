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
    public List<List<Integer>> levelOrder(TreeNode root) {
        // the arraylist to be returned
        List<List<Integer>> result = new ArrayList();
        List<Integer> temp = new ArrayList<>();
        
        if (root == null) return result;
        
        Queue<TreeNode> frontier = new LinkedList<TreeNode>();
        frontier.add(root);
        temp.add(root.val);
        result.add(temp);
        
        while (!frontier.isEmpty()) {
            temp = new ArrayList<>();
            int lenRes = result.size();
            
            for (int i = 0; i < result.get(lenRes - 1).size(); i++) {
                TreeNode popped = frontier.poll();

                if (popped != null) {

                    if (popped.left != null) {
                        temp.add(popped.left.val);
                        frontier.add(popped.left);
                    }

                    if (popped.right != null) {
                        temp.add(popped.right.val);
                        frontier.add(popped.right);
                    }
                }
            }
            
            if (temp.size() > 0) result.add(temp);
        }
        return result;
    }
}