package leet.medium;

/**
 * No.260 Single Number III
 * Given an array of numbers nums, in which exactly 
 * two elements appear only once and all the other 
 * elements appear exactly twice. Find the two elements 
 * that appear only once. 
 *
 */
public class SingleNumber3 {
	public int[] singleNumber(int[] nums) {
        int result = 0;
        for(int num: nums)
            result ^= num;
        int index = firstOneBitIndex(result);
        int[] array = new int[2];
        for(int num: nums) {
            if(oneBitIndex(num, index)) {
                array[0] ^= num;
            } else {
                array[1] ^= num;
            }
        }
        return array;
    }
    
    private int firstOneBitIndex(int num) {
        int index = 1;
        while((num & 1) == 0) {
            num = (num >> 1);
            index ++;
        }
        return index;
    }
    
    private boolean oneBitIndex(int num, int index) {
        return (((num>>(index-1))&1)== 0)? false: true;
    }
}
