package leet.easy;

import java.util.Stack;

/**
 * No.20 Valid Parentheses
 * Given a string containing just the characters '(', 
 * ')', '{', '}', '[' and ']', determine if the input 
 * string is valid.
 */
public class ValidParentheses {

	public static void main(String[] args) {
		System.out.println(new ValidParentheses().isValid("()[]{}"));
		System.out.println(new ValidParentheses().isValid("([]"));
	}
	
	public boolean isValid(String s) {
		char[] array = s.toCharArray();
		Stack<Character> stack = new Stack<Character>();
		for(char c: array) {
			if(c == ')') {
				if(stack.size() > 0 && stack.pop() == '(') {
					continue;
				} else {
					return false;
				}
			} else if(c == ']') {
				if(stack.size() > 0 && stack.pop() == '[') {
					continue;
				} else {
					return false;
				}
			} else if(c == '}') {
				if(stack.size() > 0 && stack.pop() == '{') {
					continue;
				} else {
					return false;
				}
			} else {
				stack.push(c);
			}
		}
        return stack.empty() ? true : false;
    }

}
