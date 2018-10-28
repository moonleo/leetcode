package leet.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * No.219 Contains Duplicate II
 * Given an array of integers and an integer k, find out whether 
 * there are two distinct indices i and j in the array such that 
 * nums[i] = nums[j] and the difference between i and j is at most k.
 * 
 */
public class ContainsDuplicateII {

	public static void main(String[] args) {
		int[] nums = new int[]{1, 2};
		System.out.println(new ContainsDuplicateII().containsNearbyDuplicate(nums, 1));
	}
	
	public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(2 > nums.length || k <= 0) {
            return false;
        }
        int i = 0, j = i;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        while(j < nums.length && j < i + k) {
            if(map.get(nums[j]) != null) {
                return true;
            }
            map.put(nums[j], 1);
            j++;
        }
        while(i < nums.length && j < nums.length) {
            if(map.get(nums[j])!=null)
                return true;
            map.put(nums[j], 1);
            map.remove(nums[i]);
            i ++;
            j ++;
        }
        return false;
    }
	
	

}
