package question;

/**
 * Created by siren0413 on 1/29/14.
 */
public class UniqueBinarySearchTrees {
    // recursive DP
    public static int numTrees(int n){
        int[] dp = new int[n+1];
        return numTreesHelper(n,dp);
    }
    private static int numTreesHelper(int n, int[] dp){
        if(n ==0) return 1;
        if(n == 1) return 1;
        if(dp[n] > 0) return dp[n];
        for(int i = 0; i < n; i++){
            dp[n] += numTreesHelper(i,dp) * numTreesHelper(n-1-i,dp);
        }
        return dp[n];
    }

    // iterative DP
    public static int numTrees2(int n){
        int[] dp = new int[n+1];
        dp[0] = 1; dp[1] = 1;
        for(int i = 2 ; i <= n; i++ ){
            for(int j = 0; j < i; j++){
                dp[i] += dp[j]*dp[i-1-j];
            }
        }
        return dp[n];
    }


    public static void main(String[] args){
        System.out.println(numTrees2(3));
    }
}
