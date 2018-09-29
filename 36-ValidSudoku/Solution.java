class Solution {
    public boolean isValidSudoku(char[][] board) {
        int n = board.length;
        
        for(int i = 0; i < n; i++) {
            Set<Character> rows = new HashSet<Character>();
            Set<Character> columns = new HashSet<Character>();
            Set<Character> cubes = new HashSet<Character>();
            
            for(int j = 0; j < n; j++) {
                if(board[i][j] != '.') {
                    // check each row
                    if(rows.contains(board[i][j])) {
                        return false;
                    }
                    else {
                        rows.add(board[i][j]);
                    }
                }
                
                if(board[j][i] != '.') {
                    // check each column
                    if(columns.contains(board[j][i])) {
                        return false;
                    }
                    else {
                        columns.add(board[j][i]);
                    }
                }
                
                int rowIdx = 3 * (i / 3);
                int columnIdx = 3 * (i % 3);
                if(board[rowIdx + j / 3][columnIdx + j % 3] != '.') {
                    // check each cube
                    if(cubes.contains(board[rowIdx + j / 3][columnIdx + j % 3])) {
                        return false;
                    }
                    else {
                        cubes.add(board[rowIdx + j / 3][columnIdx + j % 3]);
                    }
                }
            }
        }
        
        return true;
    }
}
