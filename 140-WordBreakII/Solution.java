class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        // dp[i] 存储的是位置i之前所有可能的字符串
        LinkedList<String>[] dp = new LinkedList[s.length() + 1];
        
        LinkedList<String> initial = new LinkedList<>();
        initial.add("");
        
        dp[0] = initial;
        
        for (int i = 1; i <= s.length(); i++) {
            LinkedList<String> list = new LinkedList<>();
            
            for (int j = 0; j < i; j++) {
                // dp[j].size() > 0表示位置j是合理的
                if (dp[j].size() > 0 && wordDict.contains(s.substring(j, i))) {
                    for (String l : dp[j]) {
                        list.add(l + (l.equals("") ? "" : " ") + s.substring(j, i));
                    }
                }
            }
            
            dp[i] = list;
        }
        
        return dp[s.length()];
    }
}
