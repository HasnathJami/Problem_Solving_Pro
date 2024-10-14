// package name (Must be excluded in the online judge submission)
package random.leetcode.mathematics;

import java.util.Arrays;

// Replace class name with "Solution" when submit it to LeetCode
class CountPrimes {

    //Define Approaches
    enum Approach {
        FIRST_APPROACH,
        SECOND_APPROACH,
        THIRD_APPROACH,
    }

    // Input the approach you want to execute.
    private static final Approach approach = Approach.FIRST_APPROACH;


    // Maintain the actual method name provided by LeetCode to avoid any error during submission time
    public int countPrimes(int n) {
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

    // Approach_1: Sieve of Eratosthenes,  Time Complexity -> O(n log(log n)), and Space Complexity -> O(n)
    // Here, in the inner loop for the numbers n/2 + n/3 + n/4 = n(1/2 + 1/3) = O(n logn)
    // It's not O(n log(n)) because the outer loop is iterated from 2 to root(n) times,not 2 to n
    // So, Overall TC => O(n log(logn))
    // Outcome: ACCEPTED
    /*
     ---------------------------------------------------------------------- NOTE ----------------------------------------------------------------------
     * Make a short note on your approach
     1. Here, first we have initially set true to isPrime array from 0 to n
     2.As, 0,1 is not a prime number we have to set initially false to them
     3. if(n>0) for the case if input is 0 else it can create Array Index Bound Exception
     4. Then, start from 2 to root(n) as, there is no need to check from 2 to n. If we check 2 to root(n), it will check prime for the end of list
     5. In the example of n =10, Then, we have marked the array false .if we have found the multiples of 2 -> 4,6,8, 3-> 6,9
     6. Then, we can find our prime count from isPrime Array
     */

    /*
     ---------------------------------------------------------------------- Algorithm ----------------------------------------------------------------------
     * Write an algorithm on your approach.
     => Sieve of Eratosthenes
    */
    private int Approach_1(int n) {
        // Code starts from here.
//        boolean isPrime[] = new boolean[n + 1]; for, 0..n inclusive
        boolean isPrime[] = new boolean[n]; // for 0..n exclusive [here, isPrime size is n as, Given an integer n, return the number of prime numbers that are strictly less than n.]
        int primeCount = 0;
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        if (n > 0) {
            isPrime[1] = false;
        }
        for (int i = 2; i * i < n; i++) {
            for (int k = i * 2; k < n; k = k + i) {
//                if (k % i == 0) { // no need to mod
                isPrime[k] = false;
//                }
            }
        }

        for (int i = 2; i < n; i++) {
            if (isPrime[i]) {
                primeCount++;
            }
        }
        return primeCount;
    }


    // Driver Class (Must be excluded in the online judge submission)
    public static class Driver {
        public static void main(String[] args) {
            // Code starts from here.
            CountPrimes countPrimes = new CountPrimes();
            int res = countPrimes.countPrimes(2);
            System.out.println(res);
        }
    }
}

// Conclusion: Compare your approaches and report the best one according to your findings.
// FUTURE PLAN: Write about your upcoming approaches on this problem.


