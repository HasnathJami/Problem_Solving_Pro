package blind150.neet_code_150.two_pointer;

// Replace class name with "Solution" when submit it to LeetCode
class TrappingRainWater {

    //Define Approaches
    enum Approach {
        FIRST_APPROACH,
        SECOND_APPROACH,
        THIRD_APPROACH,
    }

    // Input the approach you want to execute.
    private static final Approach approach = Approach.FIRST_APPROACH;


    // Maintain the actual method name provided by LeetCode to avoid any error during submission time
    public int trap(int[] your_inputs) {
        if (approach.equals(Approach.FIRST_APPROACH)) {
            return Approach_1(your_inputs);
        }
//        else if (approach.equals(Approach.SECOND_APPROACH)) {
//            return Approach_Your_Approach_Number(your_inputs);
//        }
//        else if (approach.equals(Approach.THIRD_APPROACH)) {
//            return Approach_Your_Approach_Number(your_inputs);
//        }
        return 0;
    }

    // Approach_Your_Approach_Number: Using Preprocessing Array with TC-> O(N), SC -> O(N)
    // Outcome: ACCEPTED
    /*
     ---------------------------------------------------------------------- NOTE ----------------------------------------------------------------------
     * Make a short note on your approach
     1. Here in this approach,
     Rain water in each block calculates by finding the max height of left most block and right most block of each element
     so, we have to maintain two array first, left array and right array..
     left array-> max left most height before each block
     right array-> max right most height after each block
     then we have to find trapping rain water by
     trappingWater = min of (max left most height before each block, max right most height after each block) - block height
     here, we have to find min. because if we find max than, water will not be trapping instead it will be flowing
    */

    /*
     ---------------------------------------------------------------------- Algorithm ----------------------------------------------------------------------
     * Write an algorithm on your approach.
    */
    private int Approach_1(int[] nums) {
        // Code starts from here.
        if (nums.length < 3) return 0;
        int left[] = new int[nums.length];
        int right[] = new int[nums.length];
        int maxValue = Integer.MIN_VALUE;
        int totalSum = 0;
        right[nums.length - 1] = nums[nums.length - 1];
        for (int i = 0; i < nums.length; i++) {
            maxValue = Math.max(maxValue, nums[i]);
            left[i] = maxValue;
        }

        maxValue = Integer.MIN_VALUE;
        for (int i = nums.length - 1; i >= 0; i--) {
            maxValue = Math.max(maxValue, nums[i]);
            right[i] = maxValue;
        }

        for(int i =0;i<nums.length;i++) {
            totalSum += (Math.min(left[i], right[i]) - nums[i]);
        }

        return totalSum;
    }

    // Driver Class (Must be excluded in the online judge submission)
    public static class Driver {
        public static void main(String[] args) {
            // Code starts from here.
            TrappingRainWater trappingRainWater = new TrappingRainWater();
            int res = trappingRainWater.trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1});
            System.out.println(res);
        }
    }
}

// Conclusion: Approach-1 is optimal
// FUTURE PLAN: I will implement other approaches.

