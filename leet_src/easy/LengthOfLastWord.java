package leet.easy;

/**
 * No.58 Length of Last Word
 * Given a string s consists of upper/lower-case alphabets and 
 * empty space characters ' ', return the length of last word 
 * in the string. If the last word does not exist, return 0.
 * 
 */
public class LengthOfLastWord {
	public int lengthOfLastWord(String s) {
        if(null == s || 0 == s.length())
            return 0;
        char[] array = s.toCharArray();
        int lastIndex = array.length-1;
        int count = 0;
        //不考虑字符串后面的空格
        while(lastIndex >=0 && array[lastIndex] == ' ')
            lastIndex --;
        //最后一个单词的长度
        while(lastIndex >=0 && ' ' != array[lastIndex]) {
            lastIndex --;
            count ++;
        }
        return count;
    }
}
