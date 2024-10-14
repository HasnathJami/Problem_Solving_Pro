// package name (Must be excluded in the online judge submission)
package blind150.neet_code_150.mathematics;

import java.util.Arrays;

// Replace class name with "Solution" when submit it to LeetCode
class PowXN {

    //Define Approaches
    enum Approach {
        FIRST_APPROACH,
        SECOND_APPROACH,
        THIRD_APPROACH,
    }

    // Input the approach you want to execute.
    private static final Approach approach = Approach.FIRST_APPROACH;


    // Maintain the actual method name provided by LeetCode to avoid any error during submission time
    public double myPow(double a, int b) {
        if (approach.equals(Approach.FIRST_APPROACH)) {
            return Approach_1(a,b);
        }
//        else if (approach.equals(Approach.SECOND_APPROACH)) {
//            return Approach_Your_Approach_Number(your_inputs);
//        }
//        else if (approach.equals(Approach.THIRD_APPROACH)) {
//            return Approach_Your_Approach_Number(your_inputs);
//        }
        return 0.0;
    }

    // Approach_1: Binary Exponentiation,  Time Complexity -> O(logn), and Space Complexity -> O(1)
    // Outcome: ACCEPTED
    /*
     ---------------------------------------------------------------------- NOTE ----------------------------------------------------------------------
     * Make a short note on your approach
     1. Here, in this problem, X^n = (X^2)^n/2 if n is even
      if n is od X^n = X* X^n-1
     */

    /*
     ---------------------------------------------------------------------- Algorithm ----------------------------------------------------------------------
     * Write an algorithm on your approach.
     => Binary Exponentiation
    */
    private double Approach_1(double x, int n) {
        // Code starts from here.
        double result = 1.0;
        long N = n;
        // or n = n % 1000000007;

        // for negative number, we have to convert this format.. X^-2 = 1/X^2. that's why we have to write the below lines
        if(N<0) {
            x = 1/x;
            N = -N;
        }
        while(N>0) {
            // Here, X^n = X*X^n-1 if n is odd
            // this check, also prevents the result from adding once again when N = 1,
            // if we return the value of x in the case of 2,4 ..the result will be 256.00 not 16.00 for the extra operation when n = 1
            // this operation reduce this extra operation for us and we can calculate correct value and store it on the result
            // Then, there is another purpose of this operation...if n is odd then X^n = X*X^n-1 if n is odd
            // if the number is odd we have to add one value of x..if n==1 then X^n = X * 1(Result=1.O) = X..no need add any value just return the value of x as result
            //if n == 3... then X^n = X(add this value) * X^2(found this value from x= x*x and this is adding at last iteration when n =1)
            // Summary: this block added the missing X if the number is odd and n>1 as 5/2 = 2 ( 1 'x' is missing here)
            // if n ==1 it just adds result with calculated values and prevents the result from adding once again(if result = 1.0 remains at the end, that's mean power is even)
            if(N%2 == 1){
                result*=x;
            }

            // Here, X^n = (X^2)^n/2 if n is even
            x = x*x;
            N = N/2;
        }
        return x;
    }


    // Driver Class (Must be excluded in the online judge submission)
    public static class Driver {
        public static void main(String[] args) {
            // Code starts from here.
            PowXN powXN = new PowXN();
            double res = powXN.myPow(2.0, 4);
            System.out.println(res);
        }
    }
}

// Conclusion: Compare your approaches and report the best one according to your findings.
// FUTURE PLAN: Write about your upcoming approaches on this problem.



