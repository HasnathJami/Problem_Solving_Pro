package random.leetcode.array;

// Replace class name with "Solution" when submit it to LeetCode
class MajorityElement {

    //Define Approaches
    enum Approach {
        FIRST_APPROACH,
        SECOND_APPROACH,
        THIRD_APPROACH,
    }

    // Input the approach you want to execute.
    private static final Approach approach = Approach.FIRST_APPROACH;


    // Maintain the actual method name provided by LeetCode to avoid any error during submission time
    public int majorityElement(int[] nums) {
        if (approach.equals(Approach.FIRST_APPROACH)) {
            return Approach_1(nums);
        }
//        else if (approach.equals(Approach.SECOND_APPROACH)) {
//            return Approach_Your_Approach_Number(your_inputs);
//        } else if (approach.equals(Approach.THIRD_APPROACH)) {
//            return Approach_Your_Approach_Number(your_inputs);
//        }
        return 0;
    }

    // Approach_1:Using Moore's Voting Algorithm, TC -> O(N), SC -> O(1)
    // Outcome: ACCEPTED
    /*
     ---------------------------------------------------------------------- NOTE ----------------------------------------------------------------------
     * Make a short note on your approach
     we can find the majority elements easily.

     Note:
     1. In this problem, we are implementing a logic to find the majority element in an array
     2. for example, 1,2,1,4,1 [here 1 is the ans]
     3. At first, we have to store the first value 1. and check with other values(1 to n).
     4. if any number matches with the initial value then increase the  count else decrease the count.
     5. if count is zero that mean, there is a less possibility for this element to be the majority element.
     so discard this by update the currentValue to next one, and make the next value count = 1 as we have to start from the next value;
     6. At last, we have found a current value. It's highly possible that this value will be the majority element
      (exception case: 1,2 where no value is majority element despite last current Value is 2)
     7. It's highly possible that the last finding value will be majority element. But, there is some exception case, so
     we have to verify that the last value is the majority element.
     8. For verification, we have to check the count of our last current element and check if its majority element or not (elementCount > n/2)
     9. It's highly guarantied that the last current value will be the majority element or there will be no majority element on this array
     10. If we found any majority element that's currentValueFrequencyCount must be > 0 && it must be present in the array > n/2 times
    */

    /*
     ---------------------------------------------------------------------- Algorithm ----------------------------------------------------------------------
     * Write an algorithm on your approach.
    */
    private int Approach_1(int[] nums) {
        // Code starts from here.
        int currentValueFrequencyCount = 1;
        int currentValue = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (currentValue == nums[i]) {
                currentValueFrequencyCount++;
            } else {
                currentValueFrequencyCount--;
            }

            if (currentValueFrequencyCount == 0) {
                currentValue = nums[i];
                currentValueFrequencyCount = 1;
            }
        }

        currentValueFrequencyCount = 0;
        for (int i = 0; i < nums.length; i++) {
            if (currentValue == nums[i]) {
                currentValueFrequencyCount++;
            }
        }

        if (currentValueFrequencyCount > nums.length / 2) {
            return currentValue;
        } else {
            return 0;
        }
    }

    // Driver Class (Must be excluded in the online judge submission)
    public static class Driver {
        public static void main(String[] args) {
            // Code starts from here.
            MajorityElement majorityElement = new MajorityElement();
//            int res = majorityElement.majorityElement(new int[]{3,2,3});
            int res = majorityElement.majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2});
            System.out.println(res);
        }
    }
}

// Conclusion: Approach 1 is optimal.
// FUTURE PLAN: I will write other approaches on this problem.
