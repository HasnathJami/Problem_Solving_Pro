package random.leetcode;

// Replace class name with "Solution" when submit it to LeetCode
class SingleNumberIII {

    //Define Approaches
    enum Approach {
        FIRST_APPROACH,
        SECOND_APPROACH,
        THIRD_APPROACH,
    }

    // Input the approach you want to execute.
    private static final Approach approach = Approach.FIRST_APPROACH;


    // Maintain the actual method name provided by LeetCode to avoid any error during submission time
    public int[] singleNumber(int[] nums) {
        if (approach.equals(Approach.FIRST_APPROACH)) {
            return Approach_1(nums);
        }
//        else if (approach.equals(Approach.SECOND_APPROACH)) {
//            return Approach_Your_Approach_Number(your_inputs);
//        }
//        else if (approach.equals(Approach.THIRD_APPROACH)) {
//            return Approach_Your_Approach_Number(your_inputs);
//        }
        return null;
    }

    // Approach_1: Bit Manipulation , TC -> O(N), SC - > O(1)
    // Outcome: ACCEPTED
    /*
     ---------------------------------------------------------------------- NOTE ----------------------------------------------------------------------
     * Make a short note on your approach
     Steps:
     1. First of all, I have performed xor operation to the all values,
     2. Then, I have calculated the rightMostSet bit by using this formula, rightMostSetBit = (fullXor) & -(fullXor);
     3. Then, I have to use the for loop for the iteration.
     In which, I have to found the two values which are unique
     4. Here, we have found the uniques values, as we know that if these values were not unique then we could not
     find the bit mismatch after performing xor operation.
     5. So, It is confirmed that, there will be unique values.
      By Performing AND operation with rightmost set bit and number, we can find the unique values.
       As, if the result is not zero then the number will be happened as then we can confirm that bit mismatch happened,
       and we are about to find our unique value.
      6. Here, in the for loop , we have divided the values in two group, on the first group, we will find our first value,
      and on the second group, we will find our secondValue. As these two value's bits are different from each other.
      If there are duplicate values these valued will be ignored in this conditioned as they will be cancelled and there is no question about
      these values to be in the list.

      For Example,
      Steps:
      1. 1,2,1,3,2,5 (main list)
      2. 3 ^ 5 (1,2 will be cancelled after performing xor)
      3. we have found the two values, but in xor format.So, we have to separate these values
      4. The right most set bits of these two values must be differed from each other that's why they are unique from each other. So, we have to use the formula to find the right most set bit first.
      5. Then we have to divide these two values in the two separate group so that we can find them separately
      by performing AND operation with these values with rightmost set bit.
      As, the rightmost set bit of these two values are different from each other. They will be separated in two groups (firstValue, secondValue) easily.
      6. At last, we can easily extract these two values.
    */

    /*
     ---------------------------------------------------------------------- Algorithm ----------------------------------------------------------------------
     * Write an algorithm on your approach.
     => Bit Manipulation
    */

    public int[] Approach_1(int[] nums) {
        int fullXor = 0;
        for (int i = 0; i < nums.length; i++) {
            fullXor ^= nums[i];
        }

        int firstValue = 0;
        int secondValue = 0;

        int rightMostSetBit = (fullXor) & -(fullXor);
        for (int i = 0; i < nums.length; i++) {
            if ((rightMostSetBit & nums[i]) != 0) {
                firstValue ^= nums[i];
            } else {
                secondValue ^= nums[i];
            }
        }
        // or, we can find the second value without iterating through loop by using this, secondValue = fullXor ^ firstValue;

        // If Ordering Needed
//        for (int i = 0; i < nums.length; i++) {
//            if (firstValue == nums[i]) {
//                return new int[]{firstValue, secondValue};
//            } else if (secondValue == nums[i]) {
//                return new int[]{secondValue, firstValue};
//            }
//        }
        return new int[]{firstValue, secondValue};

    }

    // Driver Class (Must be excluded in the online judge submission)
    public static class Driver {
        public static void main(String[] args) {
            // Code starts from here.
            SingleNumberIII singleNumberIII = new SingleNumberIII();
            int res[] = singleNumberIII.singleNumber(new int[]{1, 2, 1, 5, 2, 3});

            for (int value : res) {
                System.out.print(value);
            }
        }
    }
}

// Conclusion: Approach 1 is optimal.
// FUTURE PLAN: I will implement other approaches in the future.