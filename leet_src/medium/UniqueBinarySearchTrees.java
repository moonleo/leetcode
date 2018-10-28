package leet.medium;

/**
 * No.96 Unique Binary Search Trees
 * Given n, how many structurally unique BST's (binary search trees) that store values 1...n? 
 * For example, 
 * Given n = 3, there are a total of 5 unique BST's.
 */
public class UniqueBinarySearchTrees {

	public static void main(String[] args) {
		System.out.println(new UniqueBinarySearchTrees().numTrees(3));
	}
	
	public int numTrees(int n) {
        if(1 >= n) {
            return n;
        }
        int[] dp = new int[n+2];
        dp[1] = 1;
        int sum;
        for(int i=2; i<=n+1; i++) {
            sum = 0;
            for(int j=1; j<i; j++) {
                sum += dp[j]*dp[i-j];
            }
            dp[i] = sum;
        }
        return dp[n+1];
    }

}
