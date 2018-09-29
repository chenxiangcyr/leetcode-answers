class Solution {
    public int maxArea(int[] height) {
        
        /* Exceed Time Limit
        int max = 0;
        
        for(int i = 0; i < height.length - 1; i++) {
            for(int j = i + 1; j < height.length; j++) {
                int water = (j - i) * Math.min(height[i], height[j]);
                if(max <  water)
                    max = water;
            }
        }*/
        
        int max = 0;
        int i = 0;
        int j = height.length - 1;
        
        while(i < j) {
            int water = (j - i) * Math.min(height[i], height[j]);
            if(max <  water)
                max = water;
            
            if(height[i] <= height[j])
                i++;
            else
                j--;
        }
        
        return max;
    }
}
