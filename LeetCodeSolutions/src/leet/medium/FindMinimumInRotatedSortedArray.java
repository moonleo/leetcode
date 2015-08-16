package leet.medium;

/**
 * No.153 Find Minimum in Rotated Sorted Array 
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * Find the minimum element.
 * You may assume no duplicate exists in the array.
 */
public class FindMinimumInRotatedSortedArray {
	public int findMin(int[] nums) {
        if(1 == nums.length)
            return nums[0];
        //找到最大数的索引
        int index = findRotatedIndex(nums, 0, nums.length - 1);
        //下一个数就是最小的数
        return nums[(index+1)%nums.length];
    }
    /**
     * 找到最大数的索引
     * @param nums 旋转数组
     * @param start 起始索引
     * @param end 终止索引
     * @return 最大数的索引，未找到返回-1
     */
    private int findRotatedIndex(int[] nums, int start, int end) {
        if(start > end) 
            return -1;
        int mid = (start+end)/2;
        if(mid < nums.length-1 && nums[mid + 1] < nums[mid]) {
            return mid;
        } 
        int index = findRotatedIndex(nums, mid+1, end);
        if(-1 == index)
            index = findRotatedIndex(nums, start, mid - 1);
        return index;
    }
}
