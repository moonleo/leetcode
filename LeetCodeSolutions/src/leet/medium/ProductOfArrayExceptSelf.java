package leet.medium;

/**
 * No.238 Product of Array Except Self 
 * Given an array of n integers where n > 1, nums, 
 * return an array output such that output[i] is 
 * equal to the product of all the elements of nums 
 * except nums[i]
 * Solve it without division and in O(n).
 */
public class ProductOfArrayExceptSelf {
	
	public int[] productExceptSelf(int[] nums) {
		int[] array = new int[nums.length];//保存结果
		//array[i] = nums[0]*num[1]*……*nums[i-1]*nums[i+1]*……*nums[nums.length-1]
		//分解
		//array[i] = B[i]*C[i];
		//B[i] = nums[0]*num[1]*……*nums[i-1] 且B[i] = B[i-1]*nums[i-1]
		//C[i] = nums[i+1]*……*nums[nums.length-1] 且C[i] = C[i+1]*nums[i+1];
		array[0] = 1;
		
		for (int i = 1; i < nums.length; i++) {
			array[i] = nums[i - 1] * array[i - 1];
		}
		
		int temp = 1;
		for (int j = nums.length - 2; j >= 0; j--) {
			temp = nums[j + 1] * temp;
			array[j] = array[j] * temp;
		}
		return array;
	}
}
