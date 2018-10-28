package leet.hard;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * No.239 Sliding Window Maximum
 * Given an array nums, there is a sliding window of size k 
 * which is moving from the very left of the array to the very right. 
 * You can only see the k numbers in the window. Each time the sliding 
 * window moves right by one position.
 */
public class SlidingWindowMaximum {

	public static void main(String[] args) {
//		int[] nums = new int[]{1,3,1,2,0,5};
		int[] nums = new int[]{5, 3, 4};
		int[] res = new SlidingWindowMaximum().maxSlidingWindow(nums, 1);
		for(int i: res) {
			System.out.println(i);
		}
	}
	
	public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length-k+1];
        //按值排列的优先队列
        Queue<Data> queue = new PriorityQueue<Data>(10, new MyComparator());
        int i = 0;
        while(i < k) {
        	queue.offer(new Data(i, nums[i]));
            i ++;
        }
        result[0] = queue.peek().data;
        int index = 1;
        while(i < nums.length) {
        	queue.offer(new Data(i, nums[i]));
        	while(!queue.isEmpty() &&i >= queue.peek().index + k) {
        		queue.poll();
        	}
            result[index] = queue.peek().data;
            i++;
            index ++;
        }
        return result;
    }
	
	//记录数组索引和数值
	class Data {
		int index;
		int data;
		
		public Data(int index, int data) {
			this.index = index;
			this.data = data;
		}
	}
    
    class MyComparator implements Comparator<Data> {
		@Override
		public int compare(Data o1, Data o2) {
			if(o1.data > o2.data)
				return -1;
			else if(o1.data < o2.data) 
				return 1;
			return 0;
		}
        
    }

}
