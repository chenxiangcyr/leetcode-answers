class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        
        /* initialize the hash map here */
        HashMap<Character,Integer> map = new HashMap<Character,Integer>();
        
        // check whether the substring is valid
        int counter = 0;
        
        //two pointers, one point to tail and one  head
        int begin = 0, end = 0;
        
        int length = Integer.MIN_VALUE;
        
        while(end < s.length()) {
            /* modify counter here */
            char c = s.charAt(end);
            map.put(c, map.getOrDefault(c, 0) + 1);
            if(map.get(c) > 1) {
                counter++;
            }
            end++;
            
            /* counter condition */  
            while(counter > 0) {
                /* moving sliding window */
                /* modify counter here */
                c = s.charAt(begin);
                map.put(c, map.get(c) - 1);
                if(map.get(c) > 0) {
                    counter--;
                }
                begin++;
            }
            
            /* update d here if finding maximum*/
            if(end - begin > length) {
                length = end - begin;
            }
        }
        
        return length;
    }
    
    public int lengthOfLongestSubstringRecursive(String s) {
        // the default value is zero
        int[] position = new int[256];
        Arrays.fill(position, -1);
        
        // convert String to char array
        char[] arr = s.toCharArray();
        
        int max_length = 0;
        
        int start_idx = -1;
        
        for(int i = 0; i < arr.length; i++) {
            if(position[arr[i]] > start_idx) {
                start_idx = position[arr[i]];
            }
            
            position[arr[i]] = i;
            
            max_length = Math.max(max_length, i - start_idx);
        }
        
        return max_length;
    }
}
