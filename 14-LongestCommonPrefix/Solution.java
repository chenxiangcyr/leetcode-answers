class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) {
            return "";
        }
        
        int minLength = Integer.MAX_VALUE;
        for(String str : strs) {
            if(minLength > str.length()) {
                minLength = str.length();
            }
        }
        
        StringBuilder sb = new StringBuilder();
                
        for(int i = 0; i < minLength; i++) {
            char c = strs[0].charAt(i);
            
            int j = 1;
            for(j = 1; j < strs.length; j++) {
                String str = strs[j];
                
                if(str.charAt(i) != c) {
                    break;
                }
            }
            
            if(j == strs.length) {
                sb.append(c);
            } else {
                break;
            }
        }
        
        return sb.toString();
    }
}
