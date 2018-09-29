class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // key: a string to represent the feature of a anagram
        // value: a list to contain all String which has the same feature
        Map<String, List> map = new HashMap<String, List>();
        
        int[] count = new int[26];
        for(String str : strs) {
            // generate the key: a string to represent the feature of a anagram
            Arrays.fill(count, 0);
            for(char c : str.toCharArray()) {
                count[c - 'a']++;
            }
            
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < 26; i++) {
                sb.append("#");
                sb.append(count[i]);
            }
            
            String key = sb.toString();
            if(!map.containsKey(key)) {
                map.put(key, new ArrayList());
            }
            
            map.get(key).add(str);
        }
        
        return new ArrayList(map.values());
    }
}
