/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        /*if(lists == null || lists.length == 0) return null;
        
        return mergeKLists(lists, 0, lists.length - 1);*/
        
        if(lists == null || lists.length == 0) return null;
        
        // 使用 Priority Queue 最小堆，时间复杂度 O(NlogK)
        PriorityQueue<ListNode> queue = new PriorityQueue(new Comparator<ListNode>() {
            public int compare(ListNode n1, ListNode n2) {
                return n1.val - n2.val;
            }
        });
        
        for(ListNode head : lists) {
            if(head != null) {
                queue.offer(head);
            }
        }
        
        ListNode dummpHead = new ListNode(-1);
        ListNode p = dummpHead;
        
        while(!queue.isEmpty()) {
            // 拿到最小值
            ListNode node = queue.poll();
            
            p.next = node;
            p = p.next;
            
            if(node.next != null) {
                queue.offer(node.next);
            }
        }
        
        return dummpHead.next;
    }
    
    public ListNode mergeKLists(ListNode[] lists, int start, int end) {
        if(start == end) {
            return lists[start];
        }
        
        int mid = (start + end) / 2;
        ListNode left = mergeKLists(lists, start, mid);
        ListNode right = mergeKLists(lists, mid + 1, end);
        
        return merge2Lists(left, right);
    }
    
    public ListNode merge2Lists(ListNode l1, ListNode l2) {
        ListNode dummpHead = new ListNode(-1);
        ListNode p = dummpHead;
        
        ListNode p1 = l1;
        ListNode p2 = l2;
        
        while(p1 != null && p2 != null) {
            if(p1.val <= p2.val) {
                p.next = p1;
                p = p.next;
                
                p1 = p1.next;
            }
            else {
                p.next = p2;
                p = p.next;
                
                p2 = p2.next;
            }
        }
        
        p.next = (p1 != null? p1 : p2);
        
        
        
        return dummpHead.next;
    }
}
