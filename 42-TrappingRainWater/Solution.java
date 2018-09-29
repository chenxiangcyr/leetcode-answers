class Solution {
    public int trap(int[] height) {
        int ans = 0;
        int current = 0;
        
        // 存储的是idx
        Stack<Integer> st = new Stack<Integer>();
        
        while (current < height.length) {
            while (!st.isEmpty() && height[current] > height[st.peek()]) {
                int top = st.pop();
                
                if (st.empty())
                    break;
                
                int distance = current - st.peek() - 1;
                int bounded_height = Math.min(height[current], height[st.peek()]);
                
                ans += distance * (bounded_height - height[top]);
            }
            
            st.push(current);
            current++;
        }
        return ans;
    }
}
