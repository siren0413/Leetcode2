package question;

/**
 * Created by siren0413 on 1/27/14.
 */
public class PalindromePartitioning2 {
    public static int minCut(String s) {
        int[] dp = new int[s.length()+1];
        boolean[][] palindrome = new boolean[s.length()][s.length()];
        for(int i = 0; i < dp.length; i++) dp[i] = s.length()-i;
        for(int i = s.length()-1; i>=0; i--){
            for(int j = i; j < s.length(); j++){
                if(s.charAt(i)==s.charAt(j) && (j-i<2 || palindrome[i+1][j-1])){
                    palindrome[i][j] = true;
                    dp[i] = Math.min(dp[i],dp[j+1]+1);
                }
            }
        }
        return dp[0]-1;
    }

    public static void main(String[] args) {
        String s = "cabababcbc";
        System.out.println(minCut(s));
    }
}
