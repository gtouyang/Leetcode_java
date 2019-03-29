/*
Question:

Evaluate the value of an arithmetic expression in Reverse Polish Notation.
Valid operators are+,-,*,/. Each operand may be an integer or another expression.

*/

import java.util.*;

public class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<Integer>();
        int len = tokens.length;
        for(int i = 0; i < len; i++){
            if(tokens[i].equals("+")){
                int t1 = stack.pop();
                int t2 = stack.pop();
                stack.push(t2+t1);
            }else if(tokens[i].equals("-")){
                int t1 = stack.pop();
                int t2 = stack.pop();
                stack.push(t2-t1);
            }else if(tokens[i].equals("*")){
                int t1 = stack.pop();
                int t2 = stack.pop();
                stack.push(t2*t1);
            }else if(tokens[i].equals("/")){
                int t1 = stack.pop();
                int t2 = stack.pop();
                stack.push(t2/t1);
            }else{
                stack.push(Integer.parseInt(tokens[i]));
            }
        }
        return stack.pop();
    }
}