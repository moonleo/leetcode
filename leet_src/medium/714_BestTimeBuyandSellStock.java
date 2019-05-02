class Solution {
    public int maxProfit(int[] prices, int fee) {
        if(prices.length < 2) {
            return 0;
        }
        int len = prices.length;
        //the i th day have buy a stoke
        int[] hasStock = new int[len];
        //the i th day does not have a stoke
        int[] noStock = new int[len];
        hasStock[0] = -prices[0];
        noStock[0] = 0;
        for(int i = 1; i < len; i ++) {
            hasStock[i] = Math.max(hasStock[i-1], noStock[i-1]-prices[i]);
            noStock[i] = Math.max(noStock[i-1], hasStock[i-1] + prices[i] - fee);
        }
        return noStock[len - 1];
    }
}
