package leet.easy;

/**
 * No.67 Add Binary
 * Given two binary strings, return their sum (also a binary string). 
 */
public class AddBinary {

	public static void main(String[] args) {
		AddBinary add = new AddBinary();
		System.out.println(add.addBinary("0", "0"));
	}
	
	public String addBinary(String a, String b) {
        int length = Math.max(a.length(), b.length()) + 1;
        int[] aArray = str2Array(a, length);
        int[] bArray = str2Array(b, length);
        int[] result = new int[length];
        int carry = 0;
        int sum;
        for(int i=0; i<length; i++) {
            sum = aArray[i]+bArray[i]+carry;
            result[i] = sum % 2;
            carry = sum / 2;
        }
        int index = result.length - 1;
        while(index >= 0 && result[index] == 0) {
        	index --;
        }
        if(index < 0) {
        	return "0";
        }
        StringBuilder sBuilder = new StringBuilder();
        for(int i=0; i<index + 1; i++) {
        	sBuilder.append(result[index - i]);
        }
        return sBuilder.toString();
    }
    
	/**
	 * 将字符串转换为数组并逆序
	 * @param str 源字符串
	 * @param length 数组长度
	 * @return 逆序的数组
	 */
    public int[] str2Array(String str, int length) {
        char[] array = str.toCharArray();
        int[] result = new int[length];
        for(int i = 0; i<array.length; i++) {
            result[i] = array[array.length - i - 1] - '0';
        }
        return result;
    }

}
