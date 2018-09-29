class Solution {
    
    // 迭代算法
    public boolean isMatch(String text, String pattern) {
        
        // match[i][j] 表示 text[i + 1, i + 2....] 和 pattern[j + 1, j + 2....] 是否match
        boolean[][] match = new boolean[text.length() + 1][pattern.length() + 1];
        
        match[text.length()][pattern.length()] = true;
        
        for (int i = text.length(); i >= 0; i--) {
            for (int j = pattern.length() - 1; j >= 0; j--){
                boolean first_match = (i < text.length() && 
                                       (pattern.charAt(j) == text.charAt(i) ||
                                        pattern.charAt(j) == '.'));
                
                if (j + 1 < pattern.length() && pattern.charAt(j + 1) == '*') {
                    match[i][j] = match[i][j + 2] || first_match && match[i + 1][j];
                } else {
                    match[i][j] = first_match && match[i + 1][j + 1];
                }
            }
        }
        return match[0][0];
    }
    
    // 递归算法
    public boolean isMatchRecursive(String text, String pattern) {
        // 都为空
        if (text.isEmpty() && pattern.isEmpty()) return true;
        
        // pattern为空，text不为空
        if (pattern.isEmpty()) return false;
        
        // 允许存在text为空，pattern不为空的情况
        
        // 第一个字符是否匹配
        boolean first_match = (!text.isEmpty() && 
                               (pattern.charAt(0) == text.charAt(0) || pattern.charAt(0) == '.'));
        
        if (pattern.length() >= 2 && pattern.charAt(1) == '*') {
            // case1: 由于 * 的出现，之前的那个字符出现0次，比较 text 与 pattern.substring(2)
            boolean case1 = isMatch(text, pattern.substring(2));
            
            // case2: 由于 * 的出现，之前的那个字符出现多次，比较 text.substring(1) 与 pattern
            boolean case2 = first_match && isMatch(text.substring(1), pattern);
            
            return case1 || case2;
        } else {
            return first_match && isMatch(text.substring(1), pattern.substring(1));
        }
    }
}
