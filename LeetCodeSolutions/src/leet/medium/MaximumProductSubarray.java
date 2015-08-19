package leet.medium;

/**
 * No.152 Maximum Product Subarray
 * Find the contiguous subarray within an array 
 * (containing at least one number) which has 
 * the largest product.
 * 
 */
public class MaximumProductSubarray {
	
	public static void main(String[] args) {
		int[] array = new int[]{2,-1,1,1};
		System.out.println(new MaximumProductSubarray().maxProduct(array));
	}
	
	public int maxProduct(int[] nums) {
        if(1 == nums.length) {
            return nums[0];
        }
        int length = nums.length;
        //记录最大值
        int[] max = new int[length];
        max[0] = nums[0];
        //记录最小值
        int[] min = new int[length];
        min[0] = nums[0];
        //记录最终结果
        int[] array = new int[length];
        array[0] = nums[0];
        int n;
        for(int i=1; i<length; i++) {
            n = nums[i];
            max[i] = max(n, n*max[i-1], n*min[i-1]);
            min[i] = min(n, n*max[i-1], n*min[i-1]);
            array[i] = max(array[i-1], max[i]);
        }
        for(int i:array) {
        	System.out.print(i+" ");
        }
        System.out.println();
        
        return array[length-1];
    }
    
    private int max(int a, int b) {
        return a > b ? a : b;
    }
    
    private int max(int a, int b, int c) {
        int temp = max(a, b);
        return temp > c ? temp : c;
    }
    
    private int min(int a, int b, int c) {
        int temp = a > b ? b : a;
        return temp > c ? c : temp;
    }
}
