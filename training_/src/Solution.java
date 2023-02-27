// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

/*
Example test:   [1, 3, 6, 4, 1, 2]
Example test:   [1, 1, 2, 3, 4, 6]

Example test:   [1, 2, 3]

Example test:   [-1, -3]
 */

import java.util.Arrays;

class Solution {
    public int solution(int[] A) {
        Arrays.sort(A);
        int smallestPositive = 1;
        for (int i = 0; i < A.length; i++) {
            int currentElement = A[i];
            if (currentElement == smallestPositive) {
                smallestPositive++;
            }
        }
/*      LUB
        int N = A.length;
        Set<Integer> set = new HashSet<>();
        for (int a : A) {
            if (a > 0) {
                set.add(a);
            }
        }
        for (int i = 1; i <= N + 1; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }*/

        /* LUB chatGPT

            // create a set to store the unique elements of A
            Set<Integer> set = new HashSet<>();
            // add all the elements of A to the set
            for (int a : A) {
              set.add(a);
            }
            // initialize result to 1
            int result = 1;
            // loop until we find a number that is not in the set
            while (set.contains(result)) {
              result++;
            }
            // return the first number that is not in the set
            return result;

         */

        return smallestPositive;
    }
}
