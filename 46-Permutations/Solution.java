class Solution {
    public List<List<Integer>> permutations = new ArrayList<List<Integer>>();
    public List<Integer> permutation = new ArrayList<Integer>();
    
    public List<List<Integer>> permute(int[] nums) {
        travel(nums);
        
        return permutations;
    }
    
    public void travel(int[] nums) {
        for(int i = 0; i < nums.length; i++) {
            if(!permutation.contains(nums[i])) {
                permutation.add(nums[i]);
                
                // arrive the last digit
                if(permutation.size() == nums.length) {
                    permutations.add(new ArrayList(permutation));
                } else {
                    travel(nums);
                }
                
                // backtracking
                permutation.remove(permutation.size() - 1);
            }
        }
    
    }
}
