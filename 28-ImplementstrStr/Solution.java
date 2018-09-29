class Solution {
    public int strStr(String haystack, String needle) {
        if(needle.isEmpty()) {
            return 0;
        }
        
        // KMP algorithm
        int[] next = new int[needle.length()];
        next[0] = 0;
        
        int k;
        for(int i = 1; i < needle.length(); i++) {
            // Compute next[i]
            k = next[i - 1];

            while(needle.charAt(k) != needle.charAt(i) && k > 0) {
                k = next[k - 1];
            }

            if(needle.charAt(k) == needle.charAt(i)) {
                next[i] = k + 1;
            }
            else {
                next[i] = 0;
            }
        }
        
        
        int i =0;
        int j = 0;
        
        while(i < haystack.length() && j < needle.length()) {
            
            if(haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            }
            else {
                // Naive algorithm
                /*
                i = i - j + 1;
                j = 0;
                */
                
                // KMP algorithm
                if(j == 0) {
                    i++;
                }
                else {
                    j = next[j - 1];   
                }
            }
        }
        
        if(j == needle.length()) {
            return i - j;
        }
        
        return -1;
    }
}
