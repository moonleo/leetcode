package leet.medium;

/**
 * No.137 Single Number II
 * Given an array of integers, every element appears three times except for one. 
 * Find that single one. 
 */
public class SingleNumberII {

	public static void main(String[] args) {

	}
	
	public int singleNumber(int[] nums) {
        int one, two, three;
        one = two = three = 0;
        for(int i: nums) {
        	//一定是出现3次，2次，1次这样的顺序，如果反过来的话，先更新了one的话，会影响到two和three的
            three = two & i;//已经出现了两次，还出现了一次
            two = two | one & i;//出现了1次又出现了1次，在加上以前已经出现了2次的，为新的出现了2次的
            one = one | i;//出现了1次
            //将出现3次的其出现1次2次全部抹去
            one = one & ~three;
            two = two & ~three;
        }
        return one;
    }

}
