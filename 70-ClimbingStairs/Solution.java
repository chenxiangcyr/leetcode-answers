class Solution {
    // Recursive solution
    /*
    public int climbStairs(int n) {
        if(n == 0) {
            return 1;
        }
        
        if(n == 1) {
            return 1;
        }
        
        return climbStairs(n - 2) + climbStairs(n - 1);
    }
    */
    
    // Iterative solution
    public int climbStairs(int n) {
        if(n == 0) {
            return 1;
        }
        
        if(n == 1) {
            return 1;
        }
        
        int result = 0;
        int r0 = 1;
        int r1 = 1;
        
        for(int i = 2; i <= n; i++) {
            result = r0 + r1;
            r0 = r1;
            r1 = result;
        }
        
        return result;
    }
}
