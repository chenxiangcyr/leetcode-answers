class Solution {
    public int uniquePaths(int m, int n) {
        
        return uniquePathsIterative(m, n);
    }
    
    // DP iterative, bottom-up
    public int uniquePathsIterative(int m, int n) {
        // use space to save time
        int[][] pathCount = new int[m][n];
        
        // first column
        for(int i = 0; i < m; i++) {
            pathCount[i][0] = 1;
        }
        
        // first row
        for(int i = 0; i < n; i++) {
            pathCount[0][i] = 1;
        }
        
        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                pathCount[i][j] = pathCount[i - 1][j] + pathCount[i][j - 1];
            }
        }
        
        return pathCount[m - 1][n - 1];
    }
    
    // DP recursive, top-down - Time Limit Exceeded
    public int uniquePathsRecursive(int m, int n) {
        if(m == 1 && n == 1) {
            return 1;
        }
        
        if(m == 1) {
            return uniquePathsRecursive(m, n- 1);
        }
        
        if(n == 1) {
            return uniquePathsRecursive(m - 1, n);
        }
        
        
        return uniquePathsRecursive(m - 1, n) + uniquePathsRecursive(m, n- 1);
    }
}
