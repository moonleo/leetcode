package leet.easy;

public class MoveZeroes {

	public static void main(String[] args) {
		int[] nums = new int[]{0,1,0,3,12};
		new MoveZeroes().moveZeroes(nums);
		for(int i: nums) {
			System.out.print(i+" ");
		}
	}
	
	public void moveZeroes(int[] nums) {
        int i = 0, j = 0;
        while(j < nums.length && nums[j] == 0) {
            j ++;
        }
        while(i < nums.length && nums[i] != 0) {
            i ++;
        }
        while(j < nums.length) {
            if(nums[j] == 0 || i >= j) {
                j ++;
                continue;
            }
            if(i < j) {
                swap(nums, i, j);
                while(i < nums.length && nums[i] != 0){
                    i ++;
                }
            }
            j ++;
        }
    }
    
    public void swap(int[] nums, int x, int y) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }

}
