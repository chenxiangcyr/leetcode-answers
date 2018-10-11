class Solution {
    public boolean isPalindrome(String s) {
        // we define empty string as valid palindrome
        if(s.isEmpty()) {
            return true;
        }
        
        char[] arr = s.toCharArray();
        
        int i = 0;
        int j = arr.length - 1;
        
        while(i < j) {
            Character ci = new Character(arr[i]);
            Character cj = new Character(arr[j]);
            
            // considering only alphanumeric characters
            if(!Character.isDigit(ci) && !Character.isLetter(ci)) {
                i++;
                continue;
            }
            
            if(!Character.isDigit(cj) && !Character.isLetter(cj)) {
                j--;
                continue;
            }
            
            // ignoring cases
            if(Character.toUpperCase(ci) != Character.toUpperCase(cj)) {
                return false;
            }
            
            i++;
            j--;
        }
        
        return true;
    }
}
