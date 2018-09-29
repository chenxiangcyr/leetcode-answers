/**
 * Definition for binary tree
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    void recoverTree(TreeNode *root) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        stack<TreeNode*> inorder_stack;
        TreeNode *current = root, *previous = NULL, *first = NULL, *second = NULL;
        
        while (inorder_stack.empty() == false || current != NULL)
        {
            if (current)
            {
                inorder_stack.push(current);
                current = current->left;
            }
            else
            {
                current = inorder_stack.top();
                inorder_stack.pop();
                
                if (previous != NULL && current->val < previous->val) {
                    if (first == NULL)
                    {
                        first = previous;
                        second = current;
                    }
                    else
                    {
                        second = current;
                    }
                }
                previous = current;
                
                current = current->right;
            }
        }
        
        first->val = first->val ^ second->val;
        second->val = first->val ^ second->val;
        first->val = first->val ^ second->val;
    }
};
