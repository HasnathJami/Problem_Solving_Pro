// package name (Must be excluded in the online judge submission)
package blind150.neet_code_150.bit_manipulation;


// Replace class name with "Solution" when submit it to LeetCode
class SumOfTwoIntegers {

    //Define Approaches
    enum Approach {
        FIRST_APPROACH,
        SECOND_APPROACH,
        THIRD_APPROACH,
    }

    // Input the approach you want to execute.
    private static final Approach approach = Approach.FIRST_APPROACH;


    // Maintain the actual method name provided by LeetCode to avoid any error during submission time
    public int getSum(int a, int b) {
        if (approach.equals(Approach.FIRST_APPROACH)) {
            return Approach_1(a, b);
        }
//        else if (approach.equals(Approach.SECOND_APPROACH)) {
//            return Approach_2(a,b);
//        }
//        else if (approach.equals(Approach.THIRD_APPROACH)) {
//            return Approach_3(your_inputs);
//        }
        return 0;
    }

    // Approach_1: Bit Manipulation, TC - O(1) , more specifically O(log(max(a,b))), SC -> O(1)
    // Outcome: Outcome of your solution (i.e., ACCEPTED)
    /*
     ---------------------------------------------------------------------- NOTE ----------------------------------------------------------------------
     * Make a short note on your approach

      In this problem:
      Rules:
      1. Num1 & Num2 = Carry Bit (If we AND two number, then we can find the carries in bit format because if two bit is 1, AND Operation returns 1, as we know in binary addition = 1+1 = 0 (Carry -1)
      2. Num1 ^ Num2 (Sum of two numbers without carry)

      Steps:
      1. Firstly, find the carry of (a+b)
      2. add a and b (without carry) in a
      3. left shift 1 times of carry value and store it to b
      4. repeat unless b!=0..else return a
      Here, we have added two numbers without carry with xor, so we have to add carry any how. So, we have AND a and b to extract carries. and left shift carry...as we know that in mathematics if we found any carry it wil add with first left value.
      Then, we are repeating the process ...as we have to add these numbers (without carry) repeat until b>0, if b==0 that's mean nothing to add and all caries have already added

    */

    /*
     ---------------------------------------------------------------------- Algorithm ----------------------------------------------------------------------
     * Write an algorithm on your approach.
      => Bit Manipulation
    */
    private int Approach_1(int a, int b) {
        while (b != 0) {
            int carry = a & b;
            a = a ^ b;
            b = carry << 1;
        }

        return a;
    }

    // Driver Class (Must be excluded in the online judge submission)
    public static class Driver {
        public static void main(String[] args) {
            // Code starts from here.
            SumOfTwoIntegers sumOfTwoIntegers = new SumOfTwoIntegers();
            int sum = sumOfTwoIntegers.getSum(4,-100);
            System.out.println(sum);

        }
    }
}


// Conclusion: Approach 1 is Efficient as It only runs (N * NumOfSetBit) Times.
// Example: 10000000000000000000000000 => Here TC for Approach_1 is 0(N * 1) and Approach_2 is 0(N * 26)
// FUTURE PLAN: I will implement other approaches

