class Solution {
    public String minWindow(String s, String t) {
        if(s == null || s.length() < t.length() || s.length() == 0){
            return "";
        }
        
        /* initialize the hash map here */
        HashMap<Character,Integer> map = new HashMap<Character,Integer>();
        for(char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
         // check whether the substring is valid
        int counter = map.size();
        
        //two pointers, one point to tail and one  head
        int begin = 0, end = 0;
        
        int length = Integer.MAX_VALUE;
        int head = 0;
        
        while(end < s.length()) {
            
            /* modify counter here */
            char c = s.charAt(end);
            if(map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
                
                if(map.get(c) == 0) {
                    counter--;
                }
            }
            end++;
                      
            /* counter condition */  
            while(counter == 0) {
                
                // finding
                /* update d here if finding minimum*/
                if(end - begin < length) {
                    length = end - begin;
                    head = begin;
                }
                
                /* moving sliding window */
                /* modify counter here */
                c = s.charAt(begin);
                if(map.containsKey(c)) {
                    map.put(c, map.get(c) + 1);
                    
                    if(map.get(c) > 0){
                        counter++;
                    }
                }
                begin++;
            }
        }

        return length == Integer.MAX_VALUE ? "" : s.substring(head, head + length);
        
    }
}
