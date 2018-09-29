class Solution {
public:
    int numTrees(int n) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        
        int number = 1;
        
        for (int i = 1; i <= n; ++i)
        {
            number = number * 2 * (2*i - 1) / (i+1);
        }
        
        return number;
    }
};
