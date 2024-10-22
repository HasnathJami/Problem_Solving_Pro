// package name (Must be excluded in the online judge submission)
package random;

import java.util.HashMap;

// Replace class name with "Solution" when submit it to LeetCode
class ContiguousArray {

    //Define Approaches
    enum Approach {
        FIRST_APPROACH,
        SECOND_APPROACH,
        THIRD_APPROACH,
    }

    // Input the approach you want to execute.
    private static final Approach approach = Approach.FIRST_APPROACH;


    // Maintain the actual method name provided by LeetCode to avoid any error during submission time
    public int contiguousArray(int[] your_inputs) {
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

    // Approach_1: Using Hashmap and Prefix Sum, TC-> 0(N), SC->O(N)
    // Outcome: ACCEPTED
    /*
     ---------------------------------------------------------------------- NOTE ----------------------------------------------------------------------
     * Make a short note on your approach
       1. Here, in this approach, firstly we have to understand the mathematics and logic between this.
       2. Example: 0 1 0 1 1 0
       3. convert 0 with -1 (this for checking the equal frequencies of 0, and 1), init count map with the value of (key, value) => (0, -1), this for counting length when 0 is found.
       4. then, -1 1 -1 1 1 -1
       5. PrefixSum: -1 0 -1 0 1 0
       6. CountMap : for storing (key, value), here, key is the prefix sum and value is the index of prefix sum.
       7. if same prefix sum have found before then don't add this to hashmap. Instead of this, count the sub-array length = ( current index - previous index in which it was found before)
       8. update the maxValue if it is maximum than before else not.



       Mathematics Behind This:
       ========================
       PrefixSum: -1 0 -1 0 1 0
       here,
       Iteration 1: it becomes -1,
       Iteration 2: then it becomes 0 means (here, 0,1 are in equal number that's why the sum is 0) (length of subarray = 1 - (-1) = 2 ( here, -1 is the value of 0 that we have stored for this reason)
       Iteration 3: it becomes -1, as we can see that -1 is already added to the map.that's means it was before -1 then after some calculation it becomes -1 again. It is only possible if the number of 1 and -1(that's mean 0) is equal.
       so, we will find the subarray to the range of (index of  -1 ,when it was first seen + 1 to current array) (here, +1 is added because after this index we have the equal numbers of 1 and 0 so that it will be same again)
       length of subarray = (currentIndex - previous index in which it was found before)
       so on...
       At Last, we have to found the maxSubarrayLength..from these..lengths of sub-array that we have found in each iteration

    */
    /*
     ---------------------------------------------------------------------- Algorithm ----------------------------------------------------------------------
     * Write an algorithm on your approach.
    */
    private int Approach_1(int[] nums) {
        // Code starts from here.
        int maxLength = 0;
        int prefixSum = 0;
        HashMap<Integer, Integer> countMap = new HashMap();
        countMap.put(0, -1);

        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i] == 1 ? 1 : -1;

            if (countMap.containsKey(prefixSum)) {
                maxLength = Math.max(maxLength, i - countMap.get(prefixSum));
            } else {
                countMap.put(prefixSum, i);
            }
        }
        return maxLength;
    }

    // Driver Class (Must be excluded in the online judge submission)
    public static class Driver {
        public static void main(String[] args) {
            // Code starts from here.
            ContiguousArray contiguousArray = new ContiguousArray();
            int res = contiguousArray.contiguousArray(new int[]{0,1,0,1,1,0});
            System.out.println(res);
        }
    }
}

// Conclusion: Approach 1 is optimal
// FUTURE PLAN: I will implement the bruteforce approach
