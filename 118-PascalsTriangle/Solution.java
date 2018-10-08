class Solution {
    public List<List<Integer>> generate(int numRows) {
        
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> preLevel = new ArrayList<>();
        
        // generate each level
        for(int i = 1; i <= numRows; i++) {
            List<Integer> level = new ArrayList<>();
            level.add(1);
            
            // generate each number in level
            for(int j = 1; j <= i - 2; j++) {
                level.add(preLevel.get(j - 1) + preLevel.get(j));
            }
            
            if(i > 1) {
                level.add(1);
            }
            
            preLevel = new ArrayList<>(level);
            result.add(new ArrayList<>(level));
        }
        
        return result;
    }
}
