class Solution {
    public int firstMissingPositive(int[] nums) {
        if(nums.length == 0) return 1;
        
        /*
        基本思想：遍历每一个元素，将 位置 i 的元素 nums[i] 移动到位置 nums[i]
        例如，3，4，2，1 遍历后为 4, 1, 2, 3
        */
        int i = 0;
        while (i < nums.length) {
            // swap: 将 位置 i 的元素 nums[i] 移动到位置 nums[i]
            if (nums[i] >= 0 && nums[i] < nums.length && nums[nums[i]] != nums[i]) {
                swap(nums, i, nums[i]);
            }
            else {
                i++;
            }
        }
        
        /*
        再次遍历数组，找到第一个位置不寻常的元素
        */
        int k = 1;
        while (k < nums.length && nums[k] == k) {
		    k++;
        }
        
        if (k < nums.length) {
		    return k;
        }
	    else {
		    return nums[0] == k ? k + 1 : k;
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
