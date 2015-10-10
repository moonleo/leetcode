package leet.medium;

import norm.ArraysUtil;

/**
 * No.209 Minimum Size Subarray Sum
 * 
 * Given an array of n positive integers and a positive integer s, 
 * find the minimal length of a subarray of which the sum ≥ s. 
 * If there isn't one, return 0 instead. 
 * For example, given the array [2,3,1,2,4,3] and s = 7, 
 * the subarray [4,3] has the minimal length under the problem constraint.
 */
public class MinimumSizeSubarraySum {

	public static void main(String[] args) {
		int[] array = ArraysUtil.create(2,3,1,2,3,4);
		System.out.println(new MinimumSizeSubarraySum().minSubArrayLen(7, array));
	}
	
	public int minSubArrayLen(int s, int[] nums) {
        if(null == nums || 0 == nums.length) {
            return 0;
        }
        int i = 0, j = 0;
        int sum = 0;
        int min = nums.length;
        while(j < nums.length) {
        	//向右移动j，找到和比s大的位置
            while(j < nums.length && sum < s) {
                sum += nums[j];
                j ++;
            }
            //min = Math.min(min, j-i);
            //向右移动i，找到和比s小的位置
            while(i < j && sum >= s) {
                sum -= nums[i];
                i ++;
            }
            min = Math.min(min, j-i+1);
        }
        //整个数组的和都小于s时
        if(i == 0 && sum < s) {
            return 0;
        }
        return min;
    }

}
