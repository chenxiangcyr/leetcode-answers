class Solution {
    public void solveSudoku(char[][] board) {
        if(board == null || board.length == 0 || board[0].length == 0) {
            return;
        }
        
        solve(board);
    }
    
    public boolean solve(char[][] board){
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(board[i][j] == '.') {
                    // 尝试每一个数字
                    for(char c = '1'; c <= '9'; c++) {
                        if(isValid(board, i, j, c)){
                            board[i][j] = c;
                            
                            // 递归，处理下一个位置
                            if(solve(board)) {
                                return true;
                            }
                            else {
                                // 回溯 backtracking
                                board[i][j] = '.';
                            }
                        }
                    }
                    
                    return false;
                }
            }
        }
        
        return true;
    }
    
    // 把(row, col)位置设为c，判断是不是合法的数独
    private boolean isValid(char[][] board, int row, int col, char c){
        for(int i = 0; i < 9; i++) {
            // 检查第col列，不能有重复的c
            if(board[i][col] != '.' && board[i][col] == c) {
                return false;
            }
            
            // 检查第row行，不能有重复的c
            if(board[row][i] != '.' && board[row][i] == c) {
                return false;
            }
            
            // 检查对应的cube，不能有重复的c
            if(board[3 * (row / 3) + i / 3][ 3 * (col / 3) + i % 3] != '.' && 
board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c) {
                return false;
            }
        }
        
        return true;
    }
}
