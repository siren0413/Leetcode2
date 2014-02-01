package question;

import java.util.Arrays;

/**
 * Created by siren0413 on 1/29/14.
 */
public class InterleavingString {

    // recursive DP
    public static boolean isInterleave(String s1, String s2, String s3){
        int[][] dp = new int[s1.length()+1][s2.length()+1];
        return isInterleaveHelper(s1,s2,s3,0,0,0, dp);
    }
    private static boolean isInterleaveHelper(String s1, String s2, String s3, int i, int j, int k, int[][] dp){
        if(k ==s3.length()){
            if( i==s1.length() && j ==s2.length()) return true;
            return false;
        }
        char c = s3.charAt(k);
        if(dp[i][j] ==1) return true;
        if(dp[i][j] ==2) return false;
        boolean result =  (i<s1.length() &&s1.charAt(i) == c?isInterleaveHelper(s1,s2,s3,i+1,j,k+1,dp):false) || (j<s2.length() && s2.charAt(j) == c?isInterleaveHelper(s1,s2,s3,i,j+1,k+1,dp):false);
        dp[i][j] = result?1:2;
        return result;
    }


    // iterator DP
    public static boolean isInterleave2(String s1, String s2, String s3){
        if(s1.length() + s2.length()!=s3.length()) return false;
        boolean[][] dp = new boolean[s1.length()+1][s2.length()+1];
        dp[0][0] = true;
        for(int i = 1; i < s1.length()+1; i++) if(s1.charAt(i-1) == s3.charAt(i-1)) dp[i][0] = true;
        for(int i = 1; i < s2.length()+1; i++) if(s2.charAt(i-1) == s3.charAt(i-1)) dp[0][i] = true;
        for(int i = 1; i < dp.length; i++){
            for(int j = 1; j < dp[0].length; j++){
                if(dp[i][j-1] && s2.charAt(j-1)== s3.charAt(i+j-1)) dp[i][j] = true;
                if(dp[i-1][j] && s1.charAt(i-1) == s3.charAt(i+j-1)) dp[i][j] = true;
            }
        }
        return dp[s1.length()][s2.length()];
    }

    public static void main(String[] args) {
        String s1 = "a";
        String s2 = "";
        String s3 = "a";
        System.out.println(isInterleave2(s1, s2, s3));
    }
}
