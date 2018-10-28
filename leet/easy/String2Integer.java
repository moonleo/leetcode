package leet.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * No.8 String to Integer 
 * Implement atoi to convert a string to an integer.
 */
public class String2Integer {
	public int myAtoi(String str) {
		if(null == str || str.length() <= 0) {
			return 0;
		}
        char[] array = str.toCharArray();
        int i=0;
        //去除字符串前的空格
        while(array[i] == ' ') {
            i ++;
        }
        boolean positive = true;//是否为正数
        boolean hasFlag = false;//是否已有符号位
        //为负数
        if('-' == array[i] && !hasFlag) {
        	positive = false;
        	hasFlag = true;
        	i ++;
        }
        if('+' == array[i] && !hasFlag) {
        	hasFlag = true;
        	i ++;
        }
        //去除数字之前的0
        while(array[i] == '0') {
        	i ++;
        }
        //记录所有合法的字符
        List<Integer> list = new ArrayList<Integer>();
        char c;
        while(i < array.length) {
        	c = array[i];
        	//记录下所有的数字
        	if(c >= '0' && c <= '9') {
        		list.add(c - '0');
        		i++;
        	} 
        	//遇到非法字符，跳出循环
        	else{
        		break;
        	}
        }
        long result = 0;
        long digit = 1;
        for(int j=list.size()-1; j>=0; j--) {
        	if(positive) {
        		result += list.get(j) * digit;
        		if(result > 0x7fffffff)
        			return 0x7fffffff;
        	}
        	if(!positive) {
        		result -= list.get(j) * digit;
        		if(result < 0x80000000)
        			return 0x80000000;
        	}
        	digit *= 10;
        }
		return (int)result;
    }
	
	public static void main(String[] args) {
		String2Integer trans = new String2Integer();
		System.out.println(trans.myAtoi(" -000024 00a"));
		System.out.println(trans.myAtoi("+1"));
		System.out.println(trans.myAtoi("-1"));
		System.out.println(trans.myAtoi("+-1"));
		System.out.println(trans.myAtoi("-+1"));
		System.out.println(trans.myAtoi("  -0012a42"));
		System.out.println(trans.myAtoi("2147483648"));
		System.out.println(trans.myAtoi("-2147483650"));
	}
}
