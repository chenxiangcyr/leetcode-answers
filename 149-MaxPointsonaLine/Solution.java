/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
class Solution {
public int maxPoints(Point[] points) {
    if (points.length < 2) return points.length;
    int max = 2;
    for (Point p1 : points) {
        Map<Integer, Integer> slopes = new HashMap<>(points.length);
        int localMax = 0;
        for (Point p2 : points) {
            int num = p2.y - p1.y;
            int den = p2.x - p1.x;
            
            // pairing functions only work with non-negative integers
            // we store the sign in a separate variable
            int sign = 1;
            if ((num > 0 && den < 0) || (num < 0 && den > 0)) sign = -1;
            num = Math.abs(num);
            den = Math.abs(den);
            
            // pairing functions represent a pair of any two integers uniquely;
            // they can be used as hash functions for any sequence of integers;
            // therefore, a pairing function from 1/2 doesn't equal to that from 3/6
            // even though the slope 1/2 and 3/6 is the same.
            // => we need to convert each fraction to its simplest form, i.e. 3/6 => 1/2
            int gcd = GCD(num, den);
            num = gcd == 0 ? num : num / gcd;
            den = gcd == 0 ? den : den / gcd;
            
            // We can use Cantor pairing function pi(k1, k2) = 1/2(k1 + k2)(k1 + k2 + 1) + k2
            // and include the sign
            int m = sign * (num + den) * (num + den + 1) / 2 + den;
            if (slopes.containsKey(m)) slopes.put(m, slopes.get(m)+1);
            else slopes.put(m, 1);
            if (m == 0) continue;
            
            localMax = Math.max(slopes.get(m),localMax);
        }
        max = Math.max(max, localMax + slopes.get(0));
    }
    return max;
}

public int GCD(int a, int b) {
   if (b == 0) return a;
   return GCD(b,a % b);
}
}
