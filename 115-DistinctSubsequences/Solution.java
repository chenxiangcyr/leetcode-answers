class Solution {
    // Refer: https://leetcode.com/problems/distinct-subsequences/discuss/37327/Easy-to-understand-DP-in-Java
    public int numDistinct(String S, String T) {
        // array creation
        int[][] mem = new int[T.length() + 1][S.length() + 1];

        // filling the first row: with 1s
        for(int j = 0; j <= S.length(); j++) {
            mem[0][j] = 1;
        }

        // the first column is 0 by default in every other rows but the first, which we need.

        for(int i = 0; i < T.length(); i++) {
            for(int j = 0; j < S.length(); j++) {
                if(T.charAt(i) == S.charAt(j)) {
                    mem[i + 1][j + 1] = mem[i][j] + mem[i + 1][j];
                } else {
                    mem[i + 1][j + 1] = mem[i + 1][j];
                }
            }
        }

        return mem[T.length()][S.length()];
    }
}
