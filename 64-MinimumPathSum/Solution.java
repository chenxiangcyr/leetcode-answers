class Solution {
    public int minPathSum(int[][] grid) {
        if(grid == null || grid.length == 0 ||  grid[0].length == 0)
            return 0;
        
        int rows = grid.length;
        int columns = grid[0].length;
            
        // DP solution
        
        // sum[i][j] is the min sum when arriving position (i, j)
        int[][] sum = new int[rows][columns];
        
        sum[0][0] = grid[0][0];
        
        // first row
        for(int i = 1; i < columns; i++) {
            sum[0][i] = sum[0][i - 1] + grid[0][i];
        }
        
        // first column
        for(int i = 1; i < rows; i++) {
            sum[i][0] = sum[i - 1][0] + grid[i][0];
        }
        
        for(int i = 1; i < rows; i++) {
            for(int j = 1; j < columns; j++) {
                
                // case 1: from top sum[i - 1][j]
                // case 2: from left sum[i][j - 1]
                sum[i][j] = Math.min(sum[i - 1][j], sum[i][j - 1]) + grid[i][j];
            }
        }
        
        return sum[rows - 1][columns - 1];
    }
}
