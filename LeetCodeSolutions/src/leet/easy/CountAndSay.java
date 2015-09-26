package leet.easy;

/**
 * No.38 Count and Say
 * The count-and-say sequence is the sequence of integers beginning as follows: 
 * 1, 11, 21, 1211, 111221, ... 
 * 1 is read off as "one 1" or 11. 
 * 11 is read off as "two 1s" or 21. 
 * 21 is read off as "one 2, then one 1" or 1211.
 * Given an integer n, generate the nth sequence.
 */
public class CountAndSay {
	public static void main(String[] args) {
		System.out.println(new CountAndSay().countAndSay(5));
	}
	
	public String countAndSay(int n) {
        if(n == 1) {
            return "1";
        }
        String temp = "11";
        for(int i = 0; i < n-2; i ++) {
            temp = sayString(temp);
        }
        return temp;
    }
    
    public String sayString(String preString) {
        char[] array = preString.toCharArray();
        int index = 1;
        int count = 1;
        StringBuilder sb = new StringBuilder();
        while(index < array.length) {
            if(array[index] != array[index-1]) {
                sb.append(count).append(array[index-1]);
                count = 1;
            } else {
                count ++;
            }
            index ++;
        }
        sb.append(count).append(array[array.length-1]);
        return sb.toString();
    }
}
