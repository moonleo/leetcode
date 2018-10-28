package leet.medium;

/**
 * No.35 Search Insert Position
 * Given a sorted array and a target value, return the index if the 
 * target is found. If not, return the index where it would be if it 
 * were inserted in order. You may assume no duplicates in the array.
 * Here are few examples.
 * [1,3,5,6], 5 -> 2
 * [1,3,5,6], 2 -> 1
 * [1,3,5,6], 7 -> 4
 * [1,3,5,6], 0 -> 0 
 * [1,3], 0 -> 0
 */
public class SearchInsertPosition {
	public int searchInsert(int[] nums, int target) {
        return searchInsert(nums, 0, nums.length-1, target);
    }
    
    public int searchInsert(int[] nums, int start, int end, int target) {
        if(start > end) {
            return end+1;
        }
        int mid = (start + end) >> 1;
        if(nums[mid] == target) {
            return mid;
        } else if(nums[mid] > target) {
            return searchInsert(nums, start, mid-1, target);
        } else {
            return searchInsert(nums, mid + 1, end, target);
        }
    }
}
