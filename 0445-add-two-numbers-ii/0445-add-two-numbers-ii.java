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
        
        Stack<Integer> l1Stack = new Stack<>();
        Stack<Integer> l2Stack = new Stack<>();
        ArrayList<Integer> resArr = new ArrayList<>();
        int carry = 0;
        
        
        while (l1 != null) {
            l1Stack.push(l1.val);
            l1 = l1.next;
        }
        
        while (l2 != null) {
            l2Stack.push(l2.val);
            l2 = l2.next;
        }
        
        while (!l1Stack.isEmpty() || !l2Stack.isEmpty()) {
            
            int res = 0;
            
            if (!l1Stack.isEmpty() && !l2Stack.isEmpty()) {
                res = l1Stack.pop() + l2Stack.pop() + carry;
            } else if (l1Stack.isEmpty() && !l2Stack.isEmpty()) {
                res = l2Stack.pop() + carry;
            } else if (!l1Stack.isEmpty() && l2Stack.isEmpty()) {
                res = l1Stack.pop() + carry;
            }
            
            carry = res / 10;
            res = res % 10;
            
            resArr.add(res);
            
        }
        
        if (carry != 0) {
            resArr.add(carry);
        }
        
        ListNode resHead = new ListNode();
        ListNode curr = resHead;
        
        int len = resArr.size();
        
        
        for (int i = len - 1; i >= 0; i--) {
            
            ListNode tmp = new ListNode(resArr.get(i));
            curr.next = tmp;
            curr = curr.next;
            
        }
        
        return resHead.next;
        
        
        
    }
}