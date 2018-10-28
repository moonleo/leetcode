package leet.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *  No.40 Combination Sum II
 *  Given a collection of candidate numbers (C) and a target 
 *  number (T), find all unique combinations in C where the 
 *  candidate numbers sums to T. Each number in C may only 
 *  be used once in the combination. 
 */
public class CombinationSum2 {
	//记录所有的结果
	List<List<Integer>> allList = new ArrayList<List<Integer>>();
	//记录一组结果
    List<Integer> list = new ArrayList<Integer>();
    
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        calCom(candidates, 0, target);
        return allList;
    }
    
    private void calCom(int[] candidates, int start, int target) {
        if(target < 0)
            return;
        if(0 == target) {
            if(!containsList(allList, list))
                allList.add(new ArrayList(list));
            return;
        }
        for(int i=start; i<candidates.length; i++) {
            list.add(candidates[i]);
            calCom(candidates, i+1, target-candidates[i]);
            list.remove(list.size()-1);
        }
    }
    
    /**
     * 判断结果是否已经存在
     * @param allList 所有结果
     * @param list 一组结果
     * @return 若存在返回true,否则返回false
     */
    private boolean containsList(List<List<Integer>> allList, List<Integer> list) {
        boolean flag;
        for(List<Integer> element: allList) {
            if(element.size() == list.size()) {
                flag = true;
                for(int i=0; i<list.size(); i++) {
                    if(element.get(i) != list.get(i)) {
                        flag = false;
                        break;
                    }
                }
                if(flag)
                    return true;
            }
        }
        return false;
    }
}
