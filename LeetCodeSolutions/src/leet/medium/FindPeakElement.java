package leet.medium;

/**
 * No.162 Find Peak Element
 * A peak element is an element that is greater than its neighbors. 
 * Given an input array where num[i] ≠ num[i+1], find a peak element and return its index. 
 * The array may contain multiple peaks, in that case return the index to any one of the peaks is fine. 
 * You may imagine that num[-1] = num[n] = -∞
 */
public class FindPeakElement {

	public static void main(String[] args) {
		int[] nums = new int[]{1,2,3};
		System.out.println(new FindPeakElement().findPeakElement(nums));
	}
	
	public int findPeakElement(int[] nums) {
        if(null == nums || 0 == nums.length) {
            return -1;
        }
        return findPeakElement(nums, 0, nums.length-1);
    }
    
    private int findPeakElement(int[] nums, int start, int end) {
        if(start > end) {
            return -1;
        }
        int mid = (start+end)>>1;
        boolean left = false , right = false;
        if(mid > start) {
            if(nums[mid] > nums[mid - 1]) {
                left = true;
            }
        } else {
            left = true;
        }
        if(mid < end) {
            if(nums[mid] > nums[mid + 1]) {
                right = true;
            }
        } else {
            right = true;
        }
        if(left && right) {
            return mid;
        }
        int index = -1;
        if(!left) {
            index = findPeakElement(nums, start, mid-1);
        }
        if(index == -1) {
            if(!right) {
                index = findPeakElement(nums, mid+1, end);
            }
        }
        return index;
    }

}
