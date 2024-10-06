// package name (Must be excluded in the online judge submission)
package blind150.neet_code_150.bit_manipulation;


// Replace class name with "Solution" when submit it to LeetCode
class NumberOf1Bits {

    //Define Approaches
    enum Approach {
        FIRST_APPROACH,
        SECOND_APPROACH,
        THIRD_APPROACH,
    }

    // Input the approach you want to execute.
    private static final Approach approach = Approach.FIRST_APPROACH;


    // Maintain the actual method name provided by LeetCode to avoid any error during submission time
    public int hammingWeight(int num) {
        if (approach.equals(Approach.FIRST_APPROACH)) {
            return Approach_1(num);
        } else if (approach.equals(Approach.SECOND_APPROACH)) {
            return Approach_2(num);
        }
//        else if (approach.equals(Approach.THIRD_APPROACH)) {
//            return Approach_3(your_inputs);
//        }
        return 0;
    }

    // Approach_1: Bit Manipulation, TC(NumOfSetBits), SC(1)
    // Outcome: Outcome of your solution (i.e., ACCEPTED)
    /*
     ---------------------------------------------------------------------- NOTE ----------------------------------------------------------------------
     * Make a short note on your approach

      In this problem: Num & (Num-1)  runs NumOfSetBits Times ( the bits are designed in this way when we AND the number and its previous numbers, we can get set bits until the number reaches zero)
    */

    /*
     ---------------------------------------------------------------------- Algorithm ----------------------------------------------------------------------
     * Write an algorithm on your approach.
      =>  Rules:
      Run:  num & (num -1 ) until num > 0
    */
    private int Approach_1(int num) {
        int countSetBit = 0;
        while (num > 0) {
            num = (num & (num - 1));
            countSetBit++;
        }

        return countSetBit;
    }

    // Approach_2: Bit Manipulation, TC(NumOfTotalBits), SC(1)
    // Outcome: Outcome of your solution (i.e., ACCEPTED)
    /*
     ---------------------------------------------------------------------- NOTE ----------------------------------------------------------------------
     * Make a short note on your approach

      In this problem: Firstly, check the set bit by AND 1 with It, Increase the Count and Right Shift 1 Bit, Repeat the process until num>0
    */

    /*
     ---------------------------------------------------------------------- Algorithm ----------------------------------------------------------------------
     * Write an algorithm on your approach.
      AND Rules:
      1.( num  & 1) = 1 (lsb is 1 else 0) (note: the number is odd)
    */
    private int Approach_2(int num) {
        int countSetBit = 0;
        while (num > 0) {
            if ((num & 1) == 1) {
                countSetBit++;
            }
            num = num >> 1;
        }

        return countSetBit;
    }

    // Driver Class (Must be excluded in the online judge submission)
    public static class Driver {
        public static void main(String[] args) {
            // Code starts from here.
            int num = 128;
            NumberOf1Bits numberOf1Bits = new NumberOf1Bits();
            int res = numberOf1Bits.hammingWeight(num);
            System.out.println(res);

        }
    }
}


// Conclusion: Approach 1 is Efficient as It only runs NumOfSetBitTimes.
// Example: 10000000000000000000000000 => Here TC for Approach_1 is 0(1) and Approach_2 is 0(26)
// FUTURE PLAN: I will implement other approaches
