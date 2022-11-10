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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        ListNode dummy = new ListNode(0);
        ListNode ptr1 = dummy, ptr2 = dummy;
        
        ptr2.next = head;
        
        //Open gap = n between the 2 pointers
        while(n >= 0) {
            ptr1 = ptr1.next;
            n--;
        }
        
        //mantain the gap while navigating to the last element
        while(ptr1 != null) {
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }
        //skip the target node
        ptr2.next = ptr2.next.next;
        
        return dummy.next;
        
    }
}