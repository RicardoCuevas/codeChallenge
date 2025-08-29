//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
//122. Best Time to Buy and Sell Stock II


public class MaxProfit {

    public static void main(String[] args) {
        int[] prices1 = {7,1,5,3,6,4}; //7
        int[] prices2 = {1,2,3,4,5}; //4
        int[] prices3 = {7,6,4,3,1}; //0
        int[] prices4 = {6,1,3,2,4,7}; //7
        System.out.println(maxProfit2(prices1));
        System.out.println(maxProfit2(prices2));
        System.out.println(maxProfit2(prices3));
        System.out.println(maxProfit2(prices4));
    }

    public static int maxProfit(int[] prices){
        int buy=0;
        int sell = 0;
        int profit=0;
        boolean isBuying = true;
        for (int i=0; i<prices.length; i++){
            for (int j=i+1; j<prices.length; j++){
                if(!isBuying && prices[i]>prices[j]){
                    sell = prices[i];
                    isBuying = true;
                } else if(isBuying && prices[j]>prices[i]){
                   buy = prices[i];
                   isBuying=false;
                }
                if (buy!=0 && sell!=0){
                    profit += sell - buy;
                    buy = 0;
                    sell = 0;
                }
            }
        }
        if(buy!=0 && sell==0){
             profit = prices[prices.length-1] - buy;
        }
        return profit;
    }

    public static int maxProfit2(int[] prices){
        int profit = 0;
        for (int i=0; i<prices.length-1; i++){
            if((prices[i+1] - prices[i]) > 0){
                profit += prices[i+1] - prices[i];
            }
        }
        return profit;
    }

    public static int maxProfit3(int[] prices){
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i=0; i<prices.length; i++){
            min = Math.min(min, prices[i]);
            max = Math.max(max, prices[i]);
        }
        System.out.println("max = " + max);
        System.out.println("min = " + min);
        return max - min;
    }
}

/*
You are given an integer array prices where prices[i] is the price of a given stock on the ith day.

On each day, you may decide to buy and/or sell the stock. You can only hold at most one share of the stock at any time. However, you can buy it then immediately sell it on the same day.

Find and return the maximum profit you can achieve.



Example 1:

Input: prices = [7,1,5,3,6,4]
Output: 7
Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
Total profit is 4 + 3 = 7.
Example 2:

Input: prices = [1,2,3,4,5]
Output: 4
Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
Total profit is 4.
Example 3:

Input: prices = [7,6,4,3,1]
Output: 0
Explanation: There is no way to make a positive profit, so we never buy the stock to achieve the maximum profit of 0.


Constraints:

1 <= prices.length <= 3 * 104
0 <= prices[i] <= 104
* */