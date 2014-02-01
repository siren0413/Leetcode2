package question;

import java.util.*;

/**
 * Created by siren0413 on 1/27/14.
 */
public class WordLadder2 {
    public static ArrayList<ArrayList<String>> findLadders(String start, String end, HashSet<String> dict) {
        boolean flag = false;
        ArrayList<ArrayList<String>> list = new ArrayList<>();
        Map<String,Set<String>> neighborMap = new HashMap<>();
        for(String s: dict) neighborMap.put(s,neighbors(s,dict));
        neighborMap.put(start, neighbors(start,dict));
        neighborMap.put(end, neighbors(end,dict));
        Set<String> visit = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(start);
        while (!queue.isEmpty()) {
            Queue<String> subQ = new LinkedList<>();
            ArrayList<String> sub = new ArrayList<>();
            while (!queue.isEmpty()) {
                String s = queue.poll();
                if (visit.contains(s)) continue;
                visit.add(s);
                sub.add(s);
                if (neighborMap.get(end).contains(s)) flag = true;
                Set<String> neighbors = neighborMap.get(s);
                for (String str : neighbors) subQ.add(str);
            }
            list.add(sub);
            if (flag) break;
            queue = subQ;
        }
        ArrayList<String> endList = new ArrayList<>();
        endList.add(end);
        list.add(endList);
        ArrayList<ArrayList<String>> totalList = new ArrayList<>();
        ArrayList<String> subList = new ArrayList<>();
        findLaddersHelper( 0, subList, list, totalList, dict, neighborMap);
        return totalList;
    }

    private static void findLaddersHelper(int index, ArrayList<String> subList, ArrayList<ArrayList<String>> list, ArrayList<ArrayList<String>> totalList, HashSet<String> dict, Map<String,Set<String>> neighborMap) {
        if (subList.size() == list.size()) {
            totalList.add(new ArrayList<String>(subList));
            return;
        }
        ArrayList<String> strs = list.get(index);
        for (String s : strs) {
            if (subList.isEmpty()) {
                subList.add(s);
                findLaddersHelper(index + 1, subList, list, totalList, dict, neighborMap);
                subList.remove(subList.size() - 1);
            } else if (neighborMap.get(subList.get(subList.size()-1)).contains(s) || neighborMap.get(s).contains(subList.get(subList.size()-1))) {
                subList.add(s);
                findLaddersHelper(index + 1, subList, list, totalList, dict, neighborMap);
                subList.remove(subList.size() - 1);
            }
        }
    }

    private static Set<String> neighbors(String a, Set<String> dict) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < a.length(); i++) {
            for (int j = 0; j < 26; j++) {
                char[] arr = a.toCharArray();
                arr[i] = (char) ('a' + j);
                String temp = new String(arr);
                if (dict.contains(temp)) set.add(temp);
            }
        }
        return set;
    }

    public static void main(String[] args) {
        String start = "hit";
        String end = "cog";
        HashSet<String> dict = new HashSet<>();
        dict.add("hot");
        dict.add("dot");
        dict.add("dog");
        dict.add("lot");
        dict.add("log");
        System.out.println(findLadders(start, end, dict));

    }
}
