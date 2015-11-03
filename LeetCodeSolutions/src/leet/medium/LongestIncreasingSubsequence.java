package leet.medium;

import java.util.Arrays;

import norm.ArraysUtil;

/**
 * No.300 Longest Increasing Subsequence
 * Given an unsorted array of integers, find the length of longest increasing subsequence.
 */
public class LongestIncreasingSubsequence {

	public static void main(String[] args) {
		int[] nums = ArraysUtil.create(3,5,6,2,5,4,19,5,6,7,12);
		System.out.println(new LongestIncreasingSubsequence().lengthOfLIS(nums));
	}
	
	public int lengthOfLIS(int[] nums) {
        if(null == nums) {
            return 0;
        }
        if(1 >= nums.length) {
            return nums.length;
        }
        int max = 0x80000000;
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for(int i=1; i<dp.length; i++) {
            for(int j=0; j<i; j++) {
                if(nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
            max = Math.max(dp[i], max);
        }
        return max;
    }

}
