class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // BFS 广度优先搜索
        Set<String> reached = new HashSet<String>();
        
        // 第一层的单词列表
        int distance = 1;
        reached.add(beginWord);
        
        while (!reached.contains(endWord)) {
            Set<String> toAdd = new HashSet<String>();
            
            for (String each : reached) {
                for (int i = 0; i < each.length(); i++) {
                    // 每次更改一个字符，找到只相差一个字符的所有word
                    char[] chars = each.toCharArray();
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        chars[i] = ch;
                        
                        String word = new String(chars);
                        if (wordList.contains(word)) {
                            toAdd.add(word);
                            
                            // 删除，起到了标记visited作用
                            wordList.remove(word);
                        }
                    }
                }
            }
            
            // 新的一层
            distance++;
            
            // 没有更多的word了
            if (toAdd.size() == 0) return 0;
            
            reached = toAdd;
        }
        
        return distance;
    }
}
