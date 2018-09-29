class Solution {
    public String addBinary(String a, String b) {
        if(a.isEmpty()) return b;
        if(b.isEmpty()) return a;
        
        // 记录进位
        int increment = 0;
        
        int i = a.length() - 1;
        int j = b.length() - 1;
        
        StringBuilder sb = new StringBuilder();
        
        while(i >= 0 || j >=0) {
            int digitA = (i >= 0 ? (a.charAt(i) - '0') : 0);
            int digitB = (j >= 0 ? (b.charAt(j) - '0') : 0);
            
            int sum = digitA + digitB + increment;
            
            sb.append(sum % 2);
            
            // 处理进位
            increment = sum / 2;
            
            i--;
            j--;
        }
        
        if(increment == 1) {
            sb.append(1);
        }
        
        return sb.reverse().toString();
    }
}
