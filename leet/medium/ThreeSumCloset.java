package leet.medium;

import java.util.Arrays;

/**
 * No.16 3Sum Closet
 * Given an array S of n integers, find three integers 
 * in S such that the sum is closest to a given number, 
 * target. Return the sum of the three integers. 
 * You may assume that each input would have exactly one 
 * solution.
 * For example, given array S = {-1 2 1 -4}, and target = 1.
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 */
public class ThreeSumCloset {
	
	public static void main(String[] args) {
		ThreeSumCloset closet = new ThreeSumCloset();
		int[] nums = new int[]{-1, 2, 1, -4};
		System.out.println(closet.threeSumClosest(nums, 1));
	}
	
	public int threeSumClosest(int[] nums, int target) {
		Arrays.sort(nums);
		int min = 0x7fffffff;
		int result = 0;
		for(int i=0; i<nums.length - 2; i ++) {
			int res = twoSumCloset(nums, i+1, target- nums[i]);
			if(Math.abs(res + nums[i] - target) < min) {
				min = Math.abs(res + nums[i] - target);
				result = res + nums[i];
			}
		}
		return result;
    }
	
	private int twoSumCloset(int[] nums,int start, int target) {
		int i = start, j = nums.length-1;
		int temp, diff;
		int min = 0x7fffffff;
		int result = 0;
		while(i < j) {
			temp = nums[i] + nums[j];
			diff = Math.abs(temp - target);
			if(diff < min) {
				min = diff;
				result = temp;
			}
			if(temp > target) {
				j --;
			} else {
				i ++;
			}
		}
		return result;
	}
}
