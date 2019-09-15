/**
给出一个字符串 s（仅含有小写英文字母和括号）。
请你按照从括号内到外的顺序，逐层反转每对匹配括号中的字符串，并返回最终的结果。
注意，您的结果中 不应 包含任何括号。
*/

class Solution {
    public String reverseParentheses(String s) {
        Stack<StringBuilder> str = new Stack<>();
        int i = 0;
        char[] charArr = s.toCharArray();
        char c;
        while (i < charArr.length) {
            c = charArr[i];
            if (c == '(') {
                // 碰到左括号就把下一个字符入栈，如果下一个字符不是字母，就入栈一个空的StringBuilder
                if (charArr[i+1] >= 'a' && charArr[i+1] <= 'z') {
                    str.push(new StringBuilder(String.valueOf(charArr[++i])));
                } else {
                    str.push(new StringBuilder());
                }
            } else if (c == ')') {
                // 碰到右括号，就把栈顶元素取出逆序，再加到新的栈顶元素后面，如果取出的是空的StringBuilder则不用处理
                StringBuilder sb = str.pop();
                if (sb.length() != 0) {
                    if (str.isEmpty()) {
                        str.push(sb.reverse());
                    } else {
                        str.peek().append(sb.reverse());
                    }
                }
            } else {
                // 字母的添加
                if (str.isEmpty()) {
                    str.push(new StringBuilder(String.valueOf(charArr[i])));
                } else {
                    str.peek().append(charArr[i]);
                }
            }
            i ++;
        }
        return str.pop().toString();
    }
}
