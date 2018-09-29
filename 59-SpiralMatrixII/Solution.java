class Solution {
    public int[][] generateMatrix(int n) {
        
        int[][] matrix = new int[n][n];
        
        int row = 0;
        int col = 0;
        
        // 以此分别是right,bottom,left,up
        int dIdx = 0;
        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};
        
        int count = 1;
        while(count <= n * n) {
            matrix[row][col] = count;
            count++;
            
            int nRow = row + dr[dIdx];
            int nCol = col + dc[dIdx];
            
            if(nRow < 0 || nRow >= n || nCol < 0 || nCol >= n || matrix[nRow][nCol] != 0) {
                dIdx = (dIdx + 1) % 4;
                
                row = row + dr[dIdx];
                col = col + dc[dIdx];
            } else {
                row = nRow;
                col = nCol;
            }
        }
        
        return matrix;
    }
}
