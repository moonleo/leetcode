package leet.medium;

/**
 * No.75 Sort Colors
 *  Given an array with n objects colored red, white or blue, sort them so that 
 *  objects of the same color are adjacent, with the colors in the order red, 
 *  white and blue. Here, we will use the integers 0, 1, and 2 to represent the 
 *  color red, white, and blue respectively. 
 */
public class SortColors {

	public static void main(String[] args) {
		int[] nums = new int[]{1,0,0,2,2,0,1};
		new SortColors().sortColors2(nums);
		for(int i: nums) {
			System.out.print(i+" ");
		}
	}
	
	public void sortColors(int[] nums) {
        int[] array = new int[3];
        for(int i: nums) {
            array[i] ++;
        }
        int index = 0;
        int i = 0;
        while(i < array[0]) {
            nums[index] = 0;
            index ++;
            i ++;
        }
        i = 0;
        while(i < array[1]) {
            nums[index] = 1;
            index ++;
            i ++;
        }
        i = 0;
        while(i < array[2]) {
            nums[index] = 2;
            index ++;
            i ++;
        }
    }
	
	public void sortColors2(int[] nums) {
        int start = -1, end = nums.length;
        int i = 0;
        while(i < nums.length) {
	        if(nums[i] == 0) {
	        	if(i > start + 1)
	        		swap(nums, ++start, i);
	        	else {
					start ++;
					i ++;
				}
	        }
	        else if(nums[i] == 2) {
	        	if(i < end - 1)
	        		swap(nums, --end, i);
	        	else {
	        		end --;
	        		i ++;
	        	}
	        }
	        else {
	        	i ++;
	        }
        }
    }
    
    private void swap(int[] nums, int x, int y) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }

}
