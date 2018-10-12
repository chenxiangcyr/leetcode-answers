class Solution {
    public int singleNumber(int[] nums) {
        // null pointer check
        if(nums == null) {
            return 0;
        }
        
        int result = 0;
        for(int i : nums) {
            result = result ^ i;
        }
        
        return result;
    }
}
