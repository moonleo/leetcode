package leet.easy;

/**
 * No.26 去掉排序数组里的重复元素，将不重复元素排在数组前部，并返回新的长度
 * 
 */
public class RemoveDuplicatesFromSortedArray {
	public int removeDuplicates(int[] nums) {
        if(null == nums || 0 == nums.length) {
            return 0;
        }
        int p = 0, q = p + 1;
        int count = 1;
        while(q < nums.length) {
            if(nums[p] == nums[q]) {
                q ++;
                continue;
            } else {
                p ++;
                swap(nums, p, q);
                q ++;
                count ++;
            }
        }
        return count;
    }
    
    public void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}
