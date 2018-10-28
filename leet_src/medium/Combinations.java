package leet.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * No.77 Combinations
 * Given two integers n and k, return all possible combinations 
 * of k numbers out of 1 ... n.
 * If n = 4 and k = 2, a solution is
 * [
  	[2,4],
  	[3,4],
  	[2,3],
  	[1,2],
  	[1,3],
  	[1,4],
	]
 */
public class Combinations {
	List<List<Integer>> allList = new ArrayList<List<Integer>>();//记录所有结果
	List<Integer> list = new ArrayList<Integer>();//记录一组结果
	
    public List<List<Integer>> combine(int n, int k) {
        if(n < k || k==0 || n<1) {
            return allList;
        }
        for(int i=1; i<=n-k+1; i++) {
			list.add(i);
			result(i+1, n, k-1);
			list.remove(list.size()-1);
		}
		return allList;
    }
    
    private void result(int start, int end, int k) {
		if(0 == k) {
			allList.add(new ArrayList<Integer>(list));
			return ;
		}
		for(int i=start; i<=end; i++) {
			list.add(i);
			result(i+1, end, k-1);
			list.remove(list.size()-1);
		}
	}
    
    public static void main(String[] args) {
		Combinations combinations = new Combinations();
		combinations.combine(5, 2);
		for(List<Integer> list: combinations.allList) {
			for(int i : list) {
				System.out.print(i+" ");
			}
			System.out.println();
		}
	}
}
