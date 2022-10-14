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
public class Solution {
    public ListNode detectCycle(ListNode head) {
        
        ListNode fast = head, slow = head, slowTwo = head;
        
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            
            //first collision
            if (fast == slow) 
                break;
        }
        
        //when there is no cycle, fast or it's next will be null
        if (fast == null || fast.next == null)
            return null;
        
        while (slowTwo != null && slow != null) {
            
            //second collision -> gives the answer
            if (slow == slowTwo) break;
            
            slow = slow.next;
            slowTwo = slowTwo.next;
        }
        return slowTwo;
    }
}