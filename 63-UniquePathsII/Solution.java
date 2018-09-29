class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        
        if(obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0) {
            return 0;
        }
        
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        
        return uniquePathsWithObstaclesIterative(obstacleGrid, m, n);
    }
    
    // DP iterative, bottom-up
    public int uniquePathsWithObstaclesIterative(int[][] obstacleGrid, int m, int n) {
        // use space to save time
        int[][] pathCount = new int[m][n];
        
        // 障碍
        if(obstacleGrid[0][0] == 1) {
            pathCount[0][0] = 0;
        }
        else {
            pathCount[0][0] = 1;
        }
        
        // first column
        for(int i = 1; i < m; i++) {
            // 障碍
            if(obstacleGrid[i][0] == 1) {
                pathCount[i][0] = 0;
            }
            else {
                pathCount[i][0] = pathCount[i - 1][0];
            }
        }
        
        // first row
        for(int i = 1; i < n; i++) {
            // 障碍
            if(obstacleGrid[0][i] == 1) {
                pathCount[0][i] = 0;
            }
            else {
                pathCount[0][i] = pathCount[0][i - 1];
            }
        }
        
        
        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                // 障碍
                if(obstacleGrid[i][j] == 1) {
                    pathCount[i][j] = 0;
                }
                else {
                    pathCount[i][j] = pathCount[i - 1][j] + pathCount[i][j - 1];
                }
            }
        }
        
        return pathCount[m - 1][n - 1];
    }
}
