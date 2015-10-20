package leet.medium;

import norm.ArraysUtil;

/**
 * No.81 Search in Rotated Sorted Array II
 * Follow up for "Search in Rotated Sorted Array": What if duplicates are allowed?
 */
public class SearchInRotatedSortedArrayII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = ArraysUtil.create(1,1,1,2,0);
		int target = 2;
		System.out.println(new SearchInRotatedSortedArrayII().search(nums, target));
	}
	
	public boolean search(int[] nums, int target) {
        if(null == nums) {
            return false;
        }
        int s = 0, e = nums.length-1;
        int mid;
        while(s <= e) {
            mid = (s + e) >> 1;
            if(nums[s] == nums[mid] && nums[mid] == nums[e]) {
                return searchInOrder(nums, target);
            } else {
                if(nums[mid] == target) {
                    return true;
                } 
                //左边有序
                if(nums[mid] > nums[s]){
                    if(nums[s] <= target && target <= nums[mid]) {
                        e = mid - 1;
                    } else {
                        s = mid + 1;
                    }
                } 
                //右边有序
                else if(nums[mid] < nums[s]){
                    if(nums[mid] <= target && target <= nums[e]) {
                        s = mid + 1;
                    } else {
                        e = mid - 1;
                    }
                }
                else {
                    s ++;
                }
            }
        }
        return false;
    }
    
    private boolean searchInOrder(int[] nums, int target) {
        for(int i: nums) {
            if(target == i) {
                return true;
            }
        }
        return false;
    }

}
