package leet.easy;

/**
 * No.172 Factorial Trailing Zeroes
 * Given an integer n, return the number of trailing zeroes in n!. 
 * Note: Your solution should be in logarithmic time complexity.
 */
public class FactorialTrailingZeroes {

	public static void main(String[] args) {
		System.out.println(new FactorialTrailingZeroes().trailingZeroes(1808548329));
	}
	
	public int trailingZeroes(int n) {
        if(n < 5) {
            return 0;
        }
        long i = 5;
        int count = 0;
        while(i <= n) {
            count += n/i;
            i *= 5;
        }
        return count;
    }

}
