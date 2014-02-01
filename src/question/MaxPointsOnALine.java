package question;

import beans.Point;

import java.util.*;

/**
 * Created by siren0413 on 1/26/14.
 */
public class MaxPointsOnALine {
    public static int maxPoints(Point[] points) {
        if (points.length == 0) return 0;
        Map<Double, Integer> map = new HashMap<>();
        int max = 0;
        for (int i = 0; i < points.length; i++) {
            int sameCount = 0;
            for (int j = i + 1; j < points.length; j++) {
                double slope = 0.0;
                if (points[i].x == points[j].x && points[i].y == points[j].y) {
                    sameCount++;
                    continue;
                }
                if (points[i].x == points[j].x) slope = Double.MAX_VALUE;
                else if (points[i].y == points[j].y) slope = 0;
                else slope = (double)(points[i].y - points[j].y) / (points[i].x - points[j].x);
                if (!map.containsKey(slope)) map.put(slope, 1);
                else map.put(slope, map.get(slope) + 1);
            }
            if (map.isEmpty()) {
                if (sameCount > max) max = sameCount;
            } else {
                for (Integer n : map.values()) {
                    if (n + sameCount > max) max = n + sameCount;
                }
            }
            map.clear();
        }
        return max + 1;
    }



    public static void main(String[] args) {
        Point[] points = {
                new Point(84, 250),
                new Point(0, 0),
                new Point(1,0),
                new Point(0,-70),
                new Point(0,-70),
                new Point(1,-1),
                new Point(21,10),
                new Point(42,90),
                new Point(-42,-230)
//                new Point(0,-70),
//                new Point(0,-70),
//                new Point(1,-1),
//                new Point(21,10),
//                new Point(43,90),
//                new Point(-42,-230)
//				new Point(0,0),
//				new Point(1,1),
//				new Point(1,-1)
        };

        int result = maxPoints(points);
        System.out.println(result);
    }
}
