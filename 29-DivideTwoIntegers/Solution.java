class Solution {
    public int divide(int dividend, int divisor) {
        if(divisor == 0) {
            return Integer.MAX_VALUE;
        }
        
        if(dividend == 0) {
            return 0;
        }
        
        // overflow
        if(dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        
        if(divisor == 1) return dividend;
        if(divisor == -1) return -dividend;
        
        boolean isPositive = true;
        
        long dividendLong = dividend;
        long divisorLong = divisor;
        
        if(dividend < 0 && divisor < 0) {
            dividendLong = -dividendLong;
            divisorLong = -divisorLong;
        }
        
        if(dividend < 0 && divisor > 0) {
            isPositive = false;
            
            dividendLong = -dividendLong;
        }
        
        if(dividend > 0 && divisor < 0) {
            isPositive = false;
            
            divisorLong = -divisorLong;
        }
        
        if(dividendLong < divisorLong) {
            return 0;
        }
        
        long sum = divisorLong;
        int multiply = 1;
        
        while((sum + sum) <= dividendLong) {
            sum = sum + sum;
            multiply = multiply + multiply;
        }
        
        return isPositive == true ? (int) (multiply + divide((int)(dividendLong - sum), (int)divisorLong)) : -(int) (multiply + divide((int)(dividendLong - sum), (int)divisorLong));
    }
}
