;/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        int carry = 0;
        
        ListNode resHead = new ListNode();
        ListNode curr = resHead;
        
        while (l1 != null || l2 != null) {
            int res = 0;
            if (l1 != null && l2 != null) {
                res = l1.val + l2.val + carry;
                l1 = l1.next;
                l2 = l2.next;
                
            } else if (l1 != null && l2 == null) {
                res = l1.val + carry;
                l1 = l1.next;
                
            } else if (l1 == null && l2 != null) {      
                res = l2.val + carry;
                l2 = l2.next;
            
            }
            
            carry = res / 10;
            res = res % 10;
            ListNode tmp = new ListNode(res);
            curr.next = tmp;
            curr = curr.next;
        }
        
        if (carry != 0) {
            ListNode tmp = new ListNode(carry);
            curr.next = tmp; 
        }
        
        return resHead.next;
        
    }
}