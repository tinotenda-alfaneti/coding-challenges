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

/*
FLOYD'S TORTOISE AND HARE APPROACH

1. Get the mid of the linkedlist - using the fast and slow pointer
2. then reverse the other half of the linked list
3. After that you just start to compare the reversed part and the other half
Time complexity - O(n), Space - O(1)

My Initial Approach
    - Change the linked list to an ArrayList/Array 
    - Then just compare normally to see if it is a palindrome
    - Time complexity - O(n), Space - O(n)

*/
class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head.next == null || head == null) return true;
        
        ListNode fast = head;
        ListNode slow = head;
        
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        if(fast != null) slow = slow.next;
        
        ListNode revHead = reverse(slow);
        
        return checkPalindrome(head, revHead);   
        
    }
    public boolean checkPalindrome(ListNode head, ListNode revHead) {
        while (revHead != null){
            if(revHead.val != head.val) return false;
            else {
                revHead = revHead.next;
                head = head.next;
            }
        }
        return true;
        
    }
    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode next = null;
        ListNode curr = head;
        
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}