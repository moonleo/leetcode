package leet.medium;

/**
 * No.121 Best Time to Buy and Sell Stock
 * Say you have an array for which the ith element is the price of a given stock on day i. 
 * If you were only permitted to complete at most one transaction (ie, buy one and sell 
 * one share of the stock), design an algorithm to find the maximum profit.
 *
 */
public class BestTimetoBuyandSellStock {

	public static void main(String[] args) {

	}
	
	public int maxProfit(int[] prices) {
        if(null == prices || prices.length == 0) {
            return 0;
        }
        int length = prices.length;
        int[] buyMin = new int[length];
        buyMin[0] = prices[0];
        for(int i=1; i<length; i++) {
            buyMin[i] = Math.min(buyMin[i-1], prices[i]);
        }
        int[] sellMax = new int[length];
        sellMax[length-1] = prices[length-1];
        for(int i=length-2; i>=0; i--) {
            sellMax[i] = Math.max(sellMax[i+1], prices[i]);
        }
        int max = 0x80000000;
        for(int i=0; i<length; i++) {
            max = Math.max(max, sellMax[i]-buyMin[i]);
        }
        return max;
    }

}
