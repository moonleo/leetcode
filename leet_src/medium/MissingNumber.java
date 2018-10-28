package leet.medium;

/**
 * No.268 Missing Number
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, 
 * find the one that is missing from the array. 
 * For example, Given nums = [0, 1, 3] return 2.
 * Note: 
 * Your algorithm should run in linear runtime complexity. 
 * Could you implement it using only constant extra space complexity?
 */
public class MissingNumber {

	public static void main(String[] args) {

	}
	
	public int missingNumber(int[] nums) {
        if(0 == nums.length) {
            return 0;
        }
        for(int i=0; i<nums.length; i++) {
            while(i != nums[i] && nums[i] >=0 && nums[i] < nums.length) {
                swap(nums, i, nums[i]);
            }
        }
        for(int i=0; i<nums.length; i++) {
            if(i != nums[i]) {
                return i;
            }
        }
        return nums.length;
    }
    
    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

}
