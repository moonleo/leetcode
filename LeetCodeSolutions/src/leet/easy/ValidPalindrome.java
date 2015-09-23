package leet.easy;

/**
 * No.125 Valid Palindrome
 * Given a string, determine if it is a palindrome, considering only alphanumeric 
 * characters and ignoring cases. For example, 
 * "A man, a plan, a canal: Panama" is a palindrome. 
 * "race a car" is not a palindrome. 
 */
public class ValidPalindrome {

	public static void main(String[] args) {
		System.out.println(new ValidPalindrome().isPalindrome("A man, a plan, a canal: Panama"));
	}
	
	public boolean isPalindrome(String s) {
        if(null == s || 0 == s.length())
            return true;
        char[] array = s.toCharArray();
        int i = 0;
        int j = array.length-1;
        int diff = 'A' - 'a';
        while(i < j) {
            while(i < j && 
                !(array[i]>='a'&&array[i]<='z' 
                    || array[i]>='A'&&array[i]<='Z' 
                        || array[i]>='0'&&array[i]<='9'))
                i ++;
            while(i< j && 
                !(array[j]>='a'&&array[j]<='z' 
                    || array[j]>='A'&&array[j]<='Z' 
                        || array[j]>='0'&&array[j]<='9'))
                j --;
            if(array[i] == array[j] ||
                array[i] + diff == array[j] ||
                array[i] - diff == array[j]) {
                    i ++;
                    j --;
            } else {
                return false;
            }
        }
        return true;
    }

}
