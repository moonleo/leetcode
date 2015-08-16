package leet.easy;

/**
 * No.258 Add Digits
 * Given a non-negative integer num, repeatedly add 
 * all its digits until the result has only one digit.
 * 
 */
public class AddDigit {
	public int addDigits(int num) {
		if(0 == num)
			return 0;
		return (num % 9 == 0) ? 9 : num % 9;
    }
}
