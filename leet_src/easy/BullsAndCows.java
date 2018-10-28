package leet.easy;

import java.util.HashMap;
import java.util.Map;
/**
 * No.299 Bulls and Cows
 * You are playing the following Bulls and Cows game with your friend: 
 * You write a 4-digit secret number and ask your friend to guess it, 
 * each time your friend guesses a number, you give a hint, the hint 
 * tells your friend how many digits are in the correct positions (called "bulls") 
 * and how many digits are in the wrong positions (called "cows"), 
 * your friend will use those hints to find out the secret number.
 * 
 */
public class BullsAndCows {

	public static void main(String[] args) {
		System.out.println(new BullsAndCows().getHint("1122", "1222"));
	}
	
	public String getHint(String secret, String guess) {
        if(null == secret || 0 == secret.length())
            return "0A0B";
        //记录每个字符出现的次数
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for(char c: secret.toCharArray()) {
            if(null == map.get(c)) {
                map.put(c, 1);
            } else 
                map.put(c, map.get(c)+1);
        }
        int aCount = 0, bCount = 0;
        char tmp;
        Integer c;
        //记录第一趟未匹配的索引
        Map<Integer, Integer> indexs = new HashMap<Integer, Integer>();
        for(int j=0; j<guess.length(); j++) {
            tmp = guess.charAt(j);
            //完全匹配，aCount加1
            if(tmp == secret.charAt(j)) {
                c = map.get(tmp)-1;
                if(c == 0) {
                    map.remove(tmp);
                } else {
                    map.put(tmp, c);
                }
                aCount ++;
            } else {
                indexs.put(j, 1);
            }
        }
        
        for(int index: indexs.keySet()) {
            tmp = guess.charAt(index);
            c = map.get(tmp);
            if(c != null) {
                c --;
                if(c == 0) {
                    map.remove(tmp);
                } else {
                    map.put(tmp, c);
                }
                bCount ++;
            }
        }
        return aCount+"A"+bCount+"B";
    }

}
