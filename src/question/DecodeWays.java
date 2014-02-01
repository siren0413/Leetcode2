package question;

/**
 * Created by siren0413 on 1/30/14.
 */
public class DecodeWays {
    public static int numDecodings(String s){
        if(s.isEmpty()) return 0;
        int[] dp = new int[s.length()];
        for(int i = 0; i < dp.length; i++) dp[i]=-1;
        return numDecodingsHelper(s,0,dp);
    }

    private static int numDecodingsHelper(String s, int i , int[] dp){
        if(i == s.length()) return 1;
        if(dp[i] != -1) return dp[i];
        int first=0, second = 0;
        if(i+1 <= s.length() && s.charAt(i)!='0')
            first = numDecodingsHelper(s,i+1,dp);
        if(i+2 <= s.length() && s.charAt(i)!='0' && Integer.valueOf(s.substring(i,i+2))<=26)
            second = numDecodingsHelper(s,i+2,dp);
        dp[i] = first + second;
        return dp[i];
    }


    public static void main(String[] args){
        System.out.println(numDecodings("0"));
    }
}
