// package name (Must be excluded in the online judge submission)
package blind150.neet_code_150.bit_manipulation;


// Replace class name with "Solution" when submit it to LeetCode
class CountingBits {

    //Define Approaches
    enum Approach {
        FIRST_APPROACH,
        SECOND_APPROACH,
        THIRD_APPROACH,
    }

    // Input the approach you want to execute.
    private static final Approach approach = Approach.FIRST_APPROACH;


    // Maintain the actual method name provided by LeetCode to avoid any error during submission time
    public int[] countBits(int num) {
        if (approach.equals(Approach.FIRST_APPROACH)) {
            return Approach_1(num);
        }
        else if (approach.equals(Approach.SECOND_APPROACH)) {
            return Approach_2(num);
        }
//        else if (approach.equals(Approach.THIRD_APPROACH)) {
//            return Approach_3(your_inputs);
//        }
        return null;
    }

    // Approach_1: Bit Manipulation, TC - O(N * NumOfSetBits), SC -> O(N))))
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
    private int[] Approach_1(int num) {
        int count[] = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            int countSetBit = 0;
            int j = i;
            while (j > 0) {
                j = (j & (j - 1));
                countSetBit++;
            }
            count[i] = countSetBit;
        }


        return count;
    }

    // Approach_2: Bit Manipulation, TC -> O(N * NumOfTotalBits), SC -> O(N)
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
    private int[] Approach_2(int num) {
        int count[] = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            int j = i;
            int countSetBit = 0;
            while (j > 0) {
                if ((j & 1) == 1) {
                    countSetBit++;
                }
                j = j >> 1;
                count[i] = countSetBit;
            }
        }
        return count;
    }

    // Driver Class (Must be excluded in the online judge submission)
    public static class Driver {
        public static void main(String[] args) {
            // Code starts from here.
            int num = 4;
            CountingBits countingBits = new CountingBits();
            int[] res = countingBits.countBits(num);
            for (int i = 0; i < res.length; i++) {
                System.out.print(res[i]);
            }

        }
    }
}


// Conclusion: Approach 1 is Efficient as It only runs (N * NumOfSetBit) Times.
// Example: 10000000000000000000000000 => Here TC for Approach_1 is 0(N * 1) and Approach_2 is 0(N * 26)
// FUTURE PLAN: I will implement other approaches
