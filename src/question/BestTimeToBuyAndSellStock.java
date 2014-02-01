package question;

/**
 * Created by siren0413 on 1/28/14.
 */
public class BestTimeToBuyAndSellStock {
    public static int maxProfit(int[] prices) {
        if (prices.length == 0 || prices.length == 1) return 0;
        int max = 0, buy = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < buy) buy = prices[i];
            else if(prices[i] - buy > max) max = prices[i] - buy;
        }
        return max;
    }

    public static void main(String[] args){
        int[] prices = {3, 1, 2, 5, 0, 2, 4, 2, 7};
        System.out.println(maxProfit(prices));
    }
}
