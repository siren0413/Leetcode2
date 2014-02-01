package question;

import java.util.*;

/**
 * Created by siren0413 on 1/30/14.
 */
public class GrayCode {
    public static ArrayList<Integer> grayCode(int n){
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0 ; i < Math.pow(2,n); i++){
            list.add(binaryToGray(i));
        }
        return list;
    }

    private static int binaryToGray(int n){
        return (n>>1)^n;
    }
}
