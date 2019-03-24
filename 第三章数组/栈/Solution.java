
import java.util.Stack;
// letcode 20 java
public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty() == true) {
                    return false;
                }
                char topchar = stack.pop();
                if (c == ')' && topchar != '(') {
                    return false;
                }
                if (c == '}' && topchar != '{') {
                    return false;
                }
                if (c == ']' && topchar != '[') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

}
