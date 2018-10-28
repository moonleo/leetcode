package leet.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * No.229 Majority Element II
 * Given an integer array of size n, find all elements that appear more than [n/3] times. 
 * The algorithm should run in linear time and in O(1) space.
 */
public class MajorityElementII {

	public static void main(String[] args) {
		/* test cases:
		 * 	[]
			[1]
			[1, 2]
			[3, 2, 3]
			[-1,1,1,1,2,1]
			[4, 1, 2, 1, 2, 1, 2, 3, 1, 4]
		 */
		System.out.println(new MajorityElementII().majorityElement(new int[]{-1,1,1,1,2,1}));
	}
	
	public List<Integer> majorityElement(int[] nums) {
		List<Integer> list = new ArrayList<Integer>();
        if(0 == nums.length) {
            return list;
        }
        //最多只可能有两个值，candidate1最开始先记录第一个值
        int candidate1 = nums[0], candidate2 = nums[0];
        int time1 = 0, time2 = 0;
        int i = 0;
        //在数组中找到第一个和candidate1不同的值，记为candidate2
        while(i < nums.length) {
            if(nums[i] == candidate1) {
                time1 ++;
                i ++;
            } else {
                candidate2 = nums[i];
                time2 ++;
                break;
            }
        }
        //遍历数组，找到和candidate1或candidate2相同的值，对应的time值加1，否则两个time同时减一
        for(int j = i+1; j<nums.length; j++) {
            if(time1 == 0 && nums[j] != candidate2) {
                time1 = 1;
                candidate1 = nums[j];
                continue;
            } else if(time2 == 0 && nums[j] != candidate1) {
                time2 = 1;
                candidate2 = nums[j];
                continue;
            }
            if(nums[j] == candidate1) {
                time1 ++;
            } else if(nums[j] == candidate2) {
                time2 ++;
            } else {
                time1 --;
                time2 --;
            }
        }
//        System.out.println(time1+" "+time2);
        if(0 < time1 && checkNum(nums, candidate1)) {
            list.add(candidate1);
        }
        if(0 < time2 && checkNum(nums, candidate2)) {
            list.add(candidate2);
        }
        return list;
    }
	
	//检验是否为最终需要的值
	private boolean checkNum(int[] nums, int num) {
		int count = 0;
		for(int i: nums) {
			if(i == num) {
				count ++;
			}
		}
		return count > nums.length/3;
	}

}
