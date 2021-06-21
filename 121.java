// 121. Best Time to Buy and Sell Stock

class Solution {
    public int maxProfit(int[] prices) {
        int max = 0;
        int lowest = prices[0];
        for (int p : prices) {
            if (p < lowest) {
                lowest = p;
            }
            max = Math.max(max, p - lowest);
        }
        return max;
    }
}