package leet.easy;

/**
 * No.70 Climbing Stairs
 * You are climbing a stair case. It takes n steps to reach 
 * to the top. Each time you can either climb 1 or 2 steps. 
 * In how many distinct ways can you climb to the top? 
 */
public class ClimbingStairs {

	public static void main(String[] args) {
		System.out.println(new ClimbingStairs().climbStairs(1));
		System.out.println(new ClimbingStairs().climbStairs(3));
		System.out.println(new ClimbingStairs().climbStairs(10));
	}
	
	public int climbStairs(int n) {
        if(1 >= n) {
            return n;
        }
        //即Fibonacci数列，用迭代法求解
        int a = 0, b = 1;
        int res = 0;
        for(int i=0; i<n; i++) {
            res = a + b;
            a = b;
            b = res;
        }
        return res;
    }

}
