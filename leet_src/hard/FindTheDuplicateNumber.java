package leet.hard;

import norm.ArraysUtil;

/**
 * No.287 Find the Duplicate Number
 * Given an array nums containing n + 1 integers where each integer is between 
 * 1 and n (inclusive), prove that at least one duplicate number must exist. 
 * Assume that there is only one duplicate number, find the duplicate one. 
 * 
 * Note:
 *  You must not modify the array (assume the array is read only).
 *  You must use only constant, O(1) extra space.
 *  Your runtime complexity should be less than O(n2).
 *  There is only one duplicate number in the array, but it could be repeated more than once.
 *
 */
public class FindTheDuplicateNumber {

	public static void main(String[] args) {
		int[] array = ArraysUtil.create(1,2,2);
		System.out.println(new FindTheDuplicateNumber().findDuplicate(array));
	}
	
	public int findDuplicate(int[] nums) {
        int low = 0, upper = nums.length;
        int mid;
        while(low < upper) {
            mid = (low + upper) >> 1;//中值
        	//若小于等于中值的数的个数大于中值
            if(count(nums, mid) > mid) {
                upper = mid;
            } else {
                low  = mid + 1;
            }
        }
        return low;
    }
    
	/**
	 * 计算数组中小于等于指定值的数的个数
	 */
    private int count(int[] nums, int target) {
        int count = 0;
        for(int i: nums) {
            if(i <= target) {
                count ++;
            }
        }
        return count;
    }

}
