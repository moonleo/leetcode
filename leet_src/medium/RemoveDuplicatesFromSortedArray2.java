package leet.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * No.80 移除有序数组重复的数（超过两个的）
 *
 */
public class RemoveDuplicatesFromSortedArray2 {
	public int removeDuplicates(int[] nums) {
        Map<Integer, Integer> hash = new HashMap<Integer, Integer>();
        if(nums.length <= 2) {
            return nums.length;
        }
        int currentCount;
        int num, length = 0;
        for(int i=0; i<nums.length; i++) {
            num = nums[i];
            if(null == hash.get(num)) {
                hash.put(num, 1);
            } else {
                currentCount = hash.get(num);
                if(currentCount >= 2) {
                    continue;
                } else {
                    hash.put(num, currentCount+1);
                }
            }
            if(i > length) {
                nums[length] = nums[i];
                length ++;
            } else if(i == length) {
                length ++;
            }
        }
        return length;
    }
	
	public static void main(String[] args) {
		int[] array = {1, 1, 1, 2, 2, 3};
		System.out.println(new RemoveDuplicatesFromSortedArray2().removeDuplicates(array));
	}
}
