package random.leetcode.binary_search;

// Replace class name with "Solution" when submit it to LeetCode
class SearchAnElementInAnInfiniteSortedArray {

    //Define Approaches
    enum Approach {
        FIRST_APPROACH,
        SECOND_APPROACH,
        THIRD_APPROACH,
    }

    // Input the approach you want to execute.
    private static final Approach approach = Approach.FIRST_APPROACH;


    // Maintain the actual method name provided by LeetCode to avoid any error during submission time
    public int search(int[] nums, int target) {
        if (approach.equals(Approach.FIRST_APPROACH)) {
            return Approach_1_Find_Range(nums, target);
        }
//        else if (approach.equals(Approach.SECOND_APPROACH)) {
//            return Approach_2(nums, target, 0, nums.length - 1);
//        }
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
    private int Approach_1(int[] nums, int target, int low, int high) {
        // Code starts from here.
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    //TC -> O(logn), SC -> O(1)
    private int Approach_1_Find_Range(int [] nums, int target) {
        // in the real question, "nums" should be infinity range
        int low = 0;
        int high = 1;
        while(nums[high] < target) {
            // here, we can set the value of low always 0. as it will be later perform on logn operation,
            // but for optimizing our code, it's not needed to check from 0 to target Range. As, we have check our range based on target range
            // we are also getting the low range in which target element should be presented.
            low = high; // for the previous range before crossing target range, it will consider as low
            high = 2 * high; // high range increases exponentially until getting the equal or larger value than target
        }

        return Approach_1(nums, target, low, high);
    }

    // Driver Class (Must be excluded in the online judge submission)
    public static class Driver {
        public static void main(String[] args) {
            // Code starts from here.
            SearchAnElementInAnInfiniteSortedArray searchAnElementInAnInfiniteSortedArray = new SearchAnElementInAnInfiniteSortedArray();
            int index = searchAnElementInAnInfiniteSortedArray.search(new int[]{1, 2, 3, 4, 7}, 7);
            System.out.println(index);
        }
    }
}

// Conclusion: Compare your approaches and report the best one according to your findings.
// FUTURE PLAN: Write about your upcoming approaches on this problem.

