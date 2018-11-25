class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(nums == null || nums.length < 4) {
            return result;
        }
        List<Integer> numbers = new ArrayList<Integer>();
        for(int i: nums) {
            numbers.add(i);
        }
        Collections.sort(numbers);

        int size = numbers.size();
        for(int i = 0; i < size - 3; i ++) {
            for(int j = i + 1; j < size - 2; j ++) {
                int k = j + 1;
                int m = size - 1;
                while(k < m) {
                    int sum = numbers.get(i) + numbers.get(j) + numbers.get(k) + numbers.get(m);
                    if(sum == target) {
                        List<Integer> tmp = new ArrayList<Integer>();
                        tmp.add(numbers.get(i));
                        tmp.add(numbers.get(j));
                        tmp.add(numbers.get(k));
                        tmp.add(numbers.get(m));
                        addToResult(result, tmp);
                        //result.add(tmp);
                        k ++;
                        m --;
                    } else if(sum < target) {
                        k ++;
                    } else {
                        m --;
                    }
                }
            }
        }
        return result;
    }

    private void addToResult(List<List<Integer>> result, List<Integer> list) {
        if(result.size() == 0) {
            result.add(list);
        }
        boolean contains = false;
        for(int i = 0; i < result.size(); i ++) {
            if(sameList(result.get(i), list)) {
                contains = true;
                break;
            }
        }
        if(!contains) {
            result.add(list);
        }
    }

    private boolean sameList(List<Integer> a, List<Integer> b) {
        int size = a.size();
        for(int i = 0; i < a.size(); i ++) {
            //*不能用if(a.get(i) != b.get(i))进行判断，因为取出来的是Integer对象，两个相同值的对象是不相同的
            if(a.get(i) - b.get(i) != 0)  {
                return false;
            }
        }
        return true;
    }
}
