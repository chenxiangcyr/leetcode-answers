/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    ListNode *reverseBetween(ListNode *head, int m, int n) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        
        if(head == NULL)
            return head;
        if(m == n)
            return head;
        
        ListNode *pNode = head;
        
        ListNode *mPrevNode = NULL;
        ListNode *mNode = NULL;
        ListNode *nNode = NULL;
        
        int i = 0;
        
        // Find the m th node
        while(i < m)
        {
            mNode = pNode;
            pNode = pNode->next;
            i++;
        }
        
        ListNode *prevNode = mNode;
        
        while(i < n)
        {
            ListNode *nextNode = pNode->next;
            
            pNode->next = prevNode;
            prevNode = pNode;;
            pNode = nextNode;
            
            i++;
        }
        
        // Find the n th node
        nNode = prevNode;
        
        if(m == 1)
        {
            head = nNode;
            mNode->next = pNode;
        }
        else
        {
            // Find the pre node before m th node
            i = 0;
            ListNode *tNode = head;
            while(i < m - 1)
            {
                mPrevNode = tNode;
                tNode = tNode->next;
                i++;
            }
            
            mPrevNode->next = nNode;
            mNode ->next = pNode;
        }
        
        return head;
    }
};
