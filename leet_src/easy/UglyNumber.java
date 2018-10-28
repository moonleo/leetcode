package leet.easy;

/**
 * No.263 Ugly Number 
 * Write a program to check whether a given number is an ugly number.
 * Ugly numbers are positive numbers whose prime factors only include 
 * 2, 3, 5. Note that 1 is typically treated as an ugly number.
 */
public class UglyNumber {
	public boolean isUgly(int num) {
        if(num < 1) {
            return false;
        }
        if(num == 1) {
            return true;
        }
        while(num % 5 == 0) {
            num = num / 5;
        }
        while(num % 3 == 0) {
            num = num / 3;
        }
        while(num % 2 == 0) {
            num = num / 2;
        }
        return num == 1 ? true : false;
    }
}
