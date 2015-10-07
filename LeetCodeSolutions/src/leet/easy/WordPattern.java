package leet.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * No.290 Word Pattern
 * Given a pattern and a string str, find if str follows the same pattern.
 * 
 */
public class WordPattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public boolean wordPattern(String pattern, String str) {
        char[] array = pattern.toCharArray();
        String[] strs = str.split("\\s+");
        if(array.length != strs.length) {
            return false;
        }
        Map<Character, String> map = new HashMap<Character, String>();
        int index = 0;
        while(index < array.length) {
            char c = array[index];
            if(null == map.get(c)) {
                if(map.containsValue(strs[index])) {
                    return false;
                }
                map.put(c, strs[index]);
            } else {
                if(!map.get(c).equals(strs[index])) {
                    return false;
                }
            }
            index ++;
        }
        return true;
    }

}
