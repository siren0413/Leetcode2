package question;

import java.util.*;

/**
 * Created by siren0413 on 1/26/14.
 */
public class EvaluateReversePolishNotation {

    // Assume tokens are valid
    public static int evalRPN(String[] tokens) {
        if (tokens.length == 0) return 0;
        Stack<Integer> stack = new Stack<>();
        for (String s : tokens) {
            if (s.equals("+")) {
                stack.push(stack.pop() + stack.pop());
            } else if (s.equals("-")) {
                stack.push(-stack.pop() + stack.pop());
            } else if (s.equals("*")){
                stack.push(stack.pop()*stack.pop());
            }else if (s.equals("/")){
                int divisor = stack.pop();
                stack.push(stack.pop()/divisor);
            }else{
                stack.push(Integer.valueOf(s));
            }
        }
        return stack.pop();
    }


    // test
    public static void main(String[] args){
        String[] tokens = {"4","13","5","/","+"};
        System.out.println(evalRPN(tokens));
    }
}
