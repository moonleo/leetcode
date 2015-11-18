package leet.easy;

/**
 * No.303 Range Sum Query - Immutable
 * Given an integer array nums, find the sum of the elements between 
 * indices i and j (i ≤ j), inclusive.
 */
public class RangeSumQueryImmutable {
	private int[] dp;
    public RangeSumQueryImmutable(int[] nums) {
        dp = new int[nums.length+1];
        dp[0] = 0;
        for(int i=0; i<nums.length; i++) {
            dp[i+1] = dp[i]+nums[i];
        }
    }

    public int sumRange(int i, int j) {
        return dp[j+1]-dp[i];
    }
}
