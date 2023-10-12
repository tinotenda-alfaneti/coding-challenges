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
    public ListNode insertionSortList(ListNode head) {
        
        ListNode dummy = new ListNode(0, head);
        
        ListNode prev = head;
        ListNode curr = head.next;
        
        while (curr != null) {
            if (curr.val >= prev.val) {
                prev = curr;
                curr = curr.next;
                continue;
            }
            
            ListNode iter = dummy;
            
            while (curr.val > iter.next.val) {
                iter = iter.next;
            }
            
            prev.next = curr.next;
            curr.next = iter.next;
            iter.next = curr;
            curr = prev.next;
            
        }
        return dummy.next;
        
    }
}