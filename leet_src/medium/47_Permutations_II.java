class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        Arrays.sort(nums);
        permute(nums, 0, nums.length - 1);
        return new ArrayList(set);
    }

    //use hashset to de-duplication
    Set<List<Integer>> set = new HashSet<>();

    private void permute(int[] nums, int start, int end) {
        if (start == end) {
            List<Integer> list = new ArrayList<>();
            for (int i: nums) {
                list.add(i);
            }
            set.add(list);
            return;
        }
        for (int i = start; i <= end; i ++) {
            swap(nums, start, i);
            permute(nums, start + 1, end);
            swap(nums, start, i);
        }
    }

    private void swap(int[] nums, int i, int j) {
        if (i == j) {
            return;
        }
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
