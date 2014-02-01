package question;

import java.util.*;

/**
 * Created by siren0413 on 1/28/14.
 */
public class PascalTriangle {
    public static ArrayList<ArrayList<Integer>> generate(int numRows) {
        ArrayList<ArrayList<Integer>> totalList = new ArrayList<>();
        if (numRows == 0) return totalList;
        ArrayList<Integer> firstRow = new ArrayList<>();
        firstRow.add(1);
        totalList.add(firstRow);
        int n = 1;
        while (n < numRows) {
            ArrayList<Integer> upper = totalList.get(n - 1);
            ArrayList<Integer> newRow = new ArrayList<>();
            totalList.add(newRow);
            newRow.add(1);
            for (int i = 1; i < upper.size(); i++) {
                newRow.add(upper.get(i - 1) + upper.get(i));
            }
            newRow.add(1);
            n++;
        }
        return totalList;
    }

    public static void main(String[] args) {
        System.out.println(generate(5));
    }

}
