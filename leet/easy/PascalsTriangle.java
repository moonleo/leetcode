package leet.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * No.118 Pascal's Triangle
 * Given numRows, generate the first numRows of Pascal's triangle.
 */
public class PascalsTriangle {

	public static void main(String[] args) {
		
	}
	
	List<List<Integer>> allList = new ArrayList<List<Integer>>();
    public List<List<Integer>> generate(int numRows) {
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        nextLine(list, 1, numRows);
        return allList;
    }
    
    public void nextLine(List<Integer> list, int row, int total) {
        if(row > total) {
            return;
        }
        allList.add(list);
        List<Integer> next = new ArrayList<Integer>();
        next.add(1);
        for(int i=1; i<list.size(); i++) {
            next.add(list.get(i-1)+list.get(i));
        }
        next.add(1);
        nextLine(next, row+1, total);
    }

}
