// package name (Must be excluded in the online judge submission)
package random.leetcode.mathematics;

// Replace class name with "Solution" when submit it to LeetCode
class FactorialTrailingZeroes {

    //Define Approaches
    enum Approach {
        FIRST_APPROACH,
        SECOND_APPROACH,
        THIRD_APPROACH,
    }

    // Input the approach you want to execute.
    private static final Approach approach = Approach.FIRST_APPROACH;


    // Maintain the actual method name provided by LeetCode to avoid any error during submission time
    public int trailingZeroes(int n) {
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

    // Approach_Your_Approach_Number: Approach Name with Time and Space Complexity
    // Outcome: Outcome of your solution (i.e., ACCEPTED, TLE, FAILED, COMPILATION ERROR, RUNTIME ERROR)
    /*
     ---------------------------------------------------------------------- NOTE ----------------------------------------------------------------------
     * Make a short note on your approach
     1. Here, if we want to find the trailing zeroes we have to find how many time it's 5x2. As, it creates zeroes
     2. But, the number of 2's are much more than 5 in every situation. So, we have to find only the number of 5's.
     3. So, we have written our logic, in here, we have started our loop from 5. As, there is no need to count fives for
     number 1 to 4 factorial because there is no trailing zeroes there.
     4. We have to handle the case of 25,125, etc as it has more 5's. For Example,
     25/5 = 5 but 25! has 6 5's (25 = 5 x 5 also)
     That's why, we have introduced our conditions on the loop
    */

    /*
     ---------------------------------------------------------------------- Algorithm ----------------------------------------------------------------------
     * Write an algorithm on your approach.
     => Division Operator
    */
    private int Approach_1(int n) {
        // Code starts from here.
        int fivesCounter = 0;
        for(int i = 5;i<=n;i = 5 * i) {
            fivesCounter = fivesCounter + n/i;
        }
        return fivesCounter;

//        int fivesCounter = 0;
//        while(n>=5) {
//            fivesCounter = fivesCounter + n/5;
//            n = n/5;
//        }
//        return fivesCounter;
    }

//    private int Approach_1_Recursive(int n) {
//        if (n < 5) {
//            return 0; // Base case: If n is less than 5, no trailing zeros can be added
//        }
//        return n / 5 + Approach_1_Recursive(n / 5); // Recursive case: Add n/5 and recurse with n/5
//    }

    // Driver Class (Must be excluded in the online judge submission)
    public static class Driver {
        public static void main(String[] args) {
            // Code starts from here.
            FactorialTrailingZeroes factorialTrailingZeroes = new FactorialTrailingZeroes();
            int res = factorialTrailingZeroes.trailingZeroes(125);
            System.out.println(res);
        }
    }
}

// Conclusion: Compare your approaches and report the best one according to your findings.
// FUTURE PLAN: Write about your upcoming approaches on this problem.

