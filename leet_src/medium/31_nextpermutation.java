class Solution {
    public void nextPermutation(int[] nums) {
        int rtl = nums.length - 1;
        while(rtl > 0 && nums[rtl - 1] >= nums[rtl]) {
            rtl --;
        }
        if(rtl <= 0) {
            reverseArray(nums, 0, nums.length - 1);
        } else {
            int min = nums[rtl - 1];
            int flag = nums.length - 1;
            while(flag > rtl) {
                if(nums[flag] > min) {
                    swap(nums, rtl - 1, flag);
                    reverseArray(nums, rtl, nums.length - 1);
                    return;
                }
                flag --;
            }
            swap(nums, rtl - 1, rtl);
            reverseArray(nums, rtl, nums.length - 1);
        }
    }

    private void reverseArray(int[] nums, int start, int end) {
        int a = start, b = end;
        int tmp;
        while(a < b) {
            swap(nums, a, b);
            a ++;
            b --;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
