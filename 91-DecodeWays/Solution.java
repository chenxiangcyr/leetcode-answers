class Solution {
    public int numDecodings(String s) {
        if(s == null || s.length() == 0) return 0;
        
        char[] digits = s.toCharArray();
        
        // ways[i] is the decoding ways when arriving i - 1
        int[] ways = new int[digits.length + 1];
        
        // init
        ways[0] = 1;
        ways[1] = digits[0] == '0' ? 0 : 1;
            
        // DP Iterative
        for(int i = 2; i <= digits.length; i++) {
            int cur_digit = digits[i - 1] - '0';
            int prev_digit = digits[i - 2] - '0';
            int sum = prev_digit * 10 + cur_digit;
            
            if(cur_digit >= 1 && cur_digit <= 9) {
               ways[i] = ways[i-1];  
            }
            
            if(sum >= 10 && sum <= 26) {
                ways[i] = ways[i] + ways[i-2];
            }
        }
        
        return ways[digits.length];
    }
}
