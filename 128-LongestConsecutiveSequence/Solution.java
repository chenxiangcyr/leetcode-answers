class Solution {
    public int longestConsecutive(int[] nums) {
        // remove duplicates
        Set<Integer> set = new HashSet<Integer>();
        for(int i : nums) {
            set.add(i);
        }
        
        int[] new_nums = new int[set.size()];
        Iterator<Integer> it = set.iterator();  
        int idx = 0;
        while (it.hasNext()) {  
            new_nums[idx] = it.next();
            idx++;
        }
        
        // sort the array
        Arrays.sort(new_nums);
        
        int result = 0;
        int anchor = 0;
        
        for(int i = 0; i < new_nums.length; i++) {
            if(i > 0 && new_nums[i] - new_nums[i - 1] != 1) {
                anchor = i;
            }
            
            result = Math.max(result, i - anchor + 1);
        }
        
        return result;
    }
}
