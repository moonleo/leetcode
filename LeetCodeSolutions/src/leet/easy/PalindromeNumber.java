package leet.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * No.9 Palindrome Number
 * Determine whether an integer is a palindrome. 
 * Do this without extra space.
 */
public class PalindromeNumber {
	public boolean isPalindrome(int x) {
		//负数不是回文
        if(x < 0)
            return false;
        //记录每个数字
        List<Integer> list = new ArrayList<Integer>();
        while(x != 0) {
            list.add(x%10);
            x = x / 10;
        }
        if(1 >= list.size())
            return true;
        //一头一尾两个索引判断是否为回文
        int i=0, j=list.size()-1;
        while(i < j) {
            if(list.get(i) != list.get(j))
                return false;
            i ++;
            j --;
        }
        return true;
    }
}
