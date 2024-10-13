package random.leetcode;

// Replace class name with "Solution" when submit it to LeetCode
class SingleNumberII {

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
//            return Approach_Your_Approach_Number(your_inputs);
//        }
//        else if (approach.equals(Approach.THIRD_APPROACH)) {
//            return Approach_Your_Approach_Number(your_inputs);
//        }
        return 0;
    }

    // Approach_1: Bit Manipulation , TC -> O(32 * N) = O(N), SC - > O(1)
    // Outcome: ACCEPTED
    /*
     ---------------------------------------------------------------------- NOTE ----------------------------------------------------------------------
     * Make a short note on your approach
     Steps:
     1. First of all, I have to count the bitSum for all the 32 bits
     here, in the (bitSum += ((num >> i) & 1), I have calculated the bit sum after extracting the LSB
     2.then, I have to add the values(0,1) to the result if the number is not divisible by 3 then the bit which I have to add will be 1.
     Otherwise, it's not necessary to add 0. As, all the values are by default 0.
     3. Here, in the result = result | (1 << i), I have OR the result after Left shifting the value. Here, I have performed the Left shift
     so that after each iteration, I can create a place for each lsb so that I can construct the unique value. Then, after performing OR operation
     the values will be added one after another. At last, I will find my result.

     For Example,
     2,2,3,2

     Bits Table:
     -----------
                               32 .. 2  1  0

    Bit Count ->                     0  4  1  (count the value if set bit is 1)
    Mod Each Bit with 3 ->           0  1  1  -> 3 (Result)
    */

    /*
     ---------------------------------------------------------------------- Algorithm ----------------------------------------------------------------------
     * Write an algorithm on your approach.
     => Bit Manipulation
    */

    public int Approach_1(int[] nums) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            int bitSum = 0;
            for (int num : nums) {
                bitSum += ((num >> i) & 1); // here, (num>>i) is used to right shift the value, that means, it moves toward next iteration by removing lsb in each iteration
            }

            if (bitSum % 3 != 0) {
                result = result | (1 << i);
            }

        }

        return result;
    }

    // Driver Class (Must be excluded in the online judge submission)
    public static class Driver {
        public static void main(String[] args) {
            // Code starts from here.
            SingleNumberII singleNumberII = new SingleNumberII();
            int res = singleNumberII.singleNumber(new int[]{5,2,2,2,3,3,3});

            System.out.println(res);
        }
    }
}

// Conclusion: Approach 1 is optimal.
// FUTURE PLAN: I will implement other approaches in the future.