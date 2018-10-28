package leet.easy;

/**
 * No.28 Implement strStr() 
 * Returns the index of the first occurrence of needle in 
 * haystack, or -1 if needle is not part of haystack.
 */
public class ImplementStrstr {
	//KMP算法
	public int strStr(String haystack, String needle) {
		char[] haystackArr = haystack.toCharArray();
		char[] needleArr = needle.toCharArray();
		if(0 == needleArr.length)
		    return 0;
		if(0 == haystackArr.length)
		    return -1;
		int[] next = getNext(needle);
		int i=0, j=0;
		int index;
		while(i < haystackArr.length && j < needleArr.length) {
			if(-1 == j || haystackArr[i] == needleArr[j]) {
				i ++;
				j ++;
			} else {
				j = next[j];
			}
		}
		System.out.println("j:"+j);
		if(j >= needleArr.length)
			index = i - needleArr.length;
		else 
			index = -1;
		return index;
    }
	
	private int[] getNext(String str) {
		char[] array = str.toCharArray();
		int[] next = new int[array.length];
		next[0] = -1;
		int i = 0, k = -1;
		while(i < array.length-1) {
			if(-1 == k || array[i] == array[k]) {
				i ++;
				k ++;
				if(array[i] != array[k]) {
					next[i] = k;
				} else {
					next[i] = next[k];
				}
			} else {
				k = next[k];
			}
		}
		return next;
	}
	
	public static void main(String[] args) {
		ImplementStrstr strstr = new ImplementStrstr();
		/*int[] array = strstr.getNext("abcabaa");
		for(int i: array) {
			System.out.print(i+" ");
		}*/
		System.out.println(strstr.strStr("abcaabbabcabaacbacba", "abcabaa"));
	}
}
