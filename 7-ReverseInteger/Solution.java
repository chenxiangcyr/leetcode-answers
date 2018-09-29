class Solution {
    public int reverse(int x) {
        
        long result = 0;
        
        while(true) {
            result = result * 10 + x % 10;
            
            x = x / 10;
            
            if(x == 0) {
                break;
            }
        }
        
        // returns 0 when the reversed integer overflows
        if(result < Integer.MIN_VALUE || result > Integer.MAX_VALUE) {
            return 0;
        }
        
        return (int)result;
    }
}
