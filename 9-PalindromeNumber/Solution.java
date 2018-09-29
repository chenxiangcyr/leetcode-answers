class Solution {
    public boolean isPalindrome(int x) {
        // 求一个数字的转置
        int reverse = 0;
        
        int original = x;
        
        while(x > 0){
            reverse = reverse * 10 + (x % 10);
            x = x / 10;
        }
        
        return reverse == original;
    }
}
