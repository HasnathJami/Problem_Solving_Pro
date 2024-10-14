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

    // Approach_1: Euclid Algorithm,  Time Complexity -> O(nlogn) for (Arrays.sort()) + O(log(min(a,b)) for (GCD calculation) = O(nlogn) ,, and Space Complexity -> O(1)
    // Outcome: ACCEPTED
    /*
     ---------------------------------------------------------------------- NOTE ----------------------------------------------------------------------
     * Make a short note on your approach
     1. Here, we have to use Euclid Algorithm to find the GCD of 2 numbers
     2. In the Euclid Algorithm, if(b<=0) GCD = a else GCD(b, a%b)
     3. In this formula, here, It tries to perform a%b, and a should be always greater than b (a>b)  always for optimization as it reduce the number of steps
     4. Suppose, a<b. On the next iteration it's changed to a>b, with this formula (So, we don't need to be worried)
     5. here, if b == 0, that's means we have found our GCD which we have stored into a, as a = b. every time,
     and we have performed a%b(if a is divisible by b, then b is our gcd which is stored in variable a)
     */

    /*
     ---------------------------------------------------------------------- Algorithm ----------------------------------------------------------------------
     * Write an algorithm on your approach.
     => Euclid Algorithm
    */
    private int Approach_1(int[] n) {
        // Code starts from here.
        Arrays.sort(n);
        return calculateGCD_Recursive(n[0], n[n.length - 1]);
    }


    public int calculateGCD(int a, int b) {
        while (b > 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    //TC-> O(log(min(a,b))), SC-> O(log(min(a,b)))
    public int calculateGCD_Recursive(int a, int b) {
        if (b <= 0) {
            return a;
        }
        return calculateGCD_Recursive(b, a % b);

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



