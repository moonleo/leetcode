package leet.hard;

/**
 * No.41 First Missing Positive
 * Given an unsorted integer array, find the first missing positive integer. 
 * For example, Given [1,2,0] return 3, and [3,4,-1,1] return 2.
 * Your algorithm should run in O(n) time and uses constant space.  
 */
public class FirstMissingPositive {
	public int firstMissingPositive(int[] nums) {
		if (nums.length <= 0)
			return 1;
		int index = 0;
		//用数组index的位置来记录值index+1
		while (index < nums.length) {
			//将每个位置上的数交换到合适的位置，直到没有合适的位置可以交换
			if (nums[index] == index + 1 || nums[index] >= nums.length
					|| nums[index] <= 0 || nums[index] == nums[nums[index] - 1])
				index++;
			else {
				swap(nums, index, nums[index] - 1);
			}
		}
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != i + 1) {
				return i + 1;
			}
		}
		return nums.length + 1;
	}
    
    //交换数组两个位置的元素
    private void swap(int[] nums, int x, int y) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
}
