/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        // Clone Nodes
        // e.g. convert 1->2->3 to 1->1->2->2->3->3
        cloneNodes(head);
        
        // Connect Random Nodes
        connectRandomNodes(head);
        
        // Split The Random List
        return splitRandomList(head);
    }
    
        // Clone Nodes
    void cloneNodes(RandomListNode head)
    {
        RandomListNode p = head;
        while(p != null)
        {
            RandomListNode cloneNode = new RandomListNode(p.label);
            
            cloneNode.next = p.next;
            cloneNode.random = null;
            
            p.next = cloneNode;
            
            p = cloneNode.next;
        }
    }
    
    // Connect Random Nodes
    void connectRandomNodes(RandomListNode head)
    {
        RandomListNode p = head;
        while(p != null)
        {
            RandomListNode cloneNode = p.next;
            if(p.random != null)
            {
                cloneNode.random = p.random.next;
            }
            
            p = cloneNode.next;
        }
    }
    
    // Split The Random List
    RandomListNode splitRandomList(RandomListNode head)
    {
        RandomListNode p = head;
        
        RandomListNode cloneHead = null;
        RandomListNode cloneNode = null;
        
        if(p != null)
        {
            cloneHead = p.next;
            cloneNode = p.next;
            
            p.next = cloneNode.next;
            p = p.next;
        }
        
        while(p != null)
        {
            cloneNode.next = p.next;
            cloneNode = cloneNode.next;
            
            p.next = cloneNode.next;
            p = p.next;
        }
        
        return cloneHead;
    }
}
