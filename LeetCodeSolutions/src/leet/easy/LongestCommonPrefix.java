package leet.easy;

/**
 * No.14 Longest Common Prefix
 * Write a function to find the longest common prefix string 
 * amongst an array of strings. 
 */
public class LongestCommonPrefix {
	public String longestCommonPrefix(String[] strs) {
        if(0 >= strs.length) {
            return "";
        }
        return commonPrefix(strs, 0, strs.length-1);
    }
    
    private String commonPrefix(String[] strs, int start, int end) {
        if(start == end) {
            return strs[start];
        }
        if(start == end - 1) {
            return commonPrefix(strs[start], strs[end]);
        }
        int mid = (start + end)/2;
        String left = commonPrefix(strs, start, mid);
        String right = commonPrefix(strs, mid+1, end);
        return commonPrefix(left, right);
    }
    
    /**
     * 获取两个字符串的公共前缀
     */
    private String commonPrefix(String str1, String str2) {
        if("" == str1 || "" == str2)
            return "";
        char[] array1 = str1.toCharArray();
        char[] array2 = str2.toCharArray();
        int i=0, j=0;
        while(i<array1.length && j<array2.length) {
            if(array1[i] == array2[j]) {
                i ++;
                j ++;
            } else {
                break;
            }
        }
        if(0 == i) {
            return "";
        } else {
            return new String(array1, 0, i);
        }
    }
	
	
	public static void main(String[] args) {
		LongestCommonPrefix prefix = new LongestCommonPrefix();
		String[] strs = new String[]{"abcdefg","abef","abcfgr","abcrj","abcgh","abc"};
		String[] strs2 = new String[]{};
		System.out.println(prefix.longestCommonPrefix(strs));
		System.out.println(prefix.longestCommonPrefix(strs2));
		
		/*char[] a = new char[]{'a','b','c','d','e'};
		System.out.println(new String(a, 0, 3));*/
	}
}
