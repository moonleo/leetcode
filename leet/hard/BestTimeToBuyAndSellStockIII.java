package leet.hard;

public class BestTimeToBuyAndSellStockIII {

	public static void main(String[] args) {

	}
	
	public int maxProfit(int[] prices) {
        if(null == prices || 0 == prices.length) {
            return 0;
        }
        int length = prices.length;
        int[] firMaxPro = new int[length];//记录从前到第i个位置可以获得的最大收益
        int[] secMaxPro = new int[length];//记录从后到第i个位置可以获得的最大收益
        int minPre = prices[0];
        for(int i=1; i<length; i++) {
            minPre = Math.min(minPre, prices[i]);
            firMaxPro[i] = Math.max(prices[i]-minPre, firMaxPro[i-1]);
        }
        
        int maxPost = prices[length-1];
        for(int i=length-2; i>=0; i--) {
            maxPost = Math.max(maxPost, prices[i+1]);
            secMaxPro[i] = Math.max(maxPost-prices[i], secMaxPro[i+1]);
        }
        //记录最后的结果
        int maxPro = 0x80000000;
        for(int i=0; i<length; i++) {
            maxPro = Math.max(firMaxPro[i] + secMaxPro[i], maxPro);
        }
        return maxPro;
    }

}
