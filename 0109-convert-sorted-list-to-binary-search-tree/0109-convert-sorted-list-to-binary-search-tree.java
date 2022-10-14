/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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

/*

 1-2
       1                2
        \                \
         2                1           
 
      
                
            
*/
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        
        List<Integer> nodesList = new ArrayList<>();
        while (head != null) {
            nodesList.add(head.val);
            head = head.next;
        }
        
        return buildTree(nodesList);    
    }
    
    public TreeNode buildTree(List<Integer> nodesList) {
        if (nodesList.size() == 1) return new TreeNode(nodesList.get(nodesList.size() - 1));
        if (nodesList.size() == 0) return null;
        TreeNode root = new TreeNode(nodesList.get(nodesList.size() / 2));
        root.right = buildTree(nodesList.subList((nodesList.size()/2) + 1, nodesList.size()));
        root.left = buildTree(nodesList.subList(0, nodesList.size() / 2));
        return root;
                               
    }
    
    
}