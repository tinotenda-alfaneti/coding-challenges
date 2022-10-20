/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
/*
To optimize the solution l once wrote some time back, 8 months ago
I will try to solve this question with constant space and linear runtime
If you are thinking that I am gonna use pointers, you damn right.
Floyd 's cycle detection - For full explanation go to the question on 
finding a duplicate number in constant space and linear time
*/
public class Solution {
    public boolean hasCycle(ListNode head) {
        
        ListNode hare = head;
        ListNode tortoise = head;
        
        if (head == null) return false;
            
        while (hare != null && hare.next != null && tortoise != null) {
            hare = hare.next.next;
            tortoise = tortoise.next;
            if (hare == tortoise) {
                return true;
            }
        }
        return false;
        
    }
}