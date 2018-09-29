class Solution {
    public boolean exist(char[][] board, String word) {
        if(board == null || board.length == 0 || board[0].length == 0) return false;
        if(word.isEmpty()) return true;
        
        int rows = board.length;
        int columns = board[0].length;
        char[] wordArr = word.toCharArray();
        
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < columns; j++) {
                if(board[i][j] == wordArr[0]) {
                    if(dfs(board, wordArr, i, j, rows, columns, 0)) return true;
                }
            }
        }
        
        return false;
    }
    
    public boolean dfs(char[][] board, char[] wordArr, int i, int j, int rows, int columns, int curWordIdx) {
        // 通过操作board，避免使用额外空间存储 visited 信息
        char temp = board[i][j];
        board[i][j] = '0';
        
        if(curWordIdx == wordArr.length - 1) {
            return true;
        }
        
        int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

        boolean found = false;
        
        for(int[] d : dir) {
            int ni = i + d[0];
            int nj = j + d[1];

            if(ni >= 0 && ni < rows && nj >= 0 && nj < columns && board[ni][nj] == wordArr[curWordIdx + 1]) {
                found = found || dfs(board, wordArr, ni, nj, rows, columns, curWordIdx + 1);
            }
        }
        
        // backtacking
        board[i][j] = temp;
        
        return found;
    }
}
