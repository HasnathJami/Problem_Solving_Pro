package blind150.neet_code_150.bit_manipulation;

// Replace class name with "Solution" when submit it to LeetCode
class MissingNumber {

    //Define Approaches
    enum Approach {
        FIRST_APPROACH,
        SECOND_APPROACH,
        THIRD_APPROACH,
    }

    // Input the approach you want to execute.
    private static final Approach approach = Approach.FIRST_APPROACH;


    // Maintain the actual method name provided by LeetCode to avoid any error during submission time
    public int missingNumber(int nums[]) {
        if (approach.equals(Approach.FIRST_APPROACH)) {
            return Approach_1(nums);
        }
//        else if (approach.equals(Approach.SECOND_APPROACH)) {
//            return Approach_2(a,b);
//        }
//        else if (approach.equals(Approach.THIRD_APPROACH)) {
//            return Approach_3(your_inputs);
//        }
        return 0;
    }

    // Approach_1: Bit Manipulation, TC - O(N+1), SC -> O(1)
    // Outcome: Outcome of your solution (i.e., ACCEPTED)
    /*
     ---------------------------------------------------------------------- NOTE ----------------------------------------------------------------------
     * Make a short note on your approach

      In this problem:
      Rules:
      1. a^b^a = b (a cancel)

      Steps:
      1. Firstly, here, it is told about the range(number must be in a range 0..n)
      2. So, for finding the missing number we firstly, xor all the given number and store it in the xorNum
      3. As, the number must be within the range then we, xor the index (0..n+1) and store it in the xorIndex
      4. then xorNum ^ xorIndex (as it cancels the common number, and we will find the missing number, because number must be in 0, n+1 index range) so (Xn+1 ^ Xn) = Missing Number
      Here, we have added two numbers without carry with xor, so we have to add carry any how. So, we have AND a and b to extract carries. and left shift carry...as we know that in mathematics if we found any carry it wil add with first left value.
      Then, we are repeating the process ...as we have to add these numbers (without carry) repeat until b>0, if b==0 that's mean nothing to add and all caries have already added

    */

    /*
     ---------------------------------------------------------------------- Algorithm ----------------------------------------------------------------------
     * Write an algorithm on your approach.
      => Bit Manipulation
    */
    private int Approach_1(int nums[]) {
        int xorNum = 0;
        int xorIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            xorNum ^= nums[i];
        }

        for (int i = 0; i < nums.length + 1; i++) {
            xorIndex ^= i;
        }

        return xorIndex ^ xorNum;
    }

    // Driver Class (Must be excluded in the online judge submission)
    public static class Driver {
        public static void main(String[] args) {
            // Code starts from here.
            int nums[] = {9,6,4,2,3,5,7,0,1};
            MissingNumber missingNumber = new MissingNumber();
            int sum = missingNumber.missingNumber(nums);
            System.out.println(sum);

        }
    }
}


// Conclusion: Approach 1 is Efficient as It only runs (N+1) Times.
// FUTURE PLAN: I will implement other approaches


