package question;

import java.util.*;

/**
 * Created by siren0413 on 1/26/14.
 */
public class WordBreak2 {

    // DP
    public static ArrayList<String> wordBreak(String s, Set<String> dict) {
        ArrayList<String> totalList = new ArrayList<>();
        if(s.isEmpty()) return totalList;
        ArrayList<String> subList = new ArrayList<>();
        ArrayList<ArrayList<Integer>> table = new ArrayList<>();
        for (int i = 0; i < s.length()+1; i++) table.add(new ArrayList<Integer>());
        for (int i = 0; i < s.length() + 1; i++) {
            for (int j = 0; j < i; j++) {
                if (dict.contains(s.substring(j, i))) {
                    if (j == 0)
                        table.get(i).add(j);
                    else if (table.get(j).size() > 0)
                        table.get(i).add(j);
                }
            }
        }
        wordBreakHelper(s,s.length(),subList,totalList,table);
        return totalList;
    }

    // backtracking
    private static void wordBreakHelper(String s, int index, ArrayList<String> subList, ArrayList<String> totalList, ArrayList<ArrayList<Integer>> table){
        if(index == 0){
            StringBuilder sb = new StringBuilder();
            for(String str: subList){
                sb.insert(0,str).insert(0," ");
            }
            totalList.add(sb.toString().trim());
            return;
        }
        ArrayList<Integer> indexList = table.get(index);
        for(int i = 0; i < indexList.size(); i++){
            int preIndex = indexList.get(i);
            subList.add(s.substring(preIndex,index));
            wordBreakHelper(s,preIndex,subList,totalList,table);
            subList.remove(subList.size()-1);
        }
    }


    public static void main(String[] args) {
        String s = "catsanddog";
        Set<String> dict = new HashSet<>();
        dict.add("cat");
        dict.add("cats");
        dict.add("and");
        dict.add("sand");
        dict.add("dog");
        System.out.println(wordBreak(s, dict));
    }
}
