package question;

import java.util.*;

/**
 * Created by siren0413 on 1/30/14.
 */
public class Subset2 {
    public static ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num){
        if(num.length ==0) return new ArrayList<>();
        Arrays.sort(num);
        Set<ArrayList<Integer>> totalSet = new HashSet<>();
        ArrayList<Integer> subList = new ArrayList<>();
        subsetsWithDupHelper(num,0,subList,totalSet);
        return new ArrayList<>(totalSet);
    }

    private static void subsetsWithDupHelper(int[] num, int i, ArrayList<Integer> subList, Set<ArrayList<Integer>> totalSet){
        if(i>=num.length){
            totalSet.add(new ArrayList<Integer>(subList));
            return;
        }
        // not choose current num[i]
        subsetsWithDupHelper(num,i+1,subList,totalSet);

        // choose current num[i]
        subList.add(num[i]);
        subsetsWithDupHelper(num,i+1,subList,totalSet);
        subList.remove(subList.size()-1);
    }




    public static void main(String[] args){
        int[] num = {1,2,2};
        System.out.println(subsetsWithDup(num));
    }
}
