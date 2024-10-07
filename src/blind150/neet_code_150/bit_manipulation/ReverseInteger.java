// package name (Must be excluded in the online judge submission)
package blind150.neet_code_150.bit_manipulation;

// Replace class name with "Solution" when submit it to LeetCode
class ReverseInteger {

    //Define Approaches
    enum Approach {
        FIRST_APPROACH,
        SECOND_APPROACH,
        THIRD_APPROACH,
    }

    // Input the approach you want to execute.
    private static final Approach approach = Approach.FIRST_APPROACH;


    // Maintain the actual method name provided by LeetCode to avoid any error during submission time
    public int reverseInteger(int num) {
        if (approach.equals(Approach.FIRST_APPROACH)) {
            return Approach_1(num);
        }
//        else if (approach.equals(Approach.SECOND_APPROACH)) {
//            return Approach_2(num);
//        }
//        else if (approach.equals(Approach.THIRD_APPROACH)) {
//            return Approach_3(your_inputs);
//        }
        return 0;
    }

    // Approach_2: Using Bit Manipulation, TC - , SC -> O(1)
    // Outcome: Outcome of your solution (i.e., ACCEPTED)
    /*
     ---------------------------------------------------------------------- NOTE ----------------------------------------------------------------------
     * Make a short note on your approach

      In this problem:
      Steps:

    */

    /*
     ---------------------------------------------------------------------- Algorithm ----------------------------------------------------------------------
     * Write an algorithm on your approach.
      => Using Bit Manipulation
    */
    private int Approach_2(int num) {
        return 0;
    }

    // Approach_1: Using Arithmetic Operations, TC - O(log10(num)) or O(number of digits), SC -> O(1)
    // Outcome: Outcome of your solution (i.e., ACCEPTED)
    /*
     ---------------------------------------------------------------------- NOTE ----------------------------------------------------------------------
     * Make a short note on your approach

      In this problem:
      Steps:
      1. Declare the result variable in which you want to store the reversed value
      2. Loop through the code until number is > 0
      3. here, we have to extract the last digit of the number. So, we have performed mod operation for it
      4. Store the last digit in result and multiply with 10.
      (This operation shifts all the digits in result to the left by one place. By multiplying result by 10, any number stored in result moves one position to the left (similar to shifting bits in a binary representation).
      5. check overflow and underflow:
      - The maximum digit a 32-bit signed integer can safely have in the last position is 7 for positive numbers (2,147,483,647).
      - The minimum digit a 32-bit signed integer can safely have in the last position is -8 for negative numbers (-2,147,483,648).

      - If result is greater than 214748364 (Integer.MAX_VALUE / 10), multiplying it by 10 will definitely cause it to exceed Integer.MAX_VALUE.
      - If result is exactly 214748364 (meaning there's room for exactly one more digit), the lastDigit must be ≤ 7. If it's 8 or more, adding it would cause overflow.

      - If result is less than -214748364 (Integer.MIN_VALUE / 10), multiplying it by 10 will definitely cause it to go below Integer.MIN_VALUE.
      - If result is exactly -214748364 (meaning there's room for exactly one more digit), the lastDigit must be ≥ -8. If it's -9, adding it would cause underflow.
    */

    /*
     ---------------------------------------------------------------------- Algorithm ----------------------------------------------------------------------
     * Write an algorithm on your approach.
      => Using Arithmetic Operations
    */
    private int Approach_1(int num) {
        int result = 0;
        while (num != 0) {
            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && num % 10 > 7)) return 0;
            if (result < Integer.MIN_VALUE / 10 || (result == Integer.MIN_VALUE / 10 && num % 10 < -8)) return 0;
            result = (result * 10) + (num % 10);
            num = num / 10;
        }
        return result;
    }

    // Driver Class (Must be excluded in the online judge submission)
    public static class Driver {
        public static void main(String[] args) {
            // Code starts from here.
            ReverseInteger reverseInteger = new ReverseInteger();
            int sum = reverseInteger.reverseInteger(125);
            System.out.println(sum);

        }
    }
}


// Conclusion: Approach 1 is Efficient as TC-> O(32) = O(1) and SC -> O(1)
// FUTURE PLAN: I will implement other approaches


