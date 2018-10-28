package leet.medium;

/**
 * No.53 Maximum Subarray
 * Find the contiguous subarray within an array (containing at 
 * least one number) which has the largest sum. For example, 
 * given the array [−2,1,−3,4,−1,2,1,−5,4], the contiguous 
 * subarray [4,−1,2,1] has the largest sum = 6. 
 */
public class MaximumSubarray {

	public static void main(String[] args) {
		int[] array = new int[] {-2, 1, -3, 4, -1, 2, 1, -5, 4};
		System.out.println(new MaximumSubarray().maxSubArray(array));
	}
	
	public int maxSubArray(int[] nums) {
        int max = nums[0];//最大和
        int temp = nums[0];//当前和
        int i = 1;
        while(i < nums.length) {
            if(temp < 0) {
                temp = nums[i];
            } else {
                temp = temp + nums[i];
            }
            if(temp > max) {
                max = temp;
            }
            i ++;
        }
        return max;
    }

}
