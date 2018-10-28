package leet.medium;

/**
 * No.29 Divide Two Integers
 * Divide two integers without using multiplication, division 
 * and mod operator. If it is overflow, return MAX_INT.
 */
public class DivideTwoIntegers {

	public static void main(String[] args) {
		DivideTwoIntegers integers = new DivideTwoIntegers();
		System.out.println(integers.divide(-2147483648, -1));
	}
	
	public int divide(long dividend, long divisor) {
		int positive = dividend*divisor > 0? 1: -1;
		dividend = Math.abs(dividend);
		divisor = Math.abs(divisor);
        if(0 == divisor) {
            return 0x7fffffff;
        }
        if(0 == dividend) {
			return 0;
		}
        if(1 == divisor) {
            long r = dividend * positive;
            return r > 0x7fffffff ? 0x7fffffff : (int)r;
        }
        if(divisor > dividend) {
        	return 0;
        }
        long result = 1;
        while(divisor * (result*2) < dividend) {
        	result *= 2;
        }
        result += (long)divide(dividend-result*divisor, divisor);
        return (int)result * positive;
    }

}
