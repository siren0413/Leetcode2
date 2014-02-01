package question;

import java.util.*;

/**
 * Created by siren0413 on 1/27/14.
 */
public class LongestConsecutiveSequence {
    public static int longestConsecutive(int[] num) {
        if (num.length == 0) return 0;
        Set<Integer> set = new HashSet<>();
        for (int i : num) set.add(i);
        int max = 0;
        for (int i = 0; i < num.length; i++) {
            int j = num[i]+1, sum = 0;
            while (set.contains(j)) {
                set.remove(j);
                sum++;
                j++;
            }
            j = num[i];
            while (set.contains(j)) {
                set.remove(j);
                sum++;
                j--;
            }
            if (sum  > max) max = sum ;
        }
        return max;
    }

    public static void main(String[] args){
        int[] num = {100,4,200,1,3,2};
        System.out.println(longestConsecutive(num));
    }
}
