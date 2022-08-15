//Leetcode Q-122
//Best Time to Buy and Sell Stock II
//Approach 1
class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length <= 1 || prices == null)
            return 0;
        int profit = 0;
        
        for(int i=1; i<prices.length; i++) {
            if(prices[i-1] < prices[i])
                profit += prices[i] - prices[i-1];
        }
        return profit;
    }
}

//Approach 2
class Solution {
    public int maxProfit(int[] prices) {
        int cost = prices[0];
        int maxProfit = 0;
        
        for(int i=1; i<prices.length; i++) {
            int profit = prices[i] - cost;
            if(profit > 0)  maxProfit += profit;
            cost = prices[i];
        }
        return maxProfit;
    }
}