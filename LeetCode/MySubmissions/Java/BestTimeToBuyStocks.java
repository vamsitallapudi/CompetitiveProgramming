public class BestTimeToBuyStocks {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            }
            int currPriceDiff = prices[i] - minPrice;
            if (currPriceDiff > maxProfit) {
                maxProfit = currPriceDiff;
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        BestTimeToBuyStocks b = new BestTimeToBuyStocks();
        int[] myNum = { 7, 1, 5, 3, 6, 4 };
        System.out.println(b.maxProfit(myNum));
    }
}
