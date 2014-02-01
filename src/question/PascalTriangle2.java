package question;

import java.util.*;

/**
 * Created by siren0413 on 1/28/14.
 */
public class PascalTriangle2 {
    public static ArrayList<Integer> getRow(int rowIndex){
        if(rowIndex <0) return new ArrayList<>();
        ArrayList<Integer> upper = new ArrayList<>();
        upper.add(1);
        while(rowIndex > 0){
            ArrayList<Integer> lower = new ArrayList<>();
            lower.add(1);
            for(int i = 1; i < upper.size(); i++){
                lower.add(upper.get(i-1) + upper.get(i));
            }
            lower.add(1);
            upper = lower;
            rowIndex--;
        }
        return upper;
    }

    public static void main(String[] args){
        System.out.println(getRow(0));
    }
}
