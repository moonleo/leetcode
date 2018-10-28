package leet.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * No.46 Permutations
 * Given a collection of numbers, return all possible permutations. 
 * For example, 
 * [1,2,3] have the following permutations: 
 * [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1]. 
 */
public class Permutations {

	List<List<Integer>> resultList = new ArrayList<>();
	List<Integer> list;
	public static void main(String[] args) {
		Permutations permutations = new Permutations();
		int[] nums = new int[]{1, 2, 3};
		permutations.permute(nums);
		for(List<Integer> list: permutations.resultList) {
			for(int i: list) {
				System.out.print(i+" ");
			}
			System.out.println();
		}
	}
	
	public List<List<Integer>> permute(int[] nums) {
		permute(nums, 0, nums.length-1);
		return resultList;
    }
	
	public void permute(int[] nums, int start, int end) {
		if(start >= end) {
			list = new ArrayList<>();
			for(int i: nums) {
				list.add(i);
			}
			resultList.add(list);
			return ;
		}
		for(int i=start; i<=end; i++) {
			swap(nums, start, i);
			permute(nums, start+1, end);
			swap(nums, start, i);
		}
	}
	/**
	 * 交换数组两个位置上的元素
	 * @param nums 数组
	 * @param a 位置
	 * @param b 位置
	 */
	private void swap(int[] nums, int a, int b) {
		if(a == b) {
			return ;
		}
		int temp = nums[a];
		nums[a] = nums[b];
		nums[b] = temp;
	}

}
