package leet.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * No.29 Combination Sum
 *  Given a set of candidate numbers (C) and a target number (T),
 *  find all unique combinations in C where the candidate numbers 
 *  sums to T. The same repeated number may be chosen from C unlimited 
 *  number of times. 
 *  
 *  Note:
 *   `All numbers (including target) will be positive integers.
 *   `Elements in a combination (a1, a2, … , ak) must be in non-descending order. 
 *   (ie, a1 ≤ a2 ≤ … ≤ ak).
 *   `The solution set must not contain duplicate combinations.
 *
 */
public class CombinationSum {
	List<List<Integer>> allList = new ArrayList<List<Integer>>();//记录所有结果
    List<Integer> list = new ArrayList<Integer>();//记录一组结果
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if(target <= 0)
            return allList;
        Arrays.sort(candidates);
        for(int i=0; i<candidates.length; i++) {
            list.add(candidates[i]);
            calculate(candidates, i, target-candidates[i]);
            list.remove(list.size()-1);
        }
        return allList;
    }
    
    private void calculate(int[] candidates, int start, int sum) {
        if(sum < 0) {
            return ;
        }
        if(0 == sum) {
            allList.add(new ArrayList<Integer>(list));
            return;
        }
        for(int i=start; i<candidates.length; i++) {
            list.add(candidates[i]);
            calculate(candidates, i, sum-candidates[i]);
            list.remove(list.size()-1);
        }
    }
    
    public static void main(String[] args) {
		CombinationSum sum = new CombinationSum();
		sum.combinationSum(new int[]{8, 3, 4, 7}, 11);
		for(List<Integer> list: sum.allList) {
			for(int i : list) {
				System.out.print(i+" ");
			}
			System.out.println();
		}
	}
}
