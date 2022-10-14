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
        
        if (head == null) return null;
        return buildTree(head, null);    
    }
    
    public TreeNode buildTree(ListNode head, ListNode tail) {
        ListNode slow = head;
        ListNode fast = head;
        
        if (head == tail) return null;
        
        while(fast != tail && fast.next != tail) {
            slow = slow.next;
            fast = fast.next.next;
        }
        TreeNode root = new TreeNode(slow.val);
        root.right = buildTree(slow.next, tail);
        root.left = buildTree(head, slow);
        return root;
                               
    }
    
    
}