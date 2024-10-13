package random.leetcode.mathematics;

import java.util.Arrays;

// Replace class name with "Solution" when submit it to LeetCode
class FindGreatestCommonDivisorOfArray {

    //Define Approaches
    enum Approach {
        FIRST_APPROACH,
        SECOND_APPROACH,
        THIRD_APPROACH,
    }

    // Input the approach you want to execute.
    private static final Approach approach = Approach.FIRST_APPROACH;


    // Maintain the actual method name provided by LeetCode to avoid any error during submission time
    public int findGCD(int[] n) {
        if (approach.equals(Approach.FIRST_APPROACH)) {
            return Approach_1(n);
        }
//        else if (approach.equals(Approach.SECOND_APPROACH)) {
//            return Approach_Your_Approach_Number(your_inputs);
//        }
//        else if (approach.equals(Approach.THIRD_APPROACH)) {
//            return Approach_Your_Approach_Number(your_inputs);
//        }
        return 0;
    }

    // Approach_1: Euclid Theorem,  Time Complexity -> O(nlogn) for (Arrays.sort()) + O(log(min(a,b)) for (GCD calculation) = O(nlogn) ,, and Space Complexity -> O(1)
    // Outcome: ACCEPTED
    /*
     ---------------------------------------------------------------------- NOTE ----------------------------------------------------------------------
     * Make a short note on your approach

     */

    /*
     ---------------------------------------------------------------------- Algorithm ----------------------------------------------------------------------
     * Write an algorithm on your approach.
     => Euclid Theorem
    */
    private int Approach_1(int[] n) {
        // Code starts from here.
        Arrays.sort(n);
        return calculateGCD(n[0], n[n.length - 1]);
    }


    public int calculateGCD(int a, int b) {
        while (b > 0) {
            // int temp = a;
            // a = b;
            // b = temp % b;
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }


    // Driver Class (Must be excluded in the online judge submission)
    public static class Driver {
        public static void main(String[] args) {
            // Code starts from here.
            FindGreatestCommonDivisorOfArray findGreatestCommonDivisorOfArray = new FindGreatestCommonDivisorOfArray();
            int res = findGreatestCommonDivisorOfArray.findGCD(new int[]{2, 5, 6, 9, 10});
            System.out.println(res);
        }
    }
}

// Conclusion: Compare your approaches and report the best one according to your findings.
// FUTURE PLAN: Write about your upcoming approaches on this problem.



