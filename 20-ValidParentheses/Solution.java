class Solution {
    public boolean isValid(String s) {
        char[] arr = s.toCharArray();
        
        Stack<Character> stack = new Stack<Character>();
        for(char c : arr) {
            if(c == '(') {
                stack.push(c);
            }
            else if(c == ')') {
                if(stack.isEmpty()) {
                    return false;
                }
                if(stack.peek() == '(') {
                    stack.pop();
                } else {
                    return false;
                }
            }
            
            else if(c == '{') {
                stack.push(c);
            }
            else if(c == '}') {
                if(stack.isEmpty()) {
                    return false;
                }
                if(stack.peek() == '{') {
                    stack.pop();
                } else {
                    return false;
                }
            }
            
            else if(c == '[') {
                stack.push(c);
            }
            else if(c == ']') {
                if(stack.isEmpty()) {
                    return false;
                }
                if(stack.peek() == '[') {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        
        return stack.isEmpty();
    }
}
