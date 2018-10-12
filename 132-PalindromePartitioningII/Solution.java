class Solution {
    public int minCut(String s) {
        return travel(s, 0,0, new HashMap<>());
    }
    
    public int travel(String s, int pos, int cut, Map<Integer,Integer> cache) {
        if(pos>=s.length()) {
            return cut - 1;
        }
        
        int min = Integer.MAX_VALUE;
        if(cache.containsKey(pos)) {
            return cut + cache.get(pos);
        }
        
        for(int end = pos + 1; end <= s.length(); ++end){
            String sub = s.substring(pos, end);
            
            if(isPalindrome(sub)) {
                min = Math.min(min, travel(s, end, cut+1, cache));
            }
        }
        
        cache.put(pos, min - cut);
        
        return min;
    }
    
    public boolean isPalindrome(String s) {
        int startIdx = 0;
        int endIdx = s.length() - 1;
        
        while(startIdx <= endIdx && s.charAt(startIdx) == s.charAt(endIdx)) {
            startIdx++;
            endIdx--;
        }
        
        return startIdx >= endIdx;
    }
}
