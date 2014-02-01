package question;

/**
 * Created by siren0413 on 1/28/14.
 */
public class DistinctSubsequences {
    public static int numDistinct(String S, String T) {
        int[][] dp = new int[S.length()][T.length()];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }
        return numDistinctHelper(S, T, 0, 0, dp);
    }

    private static int numDistinctHelper(String S, String T, int i, int j, int[][] dp) {
        if (j == T.length()) return 1;
        if (i == S.length()) return 0;
        if (dp[i][j] != -1) return dp[i][j];
        int count = 0;
        if (S.charAt(i) == T.charAt(j))
            count = numDistinctHelper(S, T, i + 1, j, dp) + numDistinctHelper(S, T, i + 1, j + 1, dp);
        else count = numDistinctHelper(S, T, i + 1, j, dp);
        dp[i][j] = count;
        return count;
    }

    public static void main(String[] args) {
        System.out.println(numDistinct("rabbbit", "rabbit"));
    }
}
