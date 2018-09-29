/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
struct ListNode* swapPairs(struct ListNode* head) {
    if(head == NULL || head->next == NULL) return head;
    
    struct ListNode* newH = head->next;
    
    struct ListNode* p = head;
    struct ListNode* prev = head;
    struct ListNode* next;
    while(p != NULL && p->next != NULL) {
        next = p->next;
        
        prev->next = next;
        p->next = next->next;
        next->next = p;
        
        prev = p;
        p = p->next;
    }
    
    return newH;
}
