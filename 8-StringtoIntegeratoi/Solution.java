class Solution {
    public int myAtoi(String str) {
        // convert String to char array
        char[] arr = str.toCharArray();
        
        boolean isNegative = false;
        int result = 0;
        boolean isDigitStart = false;
        boolean hasSign = false;
        
        // iterate from left to right
        for (char c : arr) {
            // digit
            if(c >= '0' && c <= '9') {
                isDigitStart = true;
                
                int v = c - '0';
                
                // If the correct value is out of the range of representable values, INT_MAX (2147483647) or INT_MIN (-2147483648) is returned.
                if(isNegative == true) {
                    if((long) (-(long)result * 10 - v) < Integer.MIN_VALUE) {
                        return Integer.MIN_VALUE;
                    }
                }
                else {
                    if((long)((long)result * 10 + v) > Integer.MAX_VALUE) {
                        return Integer.MAX_VALUE;
                    }
                }
                
                result = result * 10 + v;
            }
            // non-digit
            else {
                // The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.
                if(isDigitStart == true) {
                    break;
                }
                else {
                    // first discards as many whitespace characters as necessary until the first non-whitespace character is found
                    if(c == ' ') {
                        if(hasSign == true) {
                            return 0;
                        }

                        continue;
                    }

                    // takes an optional initial plus or minus sign
                    if(c == '-') {
                        if(hasSign == true) {
                            return 0;
                        }

                        isNegative = true;
                        hasSign = true;
                        continue;
                    }

                    if(c == '+') {
                        if(hasSign == true) {
                            return 0;
                        }

                        hasSign = true;
                        continue;
                    }
                    
                    // If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.
                    return 0;
                }
            }
        }
        
        // If no valid conversion could be performed, a zero value is returned.
        if(isDigitStart == false) {
            return 0;
        }
        
        if(isNegative) {
            return 0 - result;
        }
        else {
            return result;
        }
        
    }
}
