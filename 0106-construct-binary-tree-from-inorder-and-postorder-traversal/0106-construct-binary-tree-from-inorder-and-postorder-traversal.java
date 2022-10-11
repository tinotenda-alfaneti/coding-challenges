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
    public TreeNode buildTree(int[] A, int[] B) {
        
        if (A.length == 0) return null;
        
        int rootVal = B[B.length - 1];
        int rootIndex = -1;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == rootVal) {
                rootIndex = i;
            }
        }
        System.out.println(rootIndex);
        TreeNode root = new TreeNode(rootVal);
        root.left = buildTree(Arrays.copyOfRange(A, 0, rootIndex), Arrays.copyOfRange(B, 0, rootIndex));
        root.right = buildTree(Arrays.copyOfRange(A, rootIndex + 1, A.length), Arrays.copyOfRange(B, rootIndex, B.length -1));
        return root;
 
    }
}