class Solution {
public:
    void nextPermutation(vector<int> &num) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        
        // find the firse descending element
        int i;
        for(i = num.size() - 2; i>=0; i--)
        {
            if(num[i] < num[i + 1])
                break;
        }
        
        // find the first element which is larger than num[i]
        int j;
        if(i >= 0)
        {
            for(j = num.size() - 1; j>=0; j--)
            {
                if(num[j] > num[i])
                    break;
            }
            
            swap(num[i], num[j]);
        }
        
        i++;
        j = num.size() - 1;
        while(j > i)
        {
            swap(num[i], num[j]);
            i++;
            j--;
        }
    }
    
    void swap(int& n1, int& n2)
    {
        if(n1 == n2)
            return ;
        n1 = n1 ^ n2;
        n2 = n1 ^ n2;
        n1 = n1 ^ n2;
    }
};
