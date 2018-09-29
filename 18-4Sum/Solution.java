public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        // 排序
        Arrays.sort(nums);
        
        // 转换为 k Sum 的问题
        return kSum(nums, target, 4, 0, nums.length);
    }

    // 转换为 k Sum 的问题
    private ArrayList<List<Integer>> kSum(int[] nums, int target, int k, int startIndex, int len) {
        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
        
        if(startIndex >= len) {
            return res;
        }
        
        // 2 Sum 问题
        if(k == 2) {
            int low_idx = startIndex;
            int high_idx = len - 1;
            while(low_idx < high_idx) {
                // 找到
                if(nums[low_idx] + nums[high_idx] == target) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[low_idx]);
                    temp.add(nums[high_idx]);
                    res.add(temp);
                    
                    // 避免重复数字
                    low_idx++;
                    while(low_idx < high_idx && nums[low_idx] == nums[low_idx - 1]) {
                        low_idx++;
                    }
                    
                    // 避免重复数字
                    high_idx--;
                    while(low_idx < high_idx && nums[high_idx] == nums[high_idx + 1]) {
                        high_idx--;
                    }
                }
                else if (nums[low_idx] + nums[high_idx] < target) {
                    low_idx++;
                }
                else {
                    high_idx--;
                }
            }
        }
        
        else {
            for (int i = startIndex; i < len - k + 1; i++) {
                // 递归为 k - 1 Sum 的问题
                ArrayList<List<Integer>> temp = kSum(nums, target - nums[i], k - 1, i + 1, len);
                if(temp != null) {
                    // 聚合 k - 1 Sum 的问题的结果
                    for (List<Integer> t : temp) {
                        t.add(0, nums[i]);
                    }
                    
                    res.addAll(temp);
                }
                
                // 避免重复数字
                while (i < len - k + 1 && nums[i] == nums[i + 1]) {
                    i++;
                }
            }
        }
        
        return res;
    }
}
