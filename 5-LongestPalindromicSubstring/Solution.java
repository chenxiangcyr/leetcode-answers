class Solution {
    public String longestPalindrome(String s) {
        return longestPalindromeManacher(s);
    }
    
    // DP Solution
    public String longestPalindromeDP(String s) {
        if(s.isEmpty()) return "";
        
        int n = s.length();
        String result = null;
    
        // dp[i][j] 表示第i个字符到第j个字符是否为回文
        boolean[][] dp = new boolean[n][n];
    
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i + 1][j - 1]);
            
                if (dp[i][j] && (result == null || j - i + 1 > result.length())) {
                    result = s.substring(i, j + 1);
                }
            }
        }
    
        return result;
    }
    
    // 中心检测法
    public String longestPalindromeCenter(String s) {
        int start = 0, end = 0;
        
        for (int i = 0; i < s.length(); i++) {
            /*
            一个回文字符串可以从中心向两边扩展，会有 2n - 1 个中心，而不是 n 个中心。
            因为中心可以存在于两个字符中间，例如 abba，中心在b和b中间。
            */
            
            // 以第i个字符为中心向两边扩展
            int len1 = expandAroundCenter(s, i, i);
            
            // 以第i个字符和第i+1个字符的中间为中心向两边扩展
            int len2 = expandAroundCenter(s, i, i + 1);
            
            int len = Math.max(len1, len2);
            
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        
        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        
        return R - L - 1;
    }
    
    // Manacher's Algorithm 马拉车算法
    public String longestPalindromeManacher(String s) {
        if (s.length() <= 1) {
            return s;
        }
        
        // 解决字符串长度奇偶问题
        StringBuilder stringBuilder = new StringBuilder("$");
        for (char c : s.toCharArray()) {
            stringBuilder.append("#");
            stringBuilder.append(c);
        }
        stringBuilder.append("#");
        String str = stringBuilder.toString();

        int id = 0;
        int idMax = 0;
        int index = 0;
        int maxLength = 0;

        int p[] = new int[str.length()];

        // 遍历每一个字符
        for (int curr = 1; curr < str.length(); curr++) {
            // j 是 curr 关于 id 的对称点
            int j = 2 * id - curr;
            
            // 如果 idMax > curr，那么P[curr] >= MIN(P[j], idMax - curr)
            if (idMax > curr) {
                if (p[j] < idMax - curr)
                    p[curr] = p[j];
                else
                    p[curr] = idMax - curr;
            } else {
                p[curr] = 1;
            }
            
            while (curr + p[curr] < str.length() && str.charAt(curr + p[curr]) == str.charAt(curr - p[curr])) {
                p[curr]++;
            }

            if (curr + p[curr] > idMax) {
                id = curr;
                idMax = curr + p[curr];
            }

            if (p[curr] > maxLength) {
                maxLength = p[curr];
                index = curr;
            }
        }
        
        return s.substring((index - maxLength) / 2, (index + maxLength) / 2 - 1);
    }
}
