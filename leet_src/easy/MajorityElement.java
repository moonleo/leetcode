package leet.easy;

/**
 * No.169 Majority Element
 * Given an array of size n, find the majority element. 
 * The majority element is the element that appears more 
 * than n/2 ⌋ times.
 *
 */
public class MajorityElement {
	public int majorityElement(int[] nums) {
		if(1 == nums.length) {
			return nums[0];
		}
		int elementTime = 1;
		int currentElement = nums[0];
		for(int i=1; i<nums.length; i++) {
			if(0 == elementTime) {
				elementTime = 1;
				currentElement = nums[i];
			} else if(currentElement != nums[i]) {
				elementTime --;
			} else {
				elementTime ++;
			}
		}
        return currentElement;
    }
	
	public static void main(String[] args) {
		int[] array = new int[]{1, 2, 3, 3,4 ,5, 1, 1, 1,1};
		System.out.println(new MajorityElement().majorityElement(array));
	}
}
