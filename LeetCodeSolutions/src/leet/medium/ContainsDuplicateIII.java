package leet.medium;

import java.util.TreeSet;

import norm.ArraysUtil;

/**
 * No.220 Contains Duplicate III
 * Given an array of integers, find out whether there are two distinct 
 * indices i and j in the array such that the difference between nums[i] 
 * and nums[j] is at most t and the difference between i and j is at 
 * most k. 
 */
public class ContainsDuplicateIII {

	public static void main(String[] args) {
		int[] nums = ArraysUtil.create(-1,Integer.MAX_VALUE);
		System.out.println(new ContainsDuplicateIII().containsNearbyAlmostDuplicate(nums,1,Integer.MAX_VALUE));
	}
	
	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(null == nums || 1 >= nums.length || 0 >= k || 0 > t) {
            return false;
        }
        //TreeSet保持一个大小为K的集合
        TreeSet<Long> set = new TreeSet<Long>();
        int index = 0;
        int count = 0;
        long temp;
        Long ceiler, floor;//分别记录集合中大于等于、小于等于当前值的值
        while(index < nums.length && count <= k) {
        	temp = nums[index];
            if(0 != set.size()) {
            	ceiler = set.ceiling(temp);
            	if(ceiler != null && ceiler-temp <= t) {
            		return true;
            	}
            	floor = set.floor(temp);
            	if(floor != null && temp-floor <= t) {
            		return true;
            	}
            }
            set.add(temp);
            count ++;
            index ++;
        }
        while(index < nums.length) {
            set.remove((long)nums[index-k-1]);
            temp = nums[index];
            if(0!=set.size()) {
            	ceiler = set.ceiling(temp);
            	if(ceiler != null && ceiler-temp <= t) {
            		return true;
            	}
            	floor = set.floor(temp);
            	if(floor != null && temp-floor <= t) {
            		return true;
            	}
            }
            set.add(temp);
            index ++;
        }
        return false;
    }

}
