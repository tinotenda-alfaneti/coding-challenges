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
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        ListNode dummy_head = new ListNode(0);
        ListNode ans = dummy_head;
        
        int carry = 0;
        
        while (l1 != null || l2 != null) {
            
            // When l1/l2 is null the val is set to zero
            int x = l1 != null ? l1.val : 0;
            int y = l2 != null ? l2.val : 0;
            
            // adding the nodes values and the carry from previous calculation
            int sum = x + y + carry;
            
            //computing the carry and getting last digit
            carry = sum/10;
            int last_digit = sum%10;
            
            //adding the last digit to Linked List of answers
            ListNode new_node = new ListNode(last_digit);
            ans.next = new_node;
            ans = ans.next;
            
            //moving the pointers of the given linked Lists
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        
        // in case there is a value that was carried over
        if (carry > 0) {
            ListNode new_node = new ListNode(carry);
            ans.next = new_node;
        }
        
        
        return dummy_head.next;
        
    }
}