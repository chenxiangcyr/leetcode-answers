class Solution {
    public int candy(int[] ratings) {
        if (ratings == null || ratings.length == 0) {
            return 0;
        }
        
        // Give first child 1 candy
        int total = 1;
        int prev = 1;
        int countDown = 0;
        
        // Iterate from second child to last child
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] >= ratings[i-1]) {
                if (countDown > 0) {
                    total += countDown * (countDown + 1) / 2;
                    if (countDown >= prev) {
                        total += countDown - prev + 1;
                    }
                    
                    countDown = 0;
                    prev = 1;
                }
                
                prev = ratings[i] == ratings[i-1] ? 1 : (prev + 1);
                total += prev;
            } else {
                countDown++;
            }
        }
        
        // if we were descending at the end
        if (countDown > 0) {
            total += countDown * (countDown + 1) / 2;
            if (countDown >= prev) {
                total += countDown - prev + 1;
            }
        }
        
        return total;
    }
}
