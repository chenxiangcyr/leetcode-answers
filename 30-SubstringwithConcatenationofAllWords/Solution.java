class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        
        List<Integer> result = new ArrayList<>();
        
        // 记录字典中每一个单词出现的次数
        Map<String, Integer> wordsMap = new HashMap<>();
        for(String word : words) {
            wordsMap.put(word, wordsMap.getOrDefault(word, 0) + 1);
        }
        
        int stringLength = s.length();
        int wordsCount = words.length;
        int wordsLength = words[0].length();
        
        // 遍历每一个字符
        for(int i = 0; i < stringLength - wordsCount * wordsLength + 1; i++) {
            
            // 记录字典中每一个单词被访问的次数
            Map<String, Integer> seenMap = new HashMap<>();
            
            int j = 0;
            
            while(j < wordsCount) {
                
                String subStr = s.substring(i + j * wordsLength, i + (j + 1) * wordsLength);
                
                // 字典中包含这个单词
                if(wordsMap.containsKey(subStr)) {
                    seenMap.put(subStr, seenMap.getOrDefault(subStr, 0) + 1);

                    // 次数超了
                    if(seenMap.get(subStr) > wordsMap.get(subStr)) {
                        break;
                    }
                }
                // 字典中不包含这个单词，换到下一个位置 i
                else {
                    break;
                }
                
                j++;
            }
            
            // 所有的单词都出现了
            if(j == wordsCount) {
                result.add(i);
            }
        }
        
        return result;
    }
}
