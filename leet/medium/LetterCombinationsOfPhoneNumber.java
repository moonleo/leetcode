package leet.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * No.17 Letter Combinations of a Phone Number
 * Given a digit string, return all possible letter combinations 
 * that the number could represent. 
 * Input:Digit string "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * your answer could be in any order you want.
 */
public class LetterCombinationsOfPhoneNumber {
	Map<Character, String> dic;
	{
		dic = new HashMap<Character, String>();
        dic.put('2', "abc");
        dic.put('3', "def");
        dic.put('4', "ghi");
        dic.put('5', "jkl");
        dic.put('6', "mno");
        dic.put('7', "pqrs");
        dic.put('8', "tuv");
        dic.put('9', "wxyz");
	}
	
	/*
	 * 用迭代的方法得到字母的组合
	 */
	public List<String> letterCombinations(String digits) {
        char[] digitsArray = digits.toCharArray();
        //记录数字对应字符串的列表
        List<String> charArrayList = new ArrayList<String>();
        for(char c: digitsArray) {
            charArrayList.add(dic.get(c));
        }
        //迭代列表
        List<String> list = new ArrayList<String>();
        for(String str: charArrayList) {
            list = iteratorComb(list, str);
        }
        return list;
    }
    
	/**
	 * 将字符串中的每个字符与列表中每个字符串组合形成新的列表
	 * @param list 存放字符串的列表
	 * @param string 字符串
	 * @return 组合形成的新列表
	 */
    public List<String> iteratorComb(List<String> list, String string) {
        List<String> result = new ArrayList<String>();
        if(0 == list.size()) {
            for(char c: string.toCharArray()) {
                result.add(c + "");
            }
        } else {
            char[] array = string.toCharArray();
            for(String str: list) {
                for(char c: array) {
                    result.add(str+c);
                }
            }
        }
        return result;
    }
    
    public static void main(String[] args) {
		LetterCombinationsOfPhoneNumber lcop = new LetterCombinationsOfPhoneNumber();
		List<String> list = lcop.letterCombinations("23");
		for(String str: list) {
			System.out.println(str);
		}
	}
}
