package leet.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * No.205 Isomorphic Strings
 * Given two strings s and t, determine if they are isomorphic. 
 * Two strings are isomorphic if the characters in s can be replaced to get t.
 * All occurrences of a character must be replaced with another character 
 * while preserving the order of characters. No two characters may map 
 * to the same character but a character may map to itself.
 * For example, 
 * Given "egg", "add", return true. 
 * Given "foo", "bar", return false. 
 * Given "paper", "title", return true.
 */
public class IsomorphicStrings {

	public static void main(String[] args) {
		System.out.println(new IsomorphicStrings().isIsomorphic("ab", "aa"));
	}
	
	public boolean isIsomorphic(String s, String t) {
        if(null == s && null == t || s.length() == 0 && t.length() == 0) {
            return true;
        }
        if(null == s || null == t || s.length()!= t.length()) {
            return false;
        }
        return isomorphric(s, t) && isomorphric(t, s);
    }
    
    public boolean isomorphric(String s, String t) {
        Map<Character, Character> map = new HashMap<Character, Character>();
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();
        int index = 0;
        char sChar, tChar;
        while(index < sArray.length) {
            sChar = sArray[index];
            tChar = tArray[index];
            if(null == map.get(sChar)) {
                map.put(sChar, tChar);
            } else {
                if(map.get(sChar) != tChar) {
                    return false;
                }
            }
            index ++;
        }
        return true;
    }

}
