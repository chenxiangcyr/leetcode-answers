class Solution {
    public int singleNumber(int[] nums) {
        // null pointer check
        if(nums == null) {
            return 0;
        }

        /*
        每一个int都是32位（4 bytes），遍历每一个int的每一位。
        如果某一位上是1，则count++，对于出现了三次的int，则该位上count = 3。
        因此 count = count % 3可以清除出现了三次的int，保留至出现了一次的int。
        */
        
        int result = 0;
        for(int i = 0; i < 32; i++) {
            int count = 0;
            
            for(int j = 0; j < nums.length; j++) {
                if((nums[j] & 1) == 1) {
                    count++;
                }
                nums[j] = nums[j]>>>1;
            }
            
            count = count % 3;
            
            if(count != 0) {
                result = (count << i) + result;
            }
        }

        return result;
    }
}
