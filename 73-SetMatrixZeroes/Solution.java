class Solution {
    public void setZeroes(int[][] matrix) {
        int rows = matrix.length;
        if(rows == 0) return;
        
        int columns = matrix[0].length;
        if(columns == 0) return;
        
        // first rows elements represent rows flag, last columns elements represent columns flag
        int[] flag = new int[rows + columns];
        // initialize to 1
        for(int i = 0; i < rows + columns; i++) {
            flag[i] = 1;
        }
        
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < columns; j++) {
                if(matrix[i][j] == 0) {
                    flag[i] = 0;
                    flag[rows + j] = 0;
                }
            }
        }
        
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < columns; j++) {
                if(flag[i] == 0 || flag[rows + j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
