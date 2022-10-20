/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/*
                6
               / \
              /   \
             4     8
            / \   / \
           1   5 7   9
           
          int left = Math.min(p.val, q.val);
        int right = Math.max(p.val, q.val);
        TreeNode curr = root;
        
        while (curr == null) {
            if (curr.val > right) {
                curr = curr.left;
            } else if (curr.val < left){
                curr = curr.right;
            } else {
                return curr;
            }
            
        }
        return null;
        
        Tried this solution but it was falling some testcases - will come back to it
        
Optimal
- Check if we can go to the left or right
That is both the two descendant nodes are less than or are greater than the root.
If we can not we just return the root.
     example    6
               / \
              /   \
             4     8
            / \   / \
           1   5 7   9
         here for the LCA of 1 and 5
         They are all less so we go to the left and our root now
         will be 4. And because we can not go to the right or to the left, we return the root
         
         if we had 4 and 5 it would be the same thing.
*/

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        return root;
    }
}