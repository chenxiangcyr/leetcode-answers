class Solution {
    public String reverseWords(String s) {
        char[] str = s.toCharArray();
        
        // reverse every word
        int left = 0;
        for(int right = 0; right < str.length; right++) {
            if(str[right] == ' ') {
                reverse(str, left, right - 1);
                left = right + 1;
            }
        }
        reverse(str, left, str.length - 1);
        
        // reverse the whole string
        reverse(str, 0, str.length - 1);
        
        // clear space
        int i = 0, j = 0;
        while (j < s.length()) {
          while (j < s.length() && str[j] == ' ') j++;             // skip spaces
          while (j < s.length() && str[j] != ' ') str[i++] = str[j++]; // keep non spaces
          while (j < s.length() && str[j] == ' ') j++;             // skip spaces
          if (j < s.length()) str[i++] = ' ';                      // keep only one space
        }
  
        return new String(str).substring(0, i);
    }
    
    public void reverse(char[] str, int left, int right) {
        
        while(left < right) {
            char t = str[left];
            str[left] = str[right];
            str[right] = t;
            
            left++;
            right--;
        }
        
    }
}
