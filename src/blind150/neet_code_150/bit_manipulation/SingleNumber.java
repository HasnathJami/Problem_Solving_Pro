// package name (Must be excluded in the online judge submission)
package blind150.neet_code_150.bit_manipulation;


// Replace class name with "Solution" when submit it to LeetCode
class SingleNumber {

    //Define Approaches
    enum Approach {
        FIRST_APPROACH,
        SECOND_APPROACH,
        THIRD_APPROACH,
    }

    // Input the approach you want to execute.
    private static final Approach approach = Approach.FIRST_APPROACH;


    // Maintain the actual method name provided by LeetCode to avoid any error during submission time
    public int singleNumber(int[] nums) {
        if (approach.equals(Approach.FIRST_APPROACH)) {
            return Approach_1(nums);
        }
//        else if (approach.equals(Approach.SECOND_APPROACH)) {
//            return Approach_2(your_inputs);
//        }
//        else if (approach.equals(Approach.THIRD_APPROACH)) {
//            return Approach_3(your_inputs);
//        }
        return 0;
    }

    // Approach_1: Bit Manipulation, TC(n), SC(1)
    // Outcome: Outcome of your solution (i.e., ACCEPTED)
    /*
     ---------------------------------------------------------------------- NOTE ----------------------------------------------------------------------
     * Make a short note on your approach
      XOR Rules:
      1. a ^ a = 0
      2. a ^ 0 = a
      3. a ^ 1 = flips the least significant bits
      In this problem: XOR Cancel All The Number Which Appears 2 Times, Then, It Will Only Be Unique Number
      i.e., 1,2,2 => 1 ^ 2 ^ 2 = 1 (Ans)
    */

    /*
     ---------------------------------------------------------------------- Algorithm ----------------------------------------------------------------------
     * Write an algorithm on your approach.
    */
    private int Approach_1(int[] nums) {
        // Code starts from here.
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result = result ^ nums[i];
        }
        return result;
    }

    // Driver Class (Must be excluded in the online judge submission)
    public static class Driver {
        public static void main(String[] args) {
            // Code starts from here.
            int nums[] = {3, 2, 2, 6, 3, 4, 4};
            SingleNumber singleNumber = new SingleNumber();
            int res = singleNumber.singleNumber(nums);
            System.out.println(res);

        }
    }
}

// Conclusion: Compare your approaches and report the best one according to your findings.
// FUTURE PLAN: Write about your upcoming approaches on this problem.
