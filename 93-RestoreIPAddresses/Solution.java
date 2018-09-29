class Solution {
    List<String> result = new ArrayList<String>();
    
    List<Integer> path = new ArrayList<Integer>();
    
    public List<String> restoreIpAddresses(String s) {
        
        travel(s, 0);
        
        return result;
    }
    
    public void travel(String s, int startIdx) {
        
        // 每一部分最多3位，例如1，11，111
        for(int length = 1; length <= 3 && startIdx + length <= s.length(); length++) {
            
            String subStr = s.substring(startIdx, startIdx + length);
            int sub = Integer.parseInt(subStr);
            
            // 不能以0开始，例如00，01
            if(subStr.startsWith("0") && !subStr.equals("0")) {
                continue;
            }
            
            // 必须是有效的数字 0~255
            if(sub >=0 && sub <= 255) {
                path.add(sub);
                
                // 已经分成了4部分
                if(path.size() == 4) {
                    // 到达最后一个数字
                    if(startIdx + length == s.length()) {
                        String line = "";
                        for(int i = 0; i < 3; i++) {
                            line = line + path.get(i) + ".";
                        }

                        line = line + path.get(3);

                        result.add(line);
                    }
                }
                else {
                    // 递归到下一个部分
                    travel(s, startIdx + length);
                }
                
                // backtracking 回溯
                path.remove(path.size() - 1);
            }
            
        }
        
    }
}
