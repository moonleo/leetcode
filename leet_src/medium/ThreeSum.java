package leet.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * No.15 3Sum
 * Given an array S of n integers, are there elements 
 * a, b, c in S such that a + b + c = 0? Find all unique 
 * triplets in the array which gives the sum of zero.
 * Note:
 * Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
 * The solution set must not contain duplicate triplets.
 */
public class ThreeSum {
	List<List<Integer>> result = new ArrayList<>();
	
	public static void main(String[] args) {
		ThreeSum sum = new ThreeSum();
		int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
		sum.threeSum(nums);
		for(List<Integer> list: sum.result) {
			for(int i: list) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}
	
	public List<List<Integer>> threeSum(int[] nums) {
		Arrays.sort(nums);
		int[] path = new int[3];
		findSum(nums, 0, nums.length, path, 0, 0);
		return result;
    }
	
	private void findSum(int[] nums, int start, int end, int[] path, int index, int sum) {
		if(start > end) {
			return ;
		}
		if(3 == index) {
			if(sum == 0) {
				List<Integer> list = new ArrayList<>();
				for(int i: path) {
					list.add(i);
				}
				result.add(list);
			}
			return ;
		}
		for(int i=start; i<end; i++) {
			path[index] = nums[i];
			index ++;
			findSum(nums, i+1, end, path, index, sum-nums[i]);
			index --;
			while(i<end-1 && nums[i] == nums[i+1]) {
				i ++;
			}
		}
	}
}
