package leet.medium;

/**
 * No.43 Multiply Strings
 * Given two numbers represented as strings, return multiplication 
 * of the numbers as a string. 
 * Note: The numbers can be arbitrarily large and are non-negativ
 *
 */
public class MultiplyStrings {

	public static void main(String[] args) {
		MultiplyStrings multiplyStrings = new MultiplyStrings();
		String result = multiplyStrings.multiply("12321", "1");
		System.out.println(result);
	}

	public String multiply(String num1, String num2) {
		if (num1.equals("0") || num2.equals("0")) {
			return "0";
		}
		int[] nums1Array = str2IntArray(num1);
		int[] nums2Array = str2IntArray(num2);
		int[] result = new int[nums1Array.length + nums2Array.length];
		int j;
		for (int i = 0; i < result.length; i++) {
			j = 0;
			while (j < nums1Array.length) {
				if (i - j >= 0 && i - j < nums2Array.length) {
					result[i] += nums1Array[j] * nums2Array[i - j];
				}
				j++;
			}
		}
		int carry = 0;
		int temp;
		for (int i = 0; i < result.length; i++) {
			temp = result[i] + carry;
			result[i] = temp % 10;
			carry = temp / 10;
		}
		int length = result[result.length - 1] == 0 ? 1 : 0;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < result.length - length; i++) {
			sb.append(result[result.length - length - i - 1]);
		}
		return sb.toString();
	}

	public int[] str2IntArray(String str) {
		char[] array = str.toCharArray();
		int[] result = new int[array.length];
		for (int i = 0; i < array.length; i++) {
			result[i] = array[array.length - i - 1] - '0';
		}
		return result;
	}

}
