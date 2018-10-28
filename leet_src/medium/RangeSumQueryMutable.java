package leet.medium;

/**
 * No.307 Range Sum Query-Mutable
 * 
 * Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive. 
 * The update(i, val) function modifies nums by updating the element at index i to val.
 */
public class RangeSumQueryMutable {

	public static void main(String[] args) {
		int[] nums = new int[]{7,2,7,2,0};
		RangeSumQueryMutable r = new RangeSumQueryMutable(nums);
		r.update(4, 6);
		r.display();
		r.update(0, 2);
		r.display();
		r.update(0, 9);
		r.display();
		/*System.out.println(rsqm.sumRange(0, 2));
		rsqm.update(1, 2);
		System.out.println(rsqm.sumRange(0, 2));*/
	}
	
	private int[] binaryIndexTree;
    private int[] tmpArray;
    public RangeSumQueryMutable(int[] nums) {
        int length = nums.length;
        binaryIndexTree = new int[length+1];
        tmpArray = new int[length];
        for(int i=0; i<length; i++) {
        	init(i, nums[i]);
        	tmpArray[i] = nums[i];
        }
    }
    
    void init(int i, int val) {
    	i ++;
        while(i < binaryIndexTree.length) {
        	binaryIndexTree[i] += val;
        	i += lowBit(i);
        }
    }
    
    void update(int i, int val) {
    	int diff = val - tmpArray[i];
        if(diff != 0) {
        	tmpArray[i] = val;
        	i ++;
        	while(i < binaryIndexTree.length) {
            	binaryIndexTree[i] += diff;
            	i += lowBit(i);
            }
        }
    }

    public int sumRange(int i, int j) {
		return sumRangeFromZero(j) - sumRangeFromZero(i-1);
    }
    
    private int sumRangeFromZero(int i) {
    	int sum = 0;
    	i ++;
    	while(i > 0) {
    		sum += binaryIndexTree[i];
    		i -= lowBit(i);
    	}
    	return sum;
    }
    
    private int lowBit(int num) {
        return num & (-num);
    }
    
    void display() {
    	System.out.println();
    	for(int i=0; i < binaryIndexTree.length; i++) {
    		System.out.print(binaryIndexTree[i]+" ");
    	}
    	System.out.println();
    }

}
