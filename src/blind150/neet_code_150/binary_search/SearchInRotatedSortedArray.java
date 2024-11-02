package blind150.neet_code_150.binary_search;

// Replace class name with "Solution" when submit it to LeetCode
class SearchInRotatedSortedArray {

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
            return Approach_1(nums, target);
        }
//        else if (approach.equals(Approach.SECOND_APPROACH)) {
//            return Approach_Your_Approach_Number(your_inputs);
//        } else if (approach.equals(Approach.THIRD_APPROACH)) {
//            return Approach_Your_Approach_Number(your_inputs);
//        }
        return 0;
    }

    // Approach_1: Using Binary Search, TC->O(logn), SC->O(1)
    // Outcome: ACCEPTED
    /*
     ---------------------------------------------------------------------- NOTE ----------------------------------------------------------------------
     * Make a short note on your approach
    */

    /*
     ---------------------------------------------------------------------- Algorithm ----------------------------------------------------------------------
     * Write an algorithm on your approach.
    */
    private int Approach_1(int[] nums, int target) {
        // Code starts from here.
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            //if we get the result on the mid then return the index of our target value
            if (nums[mid] == target) return mid;

            //check if left side sorted or not
            //if left side is not sorted then right side must be sorted and vice-versa
            // if left array is sorted we have to check two conditions:
            //1. if value is present in the left array then ..discard right side..and do normal binary search
            //2. if value is not present in the left array then discard the left array and search the value in the right array (repeat  if left side sorted or not steps again)

            //if right array is sort we have to check two conditions:
            //1. if value is present in the right array then ..discard left side..and do normal binary search
            //2. if value is not present in the right array then discard the right array and search the value in the left array (repeat  if left side sorted or not steps again)

            //if left side is sorted
            // here, nums[mid]> nums[low] fails in the case of [3,1], target = 1;
            if (nums[mid] >= nums[low]) {
                // if target is presented on the left side
                // check if target is smaller than the mid
                // check if target>= nums[low]..that's the case in which we can ensure that target is in the left side
                // so, ultimately, we have to check the target on the range of left side  (nums[low] <= target < num[mid])
                if (nums[mid] > target && target >= nums[low]) {
                    //discard the right side
                    high = mid - 1;
                } else {
                    //discard the left side
                    low = mid + 1;
                }
            }
            // else right side is sorted
            else {
                // if target is presented on the right side
                // check if target is greater than the mid
                // check if target<= nums[high]..that's the case in which we can ensure that target is in the right side
                // so, ultimately, we have to check the target on the range of right side  (num[mid]< target <= nums[high])
                if (nums[mid] < target && target <= nums[high]) {
                    //discard the left side
                    low = mid + 1;

                } else {
                    //discard the right side
                    high = mid - 1;
                }
            }
        }
        return -1;
    }

    // Driver Class (Must be excluded in the online judge submission)
    public static class Driver {
        public static void main(String[] args) {
            // Code starts from here.
            SearchInRotatedSortedArray searchInRotatedSortedArray = new SearchInRotatedSortedArray();
            int res = searchInRotatedSortedArray.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0);
            //int res = searchInRotatedSortedArray.search(new int[]{3, 1}, 1);
            System.out.println(res);
        }
    }
}

// Conclusion: Approach 1 is optimal
// FUTURE PLAN: I will implement more approaches.

