class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> numStack = new Stack();
        
        for (String token: tokens) {
            if (token.equals("+") || token.equals("-") 
                || token.equals("*") || token.equals("/")) {
                
                int num2 = numStack.pop();
                int num1 = numStack.pop();
                
                if (token.equals("+")) {
                    numStack.push(num1 + num2);
                    
                } else if (token.equals("-")) {
                    numStack.push(num1 - num2);
                    
                } else if (token.equals("*")) {
                    numStack.push(num1 * num2);
                    
                } else if (token.equals("/")) {
                    numStack.push(num1 / num2);
                }
            } else {
                numStack.push(Integer.parseInt(token));
            }
        }
        
        return numStack.pop();
    }
}
