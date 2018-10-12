class Solution {
    public int evalRPN(String[] tokens) {
        
        Stack<Integer> stack = new Stack<Integer>();
        
        for(String s : tokens) {
            // add
            if(s.equals("+")) {
                int operand1 = stack.pop();
                int operand2 = stack.pop();
                
                stack.push(operand2 + operand1);
            }
            
            // minus
            else if(s.equals("-")) {
                int operand1 = stack.pop();
                int operand2 = stack.pop();
                
                stack.push(operand2 - operand1);
            }
            
            // multiply
            else if(s.equals("*")) {
                int operand1 = stack.pop();
                int operand2 = stack.pop();
                
                stack.push(operand2 * operand1);
            }
            
            // divid
            else if(s.equals("/")) {
                int operand1 = stack.pop();
                int operand2 = stack.pop();
                
                stack.push(operand2 / operand1);
            }
            
            // digit
            else {
                stack.push(Integer.valueOf(s));
            }
        }
        
        return stack.pop();
    }
}
