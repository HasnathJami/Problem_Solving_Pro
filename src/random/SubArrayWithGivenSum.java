package random;

import java.util.HashMap;

// Replace class name with "Solution" when submit it to LeetCode
class SubArrayWithGivenSum {

    //Define Approaches
    enum Approach {
        FIRST_APPROACH,
        SECOND_APPROACH,
        THIRD_APPROACH,
    }

    // Input the approach you want to execute.
    private static final Approach approach = Approach.SECOND_APPROACH;


    // Maintain the actual method name provided by LeetCode to avoid any error during submission time
    public int[] subArrayWithGivenSum(int[] nums, int target) {
        if (approach.equals(Approach.FIRST_APPROACH)) {
            return Approach_1(nums, target);
        }
        else if (approach.equals(Approach.SECOND_APPROACH)) {
            return Approach_2(nums, target);
        }
//        else if (approach.equals(utils.BoilerPlate.Approach.THIRD_APPROACH)) {
//            return Approach_Your_Approach_Number(your_inputs);
//        }
        return null;
    }

    // Approach_1: Bruteforce Approach, TC => O(n^2), SC => O(n)
    // Outcome: TLE
    /*
     ---------------------------------------------------------------------- NOTE ----------------------------------------------------------------------
     * Make a short note on your approach
     1. At First, I have defined starting and ending pos variable to store the range of subarray
     2. Then, I have defined a boolean variable to check and break the outer loop if subarray is not found.
     3. Then, I have traversed the loop to sum the array  values and check if any of the sum matches with the target sum values.
     4. If it matches with any value then, I have stored the starting and the ending position of the sub-array so that I can construct the sub-array from the main array

    */

    /*
     ---------------------------------------------------------------------- Algorithm ----------------------------------------------------------------------
     * Write an algorithm on your approach.
    */
    private int[] Approach_1(int[] nums, int target) {
        // Code starts from here.
        int startingPos = -1;
        int endingPos = -1;
        boolean isFound = false;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum = sum + nums[j];
                if (sum == target) {
                    startingPos = i;
                    endingPos = j;
                    isFound = true;
                    break;
                }
            }
            if (isFound) {
                break;
            }
        }
        if (!isFound) {
            return new int[0]; //return the empty array if no subarray found;
        }

        int subArray[] = new int[(endingPos - startingPos) + 1];
        int i = 0;
        for (int k = startingPos; k <= endingPos; k++) {
            subArray[i] = nums[k];
            i++;
        }
        return subArray;
    }

    // Approach_2: Using HashMap, TC => O(n), SC => O(n)
    // Outcome: ACCEPTED
    /*
     ---------------------------------------------------------------------- NOTE ----------------------------------------------------------------------
     * Make a short note on your approach
      // Here, first of all, we have to understand the mathematics
      Example:
      ========
      Input(Nums) =  10, 15, -5, 15, -10, 5
      Prefix Sum  =  10  25  20  35   25  30
      Mathematics:
                Result            |        GIVEN
      (Current Sum - Target Sum)-------(Target Sum)----------
      --------------------Current Sum------------------------

      Here, from the above chart formula, we can easily grab the concept,
      As, (Prefix Sum or Current Sum) - Target Sum.we can easily get our result
      Because, that's means
      if Current sum is = 25 , and target sum = 5,
      then result will be = 25 - 5 = 20.
      as, it is simple that by adding result(20) with target sum(5),
      the current sum is constructed. So, we can easily find our result by doing (current sum - target sum) (as, result + targetSum = current sum)

    */

    /*
     ---------------------------------------------------------------------- Algorithm ----------------------------------------------------------------------
     * Write an algorithm on your approach.
    */
    private int[] Approach_2(int[] nums, int targetSum) {
        // Code starts from here.
        int prefixSum = 0; // current sum
        int startingIndex = 0;
        int endingIndex = -1;
        HashMap<Integer, Integer> prefixSumMap = new HashMap();     //(key,value) = (prefixSum, index)
        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];
            prefixSumMap.put(prefixSum, i);

            //edge case
            // if prefixSum - targetSum = 0
            //that's means we have already found our result,
            // that's why by adding our resultant array to prefix sum it equals to 0 when we have performed minus operation with TargetSum
            //Resultant sub array Sum (Prefix Sum) = Target Sum
            if (prefixSum - targetSum == 0) {
                startingIndex = 0;
                endingIndex = i;
                break;
            }

            if (prefixSumMap.containsKey(prefixSum - targetSum)) {
                startingIndex = prefixSumMap.get(prefixSum - targetSum) + 1;
                endingIndex = i;
                break;
            }

            prefixSumMap.put(prefixSum, i);
        }

        int i = 0;
        int resultantSubarray[] = new int[(endingIndex - startingIndex) + 1];
        for (int k = startingIndex; k <= endingIndex; k++) {
            resultantSubarray[i] = nums[k];
            i++;
        }

        if (endingIndex == -1) {
            return new int[0];
        }
        return resultantSubarray;
    }

    // Driver Class (Must be excluded in the online judge submission)
    public static class Driver {
        public static void main(String[] args) {
            // Code starts from here.
            SubArrayWithGivenSum subArrayWithGivenSum = new SubArrayWithGivenSum();
            int res[] = subArrayWithGivenSum.subArrayWithGivenSum(new int[]{10, 15, -5, 15, -10, 5}, 5);
            // int res[] = subArrayWithGivenSum.subArrayWithGivenSum(new int[]{1, 2, 3, 7, 5}, 0);
           //  int res[] = subArrayWithGivenSum.subArrayWithGivenSum(new int[]{1, 2, 3, 7, 5}, -20);
         //     int res[] = subArrayWithGivenSum.subArrayWithGivenSum(new int[]{5}, 10);

            for (int i = 0; i < res.length; i++) {
                System.out.print(res[i] + " ");
            }
        }
    }
}

// Conclusion: Approach 2 is more optimal
// FUTURE PLAN: I will find more approaches.

