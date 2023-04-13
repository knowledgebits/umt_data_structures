import java.util.*;

public class BalancedParantheses {

    public static boolean isBalanced(String expression) {
        Stack<Character> stack = new Stack<Character>();
        for(int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            if(ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            }
            else if(ch == ')' && !stack.isEmpty() && stack.peek() == '(') {
                stack.pop();
            }
            else if(ch == ']' && !stack.isEmpty() && stack.peek() == '[') {
                stack.pop();
            }
            else if(ch == '}' && !stack.isEmpty() && stack.peek() == '{') {
                stack.pop();
            }
            else {
                return false;
            }
        }
        return stack.isEmpty();
    }
    
    public static void main(String[] args) {
        String expression = "{()}[]";
        if(isBalanced(expression)) {
            System.out.println("Balanced");
        }
        else {
            System.out.println("Not Balanced");
        }
    }
}
