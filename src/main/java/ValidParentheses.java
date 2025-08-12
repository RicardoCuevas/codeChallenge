import java.util.Stack;

//https://leetcode.com/problems/valid-parentheses/description/
public class ValidParentheses {
    public static void main(String[] args) {
        String s1 = "([)]";
        String s2 = "()";
        String s3 = "()[]{}";
        String s4 = "(]";
        System.out.println(isValid(s1));
        System.out.println(isValid1(s1));
        System.out.println(isValid(s2));
        System.out.println(isValid1(s2));
        System.out.println(isValid(s3));
        System.out.println(isValid1(s3));
        System.out.println(isValid(s4));
        System.out.println(isValid1(s4));

    }

    public static boolean isValid(String s){
        if(s.length()%2!=0) return false;
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()){
            if(c=='{'){
                stack.push('}');
            }
            else if(c=='('){
                stack.push(')');
            }
            else if(c=='['){
                stack.push(']');
            }
            else {
                if(stack.isEmpty() || stack.pop()!=c){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static boolean isValid1(String s){
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<s.length(); i++){
            char car = s.charAt(i);
            if(car=='(' || car=='[' || car=='{'){
                stack.push(car);
            }
            else if(!stack.isEmpty() && car==')' && stack.peek()=='('){
                stack.pop();
            }
            else if(!stack.isEmpty() && car==']' && stack.peek()=='['){
                stack.pop();
            }
            else if(!stack.isEmpty() && car=='}' && stack.peek()=='{'){
                stack.pop();
            }
            else {
                return false;
            }
        }
        return stack.isEmpty();
    }
}

/**
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * An input string is valid if:
 *
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Every close bracket has a corresponding open bracket of the same type.
 *
 *
 * Example 1:
 *
 * Input: s = "()"
 *
 * Output: true
 *
 * Example 2:
 *
 * Input: s = "()[]{}"
 *
 * Output: true
 *
 * Example 3:
 *
 * Input: s = "(]"
 *
 * Output: false
 *
 * Example 4:
 *
 * Input: s = "([])"
 *
 * Output: true
 *
 * Example 5:
 *
 * Input: s = "([)]"
 *
 * Output: false
 *
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 104
 * s consists of parentheses only '()[]{}'.
 */