class Solution {
    private List<List<Integer>> result = new ArrayList<List<Integer>>();
    
    private List<Integer> path = new ArrayList<Integer>();
    
    public List<List<Integer>> combine(int n, int k) {
        travel(n, k, 1);
        
        return result;
    }
    
    public void travel(int n, int k, int start) {
        if(start > n) {
            return;
        }
        
        for(int i = start; i <= n; i++) {
            path.add(i);

            if(path.size() == k) {
                result.add(new ArrayList<>(path));
            }
            else {
                // 递归，从下一个元素开始
                travel(n, k, i + 1);
            }

            // backtracking
            path.remove(path.size() - 1);
        }
    }
}
