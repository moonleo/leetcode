class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> tempList = new ArrayList<Integer>();
        result.add(tempList);
        if(nums == null || nums.length == 0) {
            return result;
        }
        List<List<Integer>> tempResult;
        for(int i = 0; i < nums.length; i ++) {
            tempResult = copyList(result);
            for(List temp: tempResult) {
                temp.add(nums[i]);
            }
            result.addAll(tempResult);
        }
        return result;
    }

    private List<List<Integer>> copyList(List<List<Integer>> result) {
        List<List<Integer>> r = new ArrayList<List<Integer>>();
        List<Integer> subR;
        for(List<Integer> l: result) {
            subR = new ArrayList<Integer>();
            for(Integer i: l) {
                subR.add(i);
            }
            r.add(subR);
        }
        return r;
    }
}
