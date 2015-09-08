package leet.hard;

/**
 * No.32 Longest Valid Parentheses
 * Given a string containing just the characters '(' and ')', 
 * find the length of the longest valid (well-formed) parentheses 
 * substring. For "(()", the longest valid parentheses substring is 
 * "()", which has length = 2. Another example is ")()())", where 
 * the longest valid parentheses substring is "()()", which has length = 4. 
 */
public class LongestValidParentheses {

	public static void main(String[] args) {
		System.out.println(new LongestValidParentheses().longestValidParentheses(")(((((()())()()))()(()))("));
	}
	
	public int longestValidParentheses(String s) {
        int length = s.length();
        if(0 == length) {
            return 0;
        }
        //记录最长括号匹配数，array[i]表示从i到length-1范围内的最长括号匹配数
        int[] array = new int[length];
        char[] chars = s.toCharArray();
        array[length - 1] = 0;
        int i = length - 2;
        int j;
        int max = 0;//计算过程中的最长匹配数
        while(i >= 0) {
            if(chars[i] == '(') {
                j = i+array[i+1]+1;//j为i+1匹配到的最后一个')'
                if(j < chars.length && chars[j] == ')') {
                    array[i] = array[i+1]+2;
                    //还要匹配i+1匹配到的最后一个')'之后的所有匹配到的括号数
                    if(j + 1 < chars.length && array[j + 1] != 0) {
                    	array[i] = array[i] + array[j + 1];
                    }
                    if(max < array[i]) {
                        max = array[i];
                    }
                } else {
                    array[i] = 0;
                }
            }
            i --;
        }
        /*System.out.println("array:");
        for(int p: array) {
        	System.out.print(p+" ");
        }*/
        return max;
    }

}
