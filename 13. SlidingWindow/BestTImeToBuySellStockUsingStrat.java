public class BestTImeToBuySellStockUsingStrat {
    public long maxProfit(int[] prices, int[] strategy, int k) {

        long[] profits = new long[prices.length];
        long ogprofit = 0;
        for(int i = 0; i<prices.length; i++){
            long profit = (long)prices[i] * strategy[i];
            profits[i] = profit;
            ogprofit += profit;
        }

        
        long maxgain = 0;
        long ogWindowProfit = 0;
        long modifiedWindowProfit = 0;

        int i = 0;
        int j = 0;

        while(j < prices.length){

            ogWindowProfit += profits[j];

            if(j-i+1 > k/2){
                modifiedWindowProfit += prices[j];
            }

            if(j-i+1 > k){
                ogWindowProfit -= profits[i];
                modifiedWindowProfit -= prices[i+k/2];
                i++;
            }

            if(j-i+1 == k){
                maxgain = Math.max(maxgain, modifiedWindowProfit-ogWindowProfit);
            }

            j++;
        }

        long mxProfit = ogprofit +  maxgain;
        return mxProfit;
    }



    public static void main(String[] args) {
        BestTImeToBuySellStockUsingStrat ob = new BestTImeToBuySellStockUsingStrat();
        int [] prices = {5, 5, 20, 10, 40};
        int[] strategy = {1, 1, -1, -1, -1};
        int k = 4;

        long ans = ob.maxProfit(prices, strategy, k);
        System.out.println(ans); //55
    }
}
