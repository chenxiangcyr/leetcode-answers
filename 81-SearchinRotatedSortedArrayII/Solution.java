class Solution {
    public boolean search(int[] nums, int target) {
        return binarySearch(nums, 0, nums.length - 1, target);
    }
    
    // binary search solution
    public boolean binarySearch(int[] nums, int start, int end, int target) {
        while(start <= end) {
            int middle = (start + end) / 2;
            
            if (nums[middle] == target) {
                return true;
            }
            
            //If we know for sure left side is sorted or right side is unsorted
            if (nums[middle] > nums[start] || nums[middle] > nums[end]) {
                if (target < nums[middle] && target >= nums[start]) {
                    end = middle - 1;
                } else {
                    start = middle + 1;
                }
            }
            //If we know for sure right side is sorted or left side is unsorted
            else if (nums[middle] < nums[end] || nums[middle] < nums[start]) {
                if (target > nums[middle] && target <= nums[end]) {
                    start = middle + 1;
                } else {
                    end = middle - 1;
                }
            //If we get here, that means nums[start] == nums[mid] == nums[end], then shifting out
            //any of the two sides won't change the result but can help remove duplicate from
            //consideration, here we just use end-- but left++ works too
            } else {
                end--;
            }
        }
        
        return false;
    }
}
