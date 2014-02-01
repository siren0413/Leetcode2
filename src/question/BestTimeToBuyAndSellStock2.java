package question;

/**
 * Created by siren0413 on 1/28/14.
 */
public class BestTimeToBuyAndSellStock2 {
    public static int maxProfit(int[] prices) {
        if (prices.length == 0 || prices.length == 1) return 0;
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            max += prices[i] - prices[i - 1] > 0 ? prices[i] - prices[i - 1] : 0;
        }
        return max;
    }

    public static void main(String[] args){
        int[] prices = {3, 1, 2, 5, 0, 2, 4, 2, 7};
        System.out.println(maxProfit(prices));
    }
}
