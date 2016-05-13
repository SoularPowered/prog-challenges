/*
121. Best Time to Buy and Sell Stock
Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (ie, buy one and sell 
one share of the stock), design an algorithm to find the maximum profit.
*/

public class Solution {
    public int maxProfit(int[] prices) {
        int days = prices.length, 
            maxProfit = 0, 
            highestSalePrice = 0,
            profit;

        for (int i = days - 1; i >= 0; i--) {
            highestSalePrice = (prices[i] > highestSalePrice) ? prices[i] : highestSalePrice;
            profit = highestSalePrice - prices[i];
            maxProfit = (profit > maxProfit) ? profit : maxProfit;
        }
        
        return maxProfit;
    }
}
