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
    vector<TreeNode *> generateTrees(int n) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        vector<TreeNode *> trees;
        
        dfs(1, n, trees);
        
        return trees;
    }
    
    void dfs(int start, int end, vector<TreeNode *> &trees)
    {
        if(start > end)
        {
            trees.push_back(NULL);
        }
        else
        {
            for(int i = start; i <= end; i++)
            {
                vector<TreeNode *> left_trees;
                vector<TreeNode *> right_trees;
                
                dfs(start, i - 1, left_trees);
                dfs(i + 1, end, right_trees);
                
                for(int m = 0; m < left_trees.size(); m++)
                {
                    for(int k = 0; k < right_trees.size(); k++)
                    {
                        TreeNode *root = new TreeNode(i);
                        root->left = left_trees[m];
                        root->right = right_trees[k];
                        
                        trees.push_back(root);
                    }
                }
            }
        }
    }
};
