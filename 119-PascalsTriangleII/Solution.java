class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> preLevel = new ArrayList<>();
        
        // generate each level
        for(int i = 0; i <= rowIndex + 1; i++) {
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
        }
        
        return preLevel;
    }
}
