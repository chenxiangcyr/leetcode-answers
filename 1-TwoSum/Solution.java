ass Solution {
    public int[] twoSum(int[] nums, int target) {
        // key: integer, value: the idx for the integer
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for(int i = 0; i < nums.length; i++) {
            int rest = target - nums[i];
            
            if(map.containsKey(rest)) {
                return new int[] {i, map.get(rest)};
            }
            
            map.put(nums[i], i);
        }
        
        throw new IllegalArgumentException("no result for the input");
    }
}
