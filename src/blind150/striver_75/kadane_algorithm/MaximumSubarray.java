package blind150.striver_75.kadane_algorithm;

// Replace class name with "Solution" when submit it to LeetCode
class MaximumSubarray {

    //Define Approaches
    enum Approach {
        FIRST_APPROACH,
        SECOND_APPROACH,
        THIRD_APPROACH,
    }

    // Input the approach you want to execute.
    private static final Approach approach = Approach.FIRST_APPROACH;


    // Maintain the actual method name provided by LeetCode to avoid any error during submission time
    public int maxSubArray(int[] nums) {
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

    // Approach_1: Using Kadane's Algorithm, TC->O(n), SC->O(1)
    // Outcome: ACCEPTED
    /*
     ---------------------------------------------------------------------- NOTE ----------------------------------------------------------------------
     * Make a short note on your approach
     For positive/negative number,
     1. We have to find the prefixSum in each iteration. and check for max sum, and store maxSum
     2.We have to consider a special condition.
      - if the total sum is negative than no need to add this sum. So, discard previous sum and calculation by set sum = 0 and calculation stars again
     and before this the maxValue has updated.
     then, return the result

     For negative number,
     the same code will work for this,
     in this scenario,
     -4, -3, -1
     1.it first ,store -4 in maxValue.
     2.the value is negative , so it will be discarded
     3.then -3 will be stored as maxValue,
     4.the value is negative , so it will be discarded
     5.then -1 will be stored as maxValue,
     6.the value is negative , so it will be discarded.
     7. But in the meantime the maxValue variable is update by -1 which is our result
    */

    /*
     ---------------------------------------------------------------------- Algorithm ----------------------------------------------------------------------
     * Write an algorithm on your approach.
    */
    private int Approach_1(int[] nums) {
        // Code starts from here.
        int currentSum = 0;
        int maximumSum = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            currentSum = currentSum + nums[i];
            if (currentSum > maximumSum) {
                maximumSum = currentSum;
            }

            if (currentSum < 0) {
                currentSum = 0;
            }
        }
        return maximumSum;
    }

    // Driver Class (Must be excluded in the online judge submission)
    public static class Driver {
        public static void main(String[] args) {
            // Code starts from here.
            MaximumSubarray maximumSubarray = new MaximumSubarray();
//            int res = maximumSubarray.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4});
//            int res = maximumSubarray.maxSubArray(new int[]{1});
//            int res = maximumSubarray.maxSubArray(new int[]{5, 4, -1, 7, 8});
            int res = maximumSubarray.maxSubArray(new int[]{-5, -4, -1, -7, -8});
            System.out.println(res);
        }
    }
}

// Conclusion: Approach-1 (Kadane's Algorithm) is optimal
// FUTURE PLAN: I will implement other approaches.
