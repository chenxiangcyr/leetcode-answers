class Solution {
    public int lengthOfLastWord(String s) {
        
        if(s.isEmpty()) return 0;
        
        s = s.trim();
        
        int indexOfLastSpace = -1;
        
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == ' ') {
                indexOfLastSpace = i;
            }
        }
        
        return s.length() - indexOfLastSpace - 1;
    }
}
