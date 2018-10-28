package leet.medium;

import java.util.Stack;

/**
 * No.224 Basic Calculator
 * Implement a basic calculator to evaluate a simple expression string. 
 * The expression string may contain open ( and closing parentheses ), 
 * the plus + or minus sign -, non-negative integers and empty spaces .
 */
public class BasicCalculator {

	public static void main(String[] args) {
		System.out.println(new BasicCalculator().calculate(" 2-1 + 2 "));
	}
	
	public int calculate(String s) {
        if(null == s || s.trim().length() == 0) {
            return 0;
        }
        Stack<Character> op = new Stack<Character>();
        char[] str = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        int i = 0;
        char c;
        while(i < str.length) {
            c = str[i];
            if(c != ' ') {
                if(c == '(') {
                    op.push(c);
                } else if(c == ')') {
                    char t;
                    while((t = op.peek()) != '(') {
                        sb.append(t);
                        op.pop();
                    }
                    op.pop();
                } else if(c == '-' || c == '+') {
                    char t;
                    while(!op.isEmpty() && (t = op.peek()) != '(') {
                        sb.append(t);
                        op.pop();
                    }
                    op.push(c);
                } else {
                    char t = c;
                    while(i < str.length) {
                        t = str[i];
                        if(t >= '0' && t <= '9') {
	                        sb.append(t);
	                        i ++;
                        } else {
                        	break;
                        }
                    }
                    sb.append('#');
                    continue;
                }
            }
            i ++;
        }
        while(!op.isEmpty()) {
        	sb.append(op.pop());
        }
        return calPostExp(sb.toString());
    }
    
    private int calPostExp(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        char[] array = s.toCharArray();
        int i = 0, j = 0;
        char c;
        while(i < array.length) {
            c = array[i];
            if(c != '#') {
	            if(c == '-') {
	                int a = stack.pop();
	                int b = stack.pop();
	                stack.push(b - a);
	            } else if(c == '+') {
	                int a = stack.pop();
	                int b = stack.pop();
	                stack.push(a + b);
	            } else {
	            	j = i+1;
	                while(j < array.length) {
	                	if(array[j] > '9' || array[j] < '0') 
	                		break;
	                	j ++;
	                }
	                stack.push(Integer.parseInt(s.substring(i, j)));
	                i = j;
	                continue;
	            }
            }
            i ++;
        }
        return stack.pop();
    }

}
