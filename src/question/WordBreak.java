package question;

import java.util.*;

/**
 * Created by siren0413 on 1/26/14.
 */
public class WordBreak {
    public static boolean wordBreak(String s, Set<String> dict){
        boolean[] dp = new boolean[s.length()+1];
        for(int i = 0; i < s.length()+1; i++){
            for(int j = 0; j < i; j++){
                if(dict.contains(s.substring(j, i))){
                    if(j==0) dp[i] = true;
                    else if(dp[j]) dp[i] = true;
                }
            }
        }
        return dp[s.length()];
    }

    public static boolean wordBreak2(String s, Set<String> dict){
        boolean[] table = new boolean[s.length()+1];
        table[0] = true;
        for(int i = 0; i < table.length; i++){
            if(!table[i])continue;
            for(int j = i+1; j < s.length()+1; j++){
                if(dict.contains(s.substring(i, j))) table[j] = true;
            }
        }
        return table[s.length()];
    }

    public static void main(String[] args){
        String s = "leetcode";
        Set<String> dict = new HashSet<>();
        dict.add("leet");
        dict.add("code");
        System.out.println(wordBreak(s,dict));
    }
}
