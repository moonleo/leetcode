package leet.easy;

/**
 * No.27 Remove Element
 * Given an array and a value, remove all instances 
 * of that value in place and return the new length. 
 * The order of elements can be changed. It doesn't 
 * matter what you leave beyond the new length.
 */
public class RemoveElement {
	public int removeElement(int[] nums, int val) {
        if(null == nums || 0 >= nums.length) {
            return 0;
        }
        int p = -1;
        for(int i=0; i<nums.length; i++) {
            if(val == nums[i])
                continue;
            p ++;
            if(val != nums[i] && p < i) {
                nums[p] = nums[i];
            }
        }
        return p+1;
    }
}
