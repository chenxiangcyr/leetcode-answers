class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        return wordBreakIterative(s, wordDict);
    }
    
    // DP Iterative
    public boolean wordBreakIterative(String s, List<String> wordDict) {
        if(s == null || s.length() == 0) return false;
        
        // isValid[i] contains true/false when visiting element i
        boolean[] isValid = new boolean[s.length()];
        Arrays.fill(isValid, false);
        
        // init
        isValid[0] = wordDict.contains(s.substring(0, 1));
        
        for(int i = 1; i < s.length(); i++) {
            for(int j = i; j >=0; j--) {
                String subString = s.substring(j, i + 1);
                if(wordDict.contains(subString)) {
                    if(j == 0 || isValid[j - 1])
                        isValid[i] = true;
                }
            }
        }
        
        return isValid[isValid.length - 1];
    }
    
    
    // DP Recursive: Time Limit Exceeded 
    public boolean wordBreakRecursive(String s, List<String> wordDict, int startIdx) {
        if(startIdx >= s.length()) {
            return true;
        }
        
        for(int i = startIdx + 1; i <= s.length(); i++) {
            String subString = s.substring(startIdx, i);
            if(wordDict.contains(subString)) {
                if(wordBreakRecursive(s, wordDict, i)) {
                    return true;
                }
            }
        }
        
        return false;
    }
}
