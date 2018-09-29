class Solution {
    public List<String> result = new ArrayList<String>();
    public StringBuilder sb = new StringBuilder();
    public Map<Character, List<Character>> map = new HashMap<>();
    
    public List<String> letterCombinations(String digits) {
        map.put('2', Arrays.asList('a', 'b', 'c'));
        map.put('3', Arrays.asList('d', 'e', 'f'));
        map.put('4', Arrays.asList('g', 'h', 'i'));
        map.put('5', Arrays.asList('j', 'k', 'l'));
        map.put('6', Arrays.asList('m', 'n', 'o'));
        map.put('7', Arrays.asList('p', 'q', 'r', 's'));
        map.put('8', Arrays.asList('t', 'u', 'v'));
        map.put('9', Arrays.asList('w', 'x', 'y', 'z'));
        
        if(!digits.isEmpty()) {
            travel(digits.toCharArray(), 0);
        }
        
        return result;
    }
    
    public void travel(char[] digitsArr, int curIdx) {
        List<Character> letters = map.get(digitsArr[curIdx]);
        
        for(Character c : letters) {
            sb.append(c);
        
            // arrive the last digit
            if(curIdx == digitsArr.length - 1) {
                result.add(sb.toString());
            } else {
                travel(digitsArr, curIdx + 1);
            }
            
            // backtracking
            sb.delete(sb.length() - 1, sb.length());
        }
    }
}
