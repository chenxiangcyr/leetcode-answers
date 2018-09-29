class Solution {
    public List<List<Integer>> permutations = new ArrayList<List<Integer>>();
    public List<Integer> permutation = new ArrayList<Integer>();
    
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        
        travel(nums, new boolean[nums.length]);
        
        return permutations;
    }
    
    public void travel(int[] nums, boolean [] visited) {
        for(int i = 0; i < nums.length; i++) {
            
            // 跳过重复的元素
            if(visited[i] || (i > 0 && nums[i] == nums[i-1] && !visited[i - 1])) {
                continue;
            }
            
            visited[i] = true;
            permutation.add(nums[i]);

            // arrive the last digit
            if(permutation.size() == nums.length) {
                permutations.add(new ArrayList(permutation));
            } else {
                travel(nums, visited);
            }

            // backtracking
            visited[i] = false;
            permutation.remove(permutation.size() - 1);
        }
    
    }
}
