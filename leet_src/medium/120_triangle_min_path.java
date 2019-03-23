class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle == null || triangle.size() == 0) {
            return 0;
        }
        int length = triangle.size();
        int[] dp = new int[length];
        // 先取最后一行的值
        for(int i = 0; i < triangle.get(length - 1).size(); i ++) {
            dp[i] = triangle.get(length - 1).get(i);
        }
        //从最后一列开始往前，仅需要O(n)的空间复杂度
        List<Integer> list;
        for(int i = length - 2; i >= 0; i --) {
            list = triangle.get(i);
            for(int j = 0; j < list.size(); j ++) {
                dp[j] = min(dp[j], dp[j + 1]) + list.get(j);
            }
        }

        return dp[0];
    }

    private int min(int a, int b) {
        return a < b ? a : b;
    }
}
