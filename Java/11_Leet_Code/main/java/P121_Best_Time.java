public class P121_Best_Time {

    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int profit = 0;
        for (int i = 0; i < prices.length; i++) {
            int currPrice = prices[i];
            if (minPrice > currPrice) {
                minPrice = currPrice;
            } else {
                int currProfit = currPrice - minPrice;
                if (profit < currProfit) {
                    profit = currProfit;
                }
            }

        }
        return profit;
    }
}
