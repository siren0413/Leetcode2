package question;

import java.util.*;


/**
 * Created by siren0413 on 1/27/14.
 */
public class WordLadder {
    //BFS
    public static int ladderLength(String start, String end, HashSet<String> dict) {
        int min = 0;
        Set<String> visit = new HashSet<>();
        Set<String> endSet = neighbors(end,dict);
        Queue<String> queue = new LinkedList<>();
        queue.add(start);
        while(!queue.isEmpty()){
            Queue<String> subQ = new LinkedList<>();
            while(!queue.isEmpty()){
                String s = queue.poll();
                if(visit.contains(s)) continue;
                visit.add(s);
                if(endSet.contains(s)) return min+2;
                Set<String> neighbors = neighbors(s,dict);
                for(String str: neighbors) subQ.add(str);
            }
            min++;
            queue = subQ;
        }
        return 0;
    }


    private static Set<String> neighbors(String a, Set<String> dict){
        Set<String> set = new HashSet<>();
        for(int i = 0 ; i < a.length(); i++){
            for(int j = 0; j < 26; j++){
                char[] arr = a.toCharArray();
                arr[i] = (char)('a'+j);
                String temp = new String(arr);
                if(dict.contains(temp)) set.add(temp);
            }
        }
        return set;
    }





//    public static int ladderLength(String start, String end, HashSet<String> dict){
//        if(start.isEmpty() || end.isEmpty()) return 0;
//        Set<String> subSet = new HashSet<>();
//        return ladderLengthHelper(start,end,dict,subSet);
//    }
//
//    private static int ladderLengthHelper(String start, String end, HashSet<String> dict, Set<String> subSet){
//        if(start.equals(end)) return 0;
//        int min = dict.size()+1;
//        for(String s: dict){
//            if(subSet.contains(s)) continue;
//            if(diffByOne(start, s)){
//                subSet.add(s);
//                int len = ladderLengthHelper(s,end,dict,subSet) + 1;
//                if(len < min) min = len;
//                subSet.remove(s);
//            }
//        }
//        return min;
//    }
//
//    private static boolean diffByOne(String a, String b){
//        int diff = 0;
//        for(int i = 0; i < a.length(); i++){
//            if(a.charAt(i)!=b.charAt(i)) diff++;
//            if(diff > 1) return false;
//        }
//        return true;
//    }

    public static void main(String[] args) {
        String start = "hot";
        String end = "dog";
        HashSet<String> dict = new HashSet<>();
        dict.add("hot");
        dict.add("dog");
//        dict.add("dog");
//        dict.add("lot");
//        dict.add("log");
        System.out.println(ladderLength(start, end, dict));

    }

}
