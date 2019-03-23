class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        if(A == null || A.length == 0) {
            return 0;
        }
        int length = A.length;
        int[] dp = new int[length - 1];
        for(int i = 0; i < dp.length; i ++) {
            dp[i] = A[i + 1] - A[i];
        }
        int result = 0;
        int index = 1;
        int count = 1;
        while(index < dp.length) {
            if(dp[index] == dp[index - 1]) {
                count ++;
            } else {
                result += count(count);
                count = 1;
            }
            index ++;
        }
        if(count > 1) {
            result += count(count);
        }
        return result;
    }

    private int count(int n) {
        int tmp = n - 1;
        int sum = 0;
        while(tmp > 0) {
            sum += tmp;
            tmp --;
        }
        return sum;
    }
}
