package question;

import java.util.Arrays;

/**
 * Created by siren0413 on 1/27/14.
 */
public class Candy {
    public static int candy(int[] ratings) {
        int[] candy = new int[ratings.length];
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) candy[i] = Math.max(candy[i],candy[i - 1] + 1);
        }
        int sum = 0;
        for (int i = ratings.length - 1; i >= 1; i--) {
            if (ratings[i - 1] > ratings[i]) candy[i - 1] = Math.max(candy[i-1],candy[i] + 1);
            sum += candy[i];
        }
        sum+= candy[0];
        return sum + candy.length;
    }

    public static void main(String[] args){
        int[] ratings = {4,2,3,4,1};
        System.out.println(candy(ratings));
    }
}
