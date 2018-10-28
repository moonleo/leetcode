package leet.medium;

/**
 * No.82 
 * Suppose a sorted array is rotated at some pivot 
 * unknown to you beforehand. You are given a target 
 * value to search. If found in the array return 
 * its index, otherwise return -1. You may assume 
 * no duplicate exists in the array.
 */
public class SearchInRotatedSortedArray {
	
	public static void main(String[] args) {
		int[] nums = new int[]{3, 4,5,0,1,2};
		System.out.println(new SearchInRotatedSortedArray().search(nums, 0));
	}
	
	
	public int search(int[] nums, int target) {
        if(null == nums || 0 == nums.length)
            return -1;
        int s = 0, e = nums.length-1;
        int mid;
        while(s <= e) {
            mid = (s + e) >> 1;
            if(target == nums[mid]) {
                return mid;
            }
            //左边有序
            if(nums[mid] >= nums[s]) {
                if(nums[s] <= target && target < nums[mid]) {
                    e = mid - 1;
                } else {
                    s = mid + 1;
                }
            } else {
                if(nums[mid] < target && target <= nums[e]) {
                    s = mid + 1;
                } else {
                    e = mid - 1;
                }
            }
        }
        return -1;
    }
	
	/*public int search(int[] nums, int target) {
        if(0 == nums.length)
            return -1;
        if(1 == nums.length) 
            return target == nums[0] ? 0 : -1;
        return findPivot(nums, 0, nums.length-1, target);
        
    }
    
    private int findPivot(int[] nums, int start, int end, int target) {
        if(start > end) {
            return -1;
        }
        int mid = (start + end) >> 1;
        int index = -1;
        if(nums[mid] == target) {
            return mid;
        } else {
        	index = findPivot(nums, start, mid-1, target);
        	if(-1 == index)
        		index = findPivot(nums, mid+1, end, target);
        	return index;
        }
    }*/
    
}
