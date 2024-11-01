package random.leetcode.binary_search;

// Replace class name with "Solution" when submit it to LeetCode
class BinarySearch {

    //Define Approaches
    enum Approach {
        FIRST_APPROACH,
        SECOND_APPROACH,
        THIRD_APPROACH,
    }

    // Input the approach you want to execute.
    private static final Approach approach = Approach.SECOND_APPROACH;


    // Maintain the actual method name provided by LeetCode to avoid any error during submission time
    public int search(int[] nums, int target) {
        if (approach.equals(Approach.FIRST_APPROACH)) {
            return Approach_1(nums, target);
        } else if (approach.equals(Approach.SECOND_APPROACH)) {
            return Approach_2(nums, target, 0, nums.length - 1);
        }
//        else if (approach.equals(Approach.THIRD_APPROACH)) {
//            return Approach_Your_Approach_Number(your_inputs);
//        }
        return 0;
    }

    // Approach_1: Using Binary Search Algorithm with TC -> O(logn), SC -> O(1)
    // Outcome: ACCEPTED
    /*
     ---------------------------------------------------------------------- NOTE ----------------------------------------------------------------------
     * Make a short note on your approach
     note: must run the loop until while(left<=right)
     because, if we run the loop left<right, we will get wrong ans. In many cases, left == right and we will get our target element
    */
    /*
     ---------------------------------------------------------------------- Algorithm ----------------------------------------------------------------------
     * Write an algorithm on your approach.
    */
    private int Approach_1(int[] nums, int target) {
        // Code starts from here.
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    // Approach_1: Using Recursion with TC -> O(log2n), SC -> O(log2n) -> recursive stack / call stack / auxiliary memory
    // Outcome: ACCEPTED
    /*
     ---------------------------------------------------------------------- NOTE ----------------------------------------------------------------------
     * Make a short note on your approach
     // there is no need of else if here, if we return the statement before
     // TC: O(logn) => n/2, n/2*2, n/2*2*2 ..... n/2^k = 1
     Now, n/2^K = 1
     then, n = 2^K
     then, log2n = K (ans) tc -> Atmost, O(log2n)
     */
    /*
     ---------------------------------------------------------------------- Algorithm ----------------------------------------------------------------------
     * Write an algorithm on your approach.
    */
    private int Approach_2(int[] nums, int target, int low, int high) {
        // Code starts from here.
        if (low > high) {
            return -1;
        }
        int mid = (low + high) / 2;
        if (nums[mid] == target) {
            return mid;
        }

        if (nums[mid] > target) {
            return Approach_2(nums, target, low, mid - 1);
        }
//        else {
//            return Approach_2(nums, target, mid + 1, high);
//        }
        return Approach_2(nums, target, mid + 1, high);

    }

    // Driver Class (Must be excluded in the online judge submission)
    public static class Driver {
        public static void main(String[] args) {
            // Code starts from here.
            BinarySearch binarySearch = new BinarySearch();
            int index = binarySearch.search(new int[]{1, 2, 3, 4, 7}, 7);
            System.out.println(index);
        }
    }
}

// Conclusion: Compare your approaches and report the best one according to your findings.
// FUTURE PLAN: Write about your upcoming approaches on this problem.

