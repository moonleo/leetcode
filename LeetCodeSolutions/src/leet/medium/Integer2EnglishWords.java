package leet.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * No.273 Integer to English Words
 * Convert a non-negative integer to its english words representation. 
 * Given input is guaranteed to be less than 2^31 - 1.
 */
public class Integer2EnglishWords {

	public static void main(String[] args) {
		System.out.println(new Integer2EnglishWords().numberToWords(0));
		System.out.println(new Integer2EnglishWords().numberToWords(1));
		System.out.println(new Integer2EnglishWords().numberToWords(1000));
		System.out.println(new Integer2EnglishWords().numberToWords(1001));
		System.out.println(new Integer2EnglishWords().numberToWords(1234567));
		System.out.println(new Integer2EnglishWords().numberToWords(1234));
		System.out.println(new Integer2EnglishWords().numberToWords(1000004));
		System.out.println(new Integer2EnglishWords().numberToWords(1234567891));
	}
	
	Map<Character, String> unitMap = new HashMap<Character, String>(); 
    Map<Character, String> oneTenMap = new HashMap<Character, String>();
    Map<Character, String> tenMap = new HashMap<Character, String>();
    Map<Integer, String> unit = new HashMap<Integer, String>();
    {
        unitMap.put('1', "One");  oneTenMap.put('0', "Ten");
        unitMap.put('2', "Two");  oneTenMap.put('1', "Eleven");  
        unitMap.put('3', "Three");  oneTenMap.put('2', "Twelve");
        unitMap.put('4', "Four");  oneTenMap.put('3', "Thirteen");
        unitMap.put('5', "Five");  oneTenMap.put('4', "Fourteen");
        unitMap.put('6', "Six");  oneTenMap.put('5', "Fifteen");
        unitMap.put('7', "Seven");  oneTenMap.put('6', "Sixteen");
        unitMap.put('8', "Eight");  oneTenMap.put('7', "Seventeen");
        unitMap.put('9', "Nine");  oneTenMap.put('8', "Eighteen");    
        							oneTenMap.put('9', "Nineteen");
        tenMap.put('2', "Twenty"); 
        tenMap.put('3', "Thirty"); 
        tenMap.put('4', "Forty"); 
        tenMap.put('5', "Fifty");
        tenMap.put('6', "Sixty");
        tenMap.put('7', "Seventy");
        tenMap.put('8', "Eighty");
        tenMap.put('9', "Ninety");
        
        unit.put(2, "Thousand");
        unit.put(3, "Million");
        unit.put(4, "Billion");
    }
    public String numberToWords(int num) {
    	if(0 == num) {
    		return "Zero";
    	}
        String str = String.valueOf(num);
        int index = str.length();
        int start;
        List<String> list = new ArrayList<String>();
        //三个一组分成字符串进行解析
        while(index > 0) {
            start = index-3>=0?(index-3):0;
            list.add(parseString(str.substring(start, index)));
            index -= 3;
        }
        StringBuilder sb = new StringBuilder();
        int size = list.size();
        index = size-1;
        while(index >= 0) {
            sb.append(list.get(index));
            if(size > 1 && !list.get(index).equals("")) {
            	sb.append(" ").append(unit.get(size));
            }
            size --;
            index --;
            if(index > -1 && !list.get(index).equals("")) {
            	sb.append(" ");
            }
        }
        return sb.toString();
    }
    
    public String parseString(String str) {
        StringBuilder sb = new StringBuilder();
        char[] array = str.toCharArray();
        if(2 < array.length) {
            if(array[0] != '0') {
                sb.append(unitMap.get(array[0])+" Hundred");
            }
        }
        if(1 < array.length) {
            if(array[array.length-2]!='0') {
            	if(sb.length()!=0) {
            		sb.append(" ");
            	}
                if(array[array.length-2] > '1') {
                    sb.append(tenMap.get(array[array.length-2]));
                    if(array[array.length-1] > '0') {
                        sb.append(" ").append(unitMap.get(array[array.length-1]));
                    }
                } else {
                    sb.append(oneTenMap.get(array[array.length-1]));
                }
                return sb.toString();
            } else {
            	if(array[array.length-1]!='0') {
            		if(sb.length() != 0) {
            			sb.append(" ");
            		}
            		sb.append(unitMap.get(array[array.length-1]));
            	}
            	
            }
        }
        if(array.length == 1) {
            sb.append(unitMap.get(array[array.length-1]));
        }
        return sb.toString();
    }

}
