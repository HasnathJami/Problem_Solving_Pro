package blind150.neet_code_150.bit_manipulation;

// Replace class name with "Solution" when submit it to LeetCode
class ReverseBits {

    //Define Approaches
    enum Approach {
        FIRST_APPROACH,
        SECOND_APPROACH,
        THIRD_APPROACH,
    }

    // Input the approach you want to execute.
    private static final Approach approach = Approach.FIRST_APPROACH;


    // Maintain the actual method name provided by LeetCode to avoid any error during submission time
    public int reverseBits(int num) {
        if (approach.equals(Approach.FIRST_APPROACH)) {
            return Approach_1(num);
        }
        else if (approach.equals(Approach.SECOND_APPROACH)) {
            return Approach_2(num);
        }
//        else if (approach.equals(Approach.THIRD_APPROACH)) {
//            return Approach_3(your_inputs);
//        }
        return 0;
    }

    // Approach_1: Bit Manipulation, TC - O(1), SC -> O(1)
    // Outcome: Outcome of your solution (i.e., ACCEPTED)
    /*
     ---------------------------------------------------------------------- NOTE ----------------------------------------------------------------------
     * Make a short note on your approach

      In this problem:
      Steps:
      1. Declare the result variable in which you want to store the reversed value
      2. Extract last bit from the number and store it on the result variable
      3. here, the check condition is used to check if the last bit of the number is 1 then store it on the result.as we know that if the last bit is 0 so there is no need to store it as the result number already contains zeroes if nothing is set before.
      4. then store the value of 1 to the result by performing or operations
      5. then left shift the result so that we can create space for the next value
      6. then, right shift the num to 1bit for the further iteration on other bits. As, the work of current bit is done, so we have removed it by right shifting.
      7. repeat the process
      9. here, we have 32 bits on integer (unsigned). So, we have to perform 32 iterations to check all 32 bits
    */

    /*
     ---------------------------------------------------------------------- Algorithm ----------------------------------------------------------------------
     * Write an algorithm on your approach.
      => Bit Manipulation
    */
    private int Approach_1(int num) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
//            result = result << 1;
            if ((num & 1) == 1) {
                result = result | 1;
            }
            if (i < 31) {
                result = result << 1; // it creates problems for the last iteration, as on the last iteration it changes the 'result' value which is not needed. so, the solution is that shifted 'result' then calculate result or check (i<31) if you want to use this shift operation at the last.
            }
            num = num >> 1;
        }
        return result;
    }

    // Outcome: Outcome of your solution (i.e., TLE)
    // Approach_1: Bit Manipulation
    private int Approach_2(int num) {
        int result = 0;
        while (num != 0) {
            result = result << 1;
            if ((num & 1) == 1) {
                result = result | 1;
            }
            num = num >> 1;
        }
        return result;
    }

    // Driver Class (Must be excluded in the online judge submission)
    public static class Driver {
        public static void main(String[] args) {
            // Code starts from here.
            ReverseBits reverseBits = new ReverseBits();
            int sum = reverseBits.reverseBits(10);
            System.out.println(sum);

        }
    }
}


// Conclusion: Approach 1 is Efficient as TC-> O(32) = O(1) and SC -> O(1)
// FUTURE PLAN: I will implement other approaches


