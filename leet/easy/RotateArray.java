package leet.easy;

/**
 * No.189 Rotate Array
 * Rotate an array of n elements to the right by k steps. 
 * For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] 
 * is rotated to [5,6,7,1,2,3,4]. 
 */
public class RotateArray {
	public void rotate(int[] nums, int k) {
        if(1 >= nums.length || k <= 0) {
            return;
        }
        //右移位数模数组长度，因为右移数组长度位数后仍是原数组
        k = k % nums.length;
        rotateSubArray(nums, 0, nums.length-k-1);
        rotateSubArray(nums, nums.length-k, nums.length-1);
        rotateSubArray(nums, 0, nums.length-1);
    }
    
	/**
	 * 旋转数组的某一部分
	 * @param nums 数组
	 * @param start 起始索引
	 * @param end 终止索引
	 */
    private void rotateSubArray(int[] nums, int start, int end) {
        int i=start, j = end;
        int temp;
        while(i < j) {
            temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            
            i++;
            j--;
        }
    }
}
