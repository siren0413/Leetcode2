package question;

import java.util.*;

/**
 * Created by siren0413 on 1/28/14.
 */
public class Triangle {
    public static int minimumTotal(ArrayList<ArrayList<Integer>> triangle){
        if(triangle.size() == 0) return 0;
        for(int i = triangle.size()-1; i > 0; i--){
            ArrayList<Integer> upper = triangle.get(i-1);
            ArrayList<Integer> lower = triangle.get(i);
            for(int j = 0 ; j <upper.size();j++){
                upper.set(j, Math.min(lower.get(j), lower.get(j+1)) + upper.get(j));
            }
        }
        int min = Integer.MAX_VALUE;
        for(int i : triangle.get(0)) min = Math.min(min,i);
        return min;
    }





    public static void main(String[] args){
        ArrayList<ArrayList<Integer>> triangle = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> list0 = new ArrayList<Integer>();
        ArrayList<Integer> list1 = new ArrayList<Integer>();
        ArrayList<Integer> list2 = new ArrayList<Integer>();
        ArrayList<Integer> list3 = new ArrayList<Integer>();
        list0.add(2);
        list1.add(3);list1.add(4);
        list2.add(6);list2.add(5);list2.add(7);
        list3.add(4);list3.add(1);list3.add(8);list3.add(3);
        triangle.add(list0);
        triangle.add(list1);
        triangle.add(list2);
        triangle.add(list3);

        int result = minimumTotal(triangle);
        System.out.println(result);
    }
}
