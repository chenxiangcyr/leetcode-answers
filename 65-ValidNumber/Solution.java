class Solution {
    public boolean isNumber(String s) {
        if(s == null) return false;
        
        s = s.replace("e+", "e");
        s = s.replace("e-", "e");
        
        boolean hasNumber = false;
        
        boolean hasSign = false;
        
        boolean hasE = false;
        boolean hasNumberAfterE = false;
        
        boolean hasDot = false;
        
        boolean hasSpace = false;
        
        for(char c : s.toCharArray()) {
            if((c >= '0' && c <= '9')) {
                // 如果空格之前有数字或者dot或者sign，则空格之后不能再有数字或者dot，即不能出现1 2的情况
                if(hasSpace == true) {
                    return false;
                }
                
                hasNumber = true;
                
                if(hasE == true) hasNumberAfterE = true;
            }
            
            else if(c == '+' || c == '-') {
                // +或者-不能出现多次
                if(hasSign == true) {
                    return false;
                }
                
                // +或者-不能出现在数字，dot，e之后
                if(hasNumber == true || hasDot == true || hasE == true) {
                    return false;
                }
                
                hasSign = true;
            }
            
            else if(c == ' ') {
                // 如果空格之前有数字或者dot或者sign，则空格之后不能再有数字或者dot，即不能出现1 2的情况
                if(hasNumber == true || hasDot == true || hasSign == true) {
                    hasSpace = true;
                }
            }
            
            else if(c == 'e') {
                // e之前必须出现数字
                if(hasNumber == false) {
                    return false;
                }
                
                // e不能出现多次
                if(hasE == true) {
                    return false;
                }
                
                hasE = true;
            }
            
            else if(c == '.') {
                // 如果空格之前有数字或者dot或者sign，则空格之后不能再有数字或者dot，即不能出现1 2的情况
                if(hasSpace == true) {
                    return false;
                }
                
                // dot不能出现多次
                if(hasDot == true) {
                    return false;
                }
                
                // dot不能出现在e之后
                if(hasE == true) {
                    return false;
                }
                
                hasDot = true;
            }
            
            else {
                return false;
            }
        }
        
        if(hasE == true) return hasNumberAfterE;
        
        return hasNumber;
    }
}
