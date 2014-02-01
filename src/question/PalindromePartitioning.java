package question;

import java.util.*;

/**
 * Created by siren0413 on 1/27/14.
 */
public class PalindromePartitioning {
    public static ArrayList<ArrayList<String>> partition(String s){
        ArrayList<ArrayList<String>> totalList = new ArrayList<>();
        if(s.isEmpty()) return totalList;
        ArrayList<String> subList = new ArrayList<>();
        partitionHelper(s,0,subList,totalList);
        return totalList;
    }

    private static void partitionHelper(String s, int index, ArrayList<String> subList, ArrayList<ArrayList<String>> totalList){
        if(index == s.length()){
            ArrayList<String> copy = new ArrayList<>(subList);
            totalList.add(copy);
            return;
        }
        for(int i = index+1; i < s.length()+1; i++){
            String sub = s.substring(index,i);
            if(isPalindrome(sub)){
                subList.add(sub);
                partitionHelper(s,i,subList,totalList);
                subList.remove(subList.size()-1);
            }
        }
    }

    private static boolean isPalindrome(String s){
        int start = 0, end = s.length()-1;
        while(start < end){
            if(s.charAt(start)!=s.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args){
        String s = "aab";
        System.out.println(partition(s));
    }
}
