package leet.medium;

import java.util.Stack;

/**
 * No.7 Reverse Integer
 * Reverse digits of an integer.
 *
 */
public class ReverseInteger {
	public int reverse(long x) {
		if (x >= Integer.MAX_VALUE || x <= Integer.MIN_VALUE) {
			
			return 0;
		}
		boolean isPositive = x < 0 ? false : true;
		x = isPositive ? x : 0 - x;
		Stack<Integer> stack = new Stack<Integer>();
		while (x != 0) {
			stack.push((int) x % 10);
			x = x / 10;
		}
		int decimal = 0;
		int result = 0;
		while (!stack.empty()) {
			result += stack.pop() * Math.pow(10, decimal);
			if(result >= Integer.MAX_VALUE)
				return 0;
			decimal++;
		}
		return isPositive ? result : 0 - result;
	}

	public static void main(String[] args) {
		int x = new ReverseInteger().reverse(1548941564);
		System.out.println(Integer.MAX_VALUE);
		System.out.println(x);
	}
}
