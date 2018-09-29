class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<Integer>();
        
        if(matrix == null) return result;
        if(matrix.length == 0) return result;
        if(matrix[0].length == 0) return result;
        
        int rows = matrix.length;
        int columns = matrix[0].length;
        
        int startRow = 0;
        int endRow = rows - 1;
        
        int startColumn = 0;
        int endColumn = columns - 1;
        
        while(startRow <= endRow && startColumn <= endColumn) {
            // left -> right
            for(int i = startColumn; i <= endColumn; i++) {
                result.add(matrix[startRow][i]);
            }
            // top -> bottom
            for(int i = startRow + 1; i <= endRow; i++) {
                result.add(matrix[i][endColumn]);
            }
            
            if(startRow < endRow) {
                // right -> left
                for(int i = endColumn - 1; i >= startColumn; i--) {
                    result.add(matrix[endRow][i]);
                }
            }
            
            if(startColumn < endColumn) {
                // bottom -> top
                for(int i = endRow - 1; i >= startRow + 1; i--) {
                    result.add(matrix[i][startColumn]);
                }
            }
            
            startRow++;
            endRow--;
            startColumn++;
            endColumn--;
        }
        
        return result;
    }
}
