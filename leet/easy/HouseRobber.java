package leet.easy;

/**
 * No.198 House Robber
 * You are a professional robber planning to rob houses along a street. 
 * Each house has a certain amount of money stashed, the only constraint 
 * stopping you from robbing each of them is that adjacent houses have 
 * security system connected and it will automatically contact the police 
 * if two adjacent houses were broken into on the same night.
 * Given a list of non-negative integers representing the amount of money 
 * of each house, determine the maximum amount of money you can rob tonight 
 * without alerting the police.
 */
public class HouseRobber {

	public static void main(String[] args) {
		int[] nums = new int[]{2, 1};
		System.out.println(new HouseRobber().rob(nums));
	}
	
	public int rob(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }
        if(nums.length == 1) {
            return nums[0];
        }
        int n = nums.length;
        //dp[i][0]记录1~i但不包含i的最大和,dp[i][1]记录1~i且包含i的最大和
        int[][] dp = new int[n][2];
        dp[0][1] = nums[0];
        for(int i=1; i<n; i++) {
            dp[i][1] = dp[i-1][0]+nums[i];
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]);
        }
        return Math.max(dp[n-1][0], dp[n-1][1]);
    }

}
