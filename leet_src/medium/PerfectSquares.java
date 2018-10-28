package leet.medium;

/**
 * No.279 Perfect Squares
 *  Given a positive integer n, find the least number of perfect square numbers 
 *  (for example, 1, 4, 9, 16, ...) which sum to n. For example, given n = 12, 
 *  return 3 because 12 = 4 + 4 + 4; given n = 13, return 2 because 13 = 4 + 9. 
 */
public class PerfectSquares {

	public static void main(String[] args) {
		System.out.println(new PerfectSquares().numSquares(12));
	}
	
	public int numSquares(int n) {
		int[] dp = new int[n + 1];
		for(int i=1; i<dp.length; i++) {
			dp[i] = 0x7fffffff;
		}
		dp[1] = 1;
		for(int i = 2; i*i <= n; i ++) {
			dp[i * i] = 1;
		}
		for(int i = 1; i <= n; i ++) {
			for(int j = 1; i + j * j <= n; j++) {
				dp[i + j * j] = Math.min(dp[i]+1, dp[i + j * j]);
			}
		}
		return dp[n];
    }

}
