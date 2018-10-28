package leet.easy;

/**
 * No.242 Valid Anagram
 * Given two strings s and t, write a function to 
 * determine if t is an anagram of s.
 */
public class ValidAnagram {
	public boolean isAnagram(String s, String t) {
        if(null == s || null == t)
            return false;
        if(s.length()!=t.length())
            return false;
        //用hash表记录所有字母出现次数
        int[] charArray = new int[26];
        for(char c: s.toCharArray()) {
            charArray[c-'a'] ++;
        }
        for(char c: t.toCharArray()) {
            charArray[c-'a'] --;
        }
        for(int i: charArray) {
            if(i != 0)
                return false;
        }
        return true;
    }
}
