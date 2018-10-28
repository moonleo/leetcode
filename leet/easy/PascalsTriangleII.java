package leet.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * No.119 Pascal's Triangle II
 * Given an index k, return the kth row of the Pascal's triangle. For example, given k = 3, Return [1,3,3,1]. 
 */
public class PascalsTriangleII {

	public static void main(String[] args) {
		List<Integer> list = new PascalsTriangleII().getRow(5);
		for(int i: list) {
			System.out.print(i+" ");
		}
	}
	
	public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        if(rowIndex == 0) {
            return list;   
        }
        list.add(1);
        if(rowIndex == 1) {
            return list;
        }
        int[] result = new int[rowIndex + 1];
        result[0] = 1;
        result[1] = 1;
        int j = 0;
        int temp = 0, p;
        for(int i = 2;i <= rowIndex; i ++) {
        	temp = 1;
            for(j = 1; j<i; j++) {
                p = result[j] + temp;
                temp = result[j];
                result[j] = p;
            }
            result[j] = 1;
        }
        list.clear();
        for(int i: result) {
            list.add(i);
        }
        return list;
    }

}
