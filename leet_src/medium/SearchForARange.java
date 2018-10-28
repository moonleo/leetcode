package leet.medium;

/**
 * No.34 Search for a Range
 * Given a sorted array of integers, find the starting 
 * and ending position of a given target value. Your 
 * algorithm's runtime complexity must be in the order 
 * of O(log n). If the target is not found in the array, return [-1, -1].
 * For example, Given [5, 7, 7, 8, 8, 10] and target value 8, 
 * return [3, 4].
 */
public class SearchForARange {
	
	public static void main(String[] args) {
		int[] nums = new int[]{5, 7, 7, 8, 8, 10};
		SearchForARange searchForARange = new SearchForARange();
		/*int[] range = searchForARange.searchRange(nums, 8);
		for(int i: range) {
			System.out.print(i + " ");
		}*/
		System.out.println(searchForARange.findMinIndex(nums, 0, nums.length-1, 9));
		System.out.println(searchForARange.findMaxIndex(nums, 0, nums.length-1, 9));
	}
	
	public int[] searchRange(int[] nums, int target) {
        int[] range = new int[2];
        range[0] = -1;
        range[1] = -1;
        if(0 == nums.length)
            return range;
            
        /*方法1
         * 
         * int index = findIndex(nums, 0, nums.length-1, target);
        if(-1 != index) {
            int min = index;
            while(min >=0 && nums[min] == target) {
                min --;
            }
            range[0] = min + 1;
            int max = index;
            while(max < nums.length && nums[max] == target) {
                max ++;
            }
            range[1] = max - 1;
        }
        return range;*/
        //方法2
        range[0] = findMinIndex(nums, 0, nums.length-1, target);
        if(-1 == range[0])
            return range;
        range[1] = findMaxIndex(nums, 0, nums.length-1, target);
        return range;
    }
    
	//方法1：
	//找到某一个索引
    private int findIndex(int[] nums, int start, int end, int target) {
        if(start > end) {
            return -1;
        }
        int mid = (start + end) >> 1;
        if(nums[mid] == target) {
            return mid;
        } else if(target > nums[mid]){
            return findIndex(nums, mid+1, end, target);
        } else {
            return findIndex(nums, start, mid-1, target);
        }
    }
    
    //方法2：
    //找到最小索引
    private int findMinIndex(int[] nums, int start, int end, int target) {
    	if(start > end) {
    		return -1;
    	}
    	int mid = (start + end) >> 1;
    	if(nums[mid] == target) {
    		if(start == mid || nums[mid-1] < nums[mid])
    			return mid;
    		else {
    			return findMinIndex(nums, start, mid-1, target);
    		}
    	} else if(target > nums[mid]){
            return findMinIndex(nums, mid+1, end, target);
        } else {
            return findMinIndex(nums, start, mid-1, target);
        }
    }
    //找到最大索引
    private int findMaxIndex(int[] nums, int start, int end, int target) {
    	if(start > end) {
    		return -1;
    	}
    	int mid = (start + end) >> 1;
    	if(nums[mid] == target) {
    		if(mid == end || nums[mid] < nums[mid + 1]) {
    			return mid;
    		} else {
    			return findMaxIndex(nums, mid + 1, end, target);
    		}
    	} else if(target > nums[mid]){
            return findMaxIndex(nums, mid+1, end, target);
        } else {
            return findMaxIndex(nums, start, mid-1, target);
        }
    }
    
}
