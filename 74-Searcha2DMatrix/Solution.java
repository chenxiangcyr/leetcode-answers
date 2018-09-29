class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        int low = 0;
        int high = m * n - 1;
        
        while (low < high){
            int mid = (low + high) / 2;
            
            if (matrix[mid / n][mid % n] < target) {
                low = mid + 1;
            }
            else {
                high = mid;
            }
        }
        
        return matrix[high / n][high % n] == target;
    }
    
    public boolean searchMatrixOriginal(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        // 使用二分法查找属于哪一行
        int lowRow = 0;
        int highRow = m - 1;
        while(lowRow < highRow) {
            int midRow = (lowRow + highRow) / 2;
            
            // 使用每一行的最后一个元素进行比较
            if(matrix[midRow][n - 1] == target) {
                return true;
            }
            else if(matrix[midRow][n - 1] > target) {
                highRow = midRow;
            }
            else {
                lowRow = midRow + 1;
            }
        }
        
        // 使用二分法查找属于哪一列
        int lowColumn = 0;
        int highColumn = n - 1;
        while(lowColumn <= highColumn) {
            int midColumn = (lowColumn + highColumn) / 2;
            
            // 使用每一行的最后一个元素进行比较
            if(matrix[lowRow][midColumn] == target) {
                return true;
            }
            else if(matrix[lowRow][midColumn] > target) {
                highColumn = midColumn - 1;
            }
            else {
                lowColumn = midColumn + 1;
            }
        }
        
        return false;
    }
}
