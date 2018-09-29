class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        
        /*
        cost[i][j] 表示 将 word1 的前 i 个字符转换为 word2 的前 j 个字符的距离
        0...i-1 <-> 0...j-1
        */
        int[][] cost = new int[m + 1][n + 1];
        for(int i = 0; i <= m; i++) {
            cost[i][0] = i;
        }
        
        for(int i = 1; i <= n; i++) {
            cost[0][i] = i;
        }
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                // 相同字符
                if(word1.charAt(i) == word2.charAt(j)) {
                    cost[i + 1][j + 1] = cost[i][j];
                }
                else {
                    // 更新word1[i]或者更新word2[j]
                    int case1 = cost[i][j];
                    
                    // 在word2[j]插入一个字符，使得其等于word1[i]，或者删除word1[i]
                    int case2 = cost[i][j + 1];
                    
                    // 在word1[i]插入一个字符，使得其等于word2[j]，或者删除word2[j]
                    int case3 = cost[i + 1][j];
                    
                    int min = Math.min(case1, case2);
                    min = Math.min(min, case3);
                    
                    // DP
                    cost[i + 1][j + 1] = min + 1;
                }
            }
        }
        
        return cost[m][n];
        
    }
}
