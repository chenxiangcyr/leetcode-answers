class Solution {
    public int longestValidParentheses(String s) {
        
        if(s == null) return 0;
        
        int maxLength = 0;
        int left = -1;
        
        // 记录每个元素的idx，stack 中缺省的 idx 即为已经匹配了的
        // 遍历 stack 中的所有gap，计算 maxLength
        Stack<Integer> st = new Stack<Integer>();
        
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') {
                st.push(i);
            }
            else {
                if(!st.isEmpty()) {
                    st.pop();
                    
                    if(st.isEmpty()) {
                        maxLength = Math.max(maxLength, i - left);
                    }
                    else {
                        maxLength = Math.max(maxLength, i - st.peek());
                    }
                } else {
                    left = i;
                }
                
            }
        }
        
        return maxLength;
    }
}
