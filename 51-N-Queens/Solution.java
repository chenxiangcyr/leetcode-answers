class Solution {
    private List<List<String>> result = new ArrayList<>();
    
    public List<List<String>> solveNQueens(int n) {
        // 定义一个棋盘，1代表皇后，0代表空格
        int[][] board = new int[n][n];
        
        // 从第一行开始
        travel(board, n, 0);
        
        return result;
    }
    
    // 在第rowIdx行放置皇后
    public void travel(int[][] board, int n, int rowIdx) {
        
        // 遍历每一个可以使用的位置
        for(int colIdx = 0; colIdx < n; colIdx++) {
            if(isValidPosition(board, n, rowIdx, colIdx)) {
                
                // 放置皇后
                board[rowIdx][colIdx] = 1;
                
                // 到达最后一行，加入结果集
                if(rowIdx == n - 1) {
                    
                    List<String> oneSolution = new ArrayList<>();
                    
                    for(int i = 0; i < n; i++) {
                        StringBuilder sb = new StringBuilder();
                        
                        for(int j = 0; j < n; j++) {
                            if(board[i][j] == 1) {
                                sb.append("Q");
                            } else {
                                sb.append(".");
                            }
                        }
                        
                        oneSolution.add(sb.toString());
                    }
                    
                    result.add(oneSolution);
                    
                }
                // 递归到下一行
                else {
                    travel(board, n, rowIdx + 1);
                }

                // backtracking 回溯
                board[rowIdx][colIdx] = 0;
            }
        }
    }
    
    // 判断在(rowIdx, colIdx) 是否可以放置皇后
    public boolean isValidPosition(int[][] board, int n, int rowIdx, int colIdx) {
        
        // 在垂直方向上已经有皇后了
        for(int i = 0; i < rowIdx; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == 1) {
                    // 在同一列上有皇后了
                    if(j == colIdx) return false;
                    
                    // 写对角斜线上有皇后了
                    if(Math.abs(rowIdx - i) == Math.abs(colIdx - j)) return false;
                }
            }
        }
        
        return true;
    }
}
