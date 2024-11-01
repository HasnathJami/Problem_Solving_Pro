package random.leetcode.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// Replace class name with "Solution" when submit it to LeetCode
class FindTheDuplicateNumber {

    //Define Approaches
    enum Approach {
        FIRST_APPROACH,
        SECOND_APPROACH,
        THIRD_APPROACH,
        FOURTH_APPROACH,
        FIFTH_APPROACH
    }

    // Input the approach you want to execute.
    private static final Approach approach = Approach.SECOND_APPROACH;


    // Maintain the actual method name provided by LeetCode to avoid any error during submission time
    public int findDuplicate(int[] nums) {
        if (approach.equals(Approach.FIRST_APPROACH)) {
            return Approach_1(nums);
        } else if (approach.equals(Approach.SECOND_APPROACH)) {
            return Approach_2(nums);
        } else if (approach.equals(Approach.THIRD_APPROACH)) {
            return Approach_3(nums);
        } else if (approach.equals(Approach.FOURTH_APPROACH)) {
            return Approach_4(nums);
        } else if (approach.equals(Approach.FIFTH_APPROACH)) {
            return Approach_5(nums);
        }
        return 0;
    }

    // Approach_1:Using Arrays and Sum Formula, TC -> O(N), SC -> O(1)
    // Problem: Modifying the array (does not match with leet code problem requirements)
    // Outcome: ACCEPTED
    /*
     ---------------------------------------------------------------------- NOTE ----------------------------------------------------------------------
     * Make a short note on your approach


    /*
     ---------------------------------------------------------------------- Algorithm ----------------------------------------------------------------------
     * Write an algorithm on your approach.
    */
    private int Approach_1(int[] nums) {
        // Code starts from here.
        for (int i = 0; i < nums.length; i++) {
            int value = Math.abs(nums[i]);
            if (nums[value] < 0) {
                return value;
            }

            nums[value] = -nums[value];
        }
        return 0;
    }

    // Approach_2:Using Floyd’s Cycle-Finding Algorithm, TC -> O(N), SC -> O(1)
    //It's solves the problem of approach 1 by not modifying the array
    // Outcome: ACCEPTED
    /*
     ---------------------------------------------------------------------- NOTE ----------------------------------------------------------------------
     * Make a short note on your approach
      // It's base on Hare-Tortoise (Fast-Slow) pointer technique
      // If there is a duplicate value then two pointers must meet each other.
      // This approach works in 2 steps:
      // firstly, we have to detect that there is a cycle present in the array (here, cycle means duplicate value)
      // secondly, we have to find the duplicate value
      Note:In Floyd's Cycle Detection (Tortoise and Hare) algorithm,
      we require a second traversal after the initial do-while loop because the first loop only confirms the existence of a cycle,
      but it does not locate the exact starting point of the cycle, which corresponds to the duplicate value.
     */

    /*
     ---------------------------------------------------------------------- Algorithm ----------------------------------------------------------------------
     * Write an algorithm on your approach.
    */
    private int Approach_2(int[] nums) {
        // Code starts from here.
        //initially, we have point the fast and slow pointer to the first value
        int slow = nums[0];
        int fast = nums[0];

        // we have to use do while loop for storing  the value first then check technique
        // here, we have to move slow pointer to 1 step
        // and fast pointer to 2 steps
        // if slow == fast, that means there is a cycle(duplicate value) there
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);


        // we have to reset the fast pointer for further traversal process
        // here, we have to move slow pointer to 1 step
        // and fast pointer to 1 step this time
        // when they meet again, we can get the duplicate value
        // so the ans is fast/slow. we can return anyone.
        fast = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return fast;
    }

    // Approach_3:Using HashMap, TC -> O(N), SC -> O(N)
    // Outcome: ACCEPTED
    /*
     ---------------------------------------------------------------------- NOTE ----------------------------------------------------------------------
     * Make a short note on your approach
          //We can commonly use hashmap for finding duplicates using count the frequency of the nums
          // In this, approach we have tried a different way to find duplicates
          // when, we keep a new value to hashmap with key it returns "null". But, we try to keep a new value with the same key
           it returns the previous value of this key.
          // so, we have to check if it returns null or not. If it returns null then no duplicate value has tried to store.
     */

    /*
     ---------------------------------------------------------------------- Algorithm ----------------------------------------------------------------------
     * Write an algorithm on your approach.
    */
    private int Approach_3(int[] nums) {
        // Code starts from here.
        Map<Integer, Integer> hm = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            Integer a = hm.put(nums[i], i);
            if (a != null) {
                return nums[i];
            }
        }
        return 0;
    }

    // Approach_4:Using HashSet, TC -> O(N), SC -> O(N)
    // Outcome: ACCEPTED
    /*
     ---------------------------------------------------------------------- NOTE ----------------------------------------------------------------------
     * Make a short note on your approach
          // In this, approach we have tried a different way to find duplicates
          // when, we keep a new value to hashset it returns "true". But, we try to keep duplicate value then it returns "false"
          // so, we have to check if it returns true or false. If it returns false then duplicate value has tried to store.
     */

    /*
     ---------------------------------------------------------------------- Algorithm ----------------------------------------------------------------------
     * Write an algorithm on your approach.
    */
    private int Approach_4(int[] nums) {
        // Code starts from here.
        Set<Integer> hs = new HashSet();
        Boolean isUnique;
        for (int num : nums) {
            isUnique = hs.add(num);
            if (!isUnique) {
                return num;
            }
        }
        return 0;
    }

    // Approach_4:Using Bruteforce, TC -> O(N^N), SC -> O(1)
    // Outcome: TLE
    /*
     ---------------------------------------------------------------------- NOTE ----------------------------------------------------------------------
     * Make a short note on your approach
          // In this approach, we have to tried to find duplicate using 2loops.
          // Note: here, we have start from j = i in every iteration because
          there is no need to iterate from 0 to the inner loop.
          as if an element is duplicate, we could get it earlier, and we wouldn't need to come so far for finding duplicates.
     */

    /*
     ---------------------------------------------------------------------- Algorithm ----------------------------------------------------------------------
     * Write an algorithm on your approach.
    */
    private int Approach_5(int[] nums) {
        // Code starts from here.
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return nums[i];
                }
            }
        }
        return 0;
    }

    // Driver Class (Must be excluded in the online judge submission)
    public static class Driver {
        public static void main(String[] args) {
            // Code starts from here.
            FindTheDuplicateNumber findTheDuplicateNumber = new FindTheDuplicateNumber();
          //  int res = findTheDuplicateNumber.findDuplicate(new int[]{1, 3, 4, 2, 2});
            //   int res = findTheDuplicateNumber.findDuplicate(new int[]{1, 2, 4, 2, 3});
            int res = findTheDuplicateNumber.findDuplicate(new int[]{3, 3, 1, 4, 2});
            System.out.println(res);
        }
    }
}

// Conclusion: Approach 2 is optimal.
// FUTURE PLAN: I will write other approaches on this problem.


