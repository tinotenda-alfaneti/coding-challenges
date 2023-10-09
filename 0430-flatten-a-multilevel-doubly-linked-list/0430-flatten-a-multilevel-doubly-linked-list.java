/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};


traverse(node)
    if node == null:
        return;
    nodeList.add(node)
    if node.hasChild:
        Node nextBeforeChild = node.next;
        traverse(node.child)
    else:
        traverse(node.next)



*/

class Solution {
    
    ArrayList<Node> nodeList = new ArrayList<>();
    
    public Node flatten(Node head) {
        
        traverse(head);
        
        if (nodeList.size() == 0 || nodeList.size() == 1) {
            return head;
        }
        
        Node resHead = nodeList.get(0);
        resHead.child = null;
        resHead.prev = null;
        Node curr = resHead;
        
        for(int i = 1; i < nodeList.size(); i++) {
            Node tmp = nodeList.get(i);
            Node prev = nodeList.get(i - 1);
            Node next = (i + 1) >= nodeList.size() ? null : nodeList.get(i + 1);
            
            tmp.next = next;
            tmp.prev = prev;
            tmp.child = null;
            
            curr.next = tmp;
            curr = tmp;      
            
        }
        
        return resHead;
        
    }
    
    public void traverse(Node currNode) {
        if (currNode == null) {
            return;
        }
        nodeList.add(currNode);
        if (currNode.child != null) {
            Node nextBeforeChild = currNode.next;
            traverse(currNode.child);
            traverse(nextBeforeChild);
        } else {
            traverse(currNode.next);
        }
    }
}