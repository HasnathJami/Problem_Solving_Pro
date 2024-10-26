package random.leetcode.hashing;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

// Replace class name with "Solution" when submit it to LeetCode
class IntersectionOfTwoArrays {

    //Define Approaches
    enum Approach {
        FIRST_APPROACH,
        SECOND_APPROACH,
        THIRD_APPROACH,
    }

    // Input the approach you want to execute.
    private static final Approach approach = Approach.SECOND_APPROACH;


    // Maintain the actual method name provided by LeetCode to avoid any error during submission time
    public int[] intersection(int[] nums1, int[] nums2) {
        if (approach.equals(Approach.FIRST_APPROACH)) {
            return Approach_1(nums1, nums2);
        }
        else if (approach.equals(Approach.SECOND_APPROACH)) {
            return Approach_2(nums1, nums2);
        }
//        else if (approach.equals(utils.BoilerPlate.Approach.THIRD_APPROACH)) {
//            return Approach_Your_Approach_Number(your_inputs);
//        }
        return null;
    }

    // Approach_1: HashSet Approach, TC => O(n), SC => O(n)
    // Outcome: TLE
    /*
     ---------------------------------------------------------------------- NOTE ----------------------------------------------------------------------
     * Make a short note on your approach

    */

    /*
     ---------------------------------------------------------------------- Algorithm ----------------------------------------------------------------------
     * Write an algorithm on your approach.
    */
    private int[] Approach_1(int[] nums, int[] nums2) {
        // Code starts from here.
        List<Integer> resultList = new ArrayList();

        HashSet<Integer> hs = new HashSet();

        // At first, add first array values to hashset for compare with second array value
        for (int i = 0; i < nums.length; i++) {
            hs.add(nums[i]);
        }

        // check if the value of first array is present in the second array or not. if present then store the result,
        // remove the value of this from hash set for eliminating duplicate values
        // if we remove this value from hashset.then the duplicate value won't be checked again, and we can get unique one
        for (int j = 0; j < nums2.length; j++) {
            if (hs.contains(nums2[j])) {
                resultList.add(nums2[j]);
                hs.remove(nums2[j]);
            }
        }

        // as, array don't support dynamic size, we have to use ArrayList for storing our value and store the Array List value to the int array to return the result
        int resultArr[] = new int[resultList.size()];

        for (int i = 0; i < resultList.size(); i++) {
            resultArr[i] = resultList.get(i);
        }
        return resultArr;
    }

    // Approach_2: Using BruteForce, TC => O(n^2), SC => O(n)
    // Outcome: TLE
    /*
     ---------------------------------------------------------------------- NOTE ----------------------------------------------------------------------
     * Make a short note on your approach
       // on this approach using nested loop to traverse.the full array and check the value of the two loops are same or not
       // using a hashset to store the value. If it's duplicate ..hashset won't add this
    */

    /*
     ---------------------------------------------------------------------- Algorithm ----------------------------------------------------------------------
     * Write an algorithm on your approach.
    */
    private int[] Approach_2(int[] nums, int[] nums2) {
        // Code starts from here.
        HashSet<Integer> hs = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (nums[i] == nums2[j]) {
                    hs.add(nums2[j]);
                }
            }
        }

        int index = 0;
        int resArray[] = new int[hs.size()];
        for (int value : hs) {
            resArray[index] = value;
            index++;
        }

        return resArray;
    }

    // Driver Class (Must be excluded in the online judge submission)
    public static class Driver {
        public static void main(String[] args) {
            // Code starts from here.
            IntersectionOfTwoArrays intersectionOfTwoArrays = new IntersectionOfTwoArrays();
//            int res[] = intersectionOfTwoArrays.intersection(new int[]{1, 2, 3, 4}, new int[]{2, 3, 4});
           int res[] = intersectionOfTwoArrays.intersection(new int[]{1, 2, 2, 1}, new int[]{2, 2});

            for (int i = 0; i < res.length; i++) {
                System.out.print(res[i] + " ");
            }
        }
    }
}

// Conclusion: Approach 1 is more optimal
// FUTURE PLAN: I will find more approaches.


