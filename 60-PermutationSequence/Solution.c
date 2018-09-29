class Solution {
public:
    string getPermutation(int n, int k) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        vector<int> num;
        for(int i = 1; i <= n; i++)
            num.push_back(i);
        
        int count = 1;
        
        if(k == 1)
        {
            string ret;
            for(int i = 0; i < num.size(); i++)
            {
                char t[256];
                sprintf(t, "%d", num[i]);

                ret = ret + t;
            }
            
            return ret;
        }
        
        while(nextPermutation(num))
        {
            count++;
            if(count == k)
            {
                string ret;
                for(int i = 0; i < num.size(); i++)
                {
                    char t[256];
                    sprintf(t, "%d", num[i]);

                    ret = ret + t;
                }
                
                return ret;
            }
        }
    }
    
    bool nextPermutation(vector<int> &num) {
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
        
        return true;
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
