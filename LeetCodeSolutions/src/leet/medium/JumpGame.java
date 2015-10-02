package leet.medium;

/**
 * No.55 Jump Game
 *  Given an array of non-negative integers, you are initially positioned at the first index of the array. 
 *  Each element in the array represents your maximum jump length at that position. 
 *  Determine if you are able to reach the last index. 
 */
public class JumpGame {

	public static void main(String[] args) {

	}
	
	public boolean canJump(int[] nums) {
        if(null == nums || 0 == nums.length) {
            return false;
        }
        if(1 == nums.length) {
            return true;
        }
        int step = nums[0];
        for(int i=0; i<nums.length; i++) {
            if(step > 0) {
                step = Math.max(--step, nums[i]);
            } else {
                return false;
            }
        }
        return true;
    }

}
