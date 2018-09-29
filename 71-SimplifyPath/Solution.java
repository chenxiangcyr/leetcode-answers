class Solution {
    public String simplifyPath(String path) {
        if(path.isEmpty()) return path;
        
        Stack<String> stack = new Stack<String>();
        
        String[] splits = path.split("/");
        
        for(String split : splits) {            
            // 上一层目录
            if(split.equals("..")) {
                if(!stack.isEmpty()) {
                    stack.pop();
                }
            }
            // 当前目录，忽略
            else if(split.equals(".")) {
                
            }
            // 空格，忽略
            else if(split.equals("")) {
                
            }
            else {
                stack.push(split);
            }
        }
        
        String res = "";
        while (!stack.isEmpty()) {
            res = "/" + stack.pop() + res;
        }
        
        return res.isEmpty() ? "/" : res;
    }
}
