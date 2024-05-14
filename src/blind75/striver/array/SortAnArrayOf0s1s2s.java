// package name (Must be excluded in the online judge submission)
package blind75.striver.array;


//Define Approaches

// Replace class name with "Solution" when submit it to LeetCode
class SortAnArrayOf0s1s2s {
    enum Approach_SortAnArrayOf0s1s2s {
        FIRST_APPROACH,
        SECOND_APPROACH,
        THIRD_APPROACH,
    }

    // Input the approach you want to execute.
    private static final Approach_SortAnArrayOf0s1s2s approach = Approach_SortAnArrayOf0s1s2s.THIRD_APPROACH;

    // Maintain the actual method name provided by LeetCode to avoid any error during submission time
    public void sortColors(int[] nums) {
        if (approach.equals(Approach_SortAnArrayOf0s1s2s.FIRST_APPROACH)) {
            Approach_1(nums);
        } else if (approach.equals(Approach_SortAnArrayOf0s1s2s.SECOND_APPROACH)) {
            Approach_2(nums);
        } else if (approach.equals(Approach_SortAnArrayOf0s1s2s.THIRD_APPROACH)) {
            Approach_3(nums);
        }
    }

    // Approach_0: Using Native Approach(Arrays.sort(nums) TC = 0(nlogn) and SC = 0(1)

    // Approach_1: Using Bruteforce Approach(i.e;, any type of sorting Algorithm (Similar to Counting Sort) TC = 0(n2) and SC = 0(1)
    // I have used Bubble Sort here
    // Outcome: TLE
    /*
     ---------------------------------------------------------------------- NOTE ----------------------------------------------------------------------
     * if the number length is 1 no need perform the operation, just return it.
     * searching elements, in nested loops, check two element of adjacent index
      - if first one is greater than the second one then swap them.
      - at the last, after the iteration in the inner loop, the last element is the biggest element in that array. so  j < nums.length-1-i (i.e., exclude the the last elements for further iteration)
      - at the last, after all the iteration int the outer loop the full array is sorted. here, i<nums.length-1 means that if array length is 6, the iteration will be 6-1 = 5 because after 5 iteration in the outer loop don't need to check for the first element which will be already in its right position
     * optimized the algorithm in that case where full array is already sorted. So, we can achieve the result in only one pass with the TC of 0(n). We have achieved this with checking if any swapping operation have performed in the following inner loop Because if this is an unsorted array at least one swap would be performed.
    */
    /*
     ---------------------------------------------------------------------- Algorithm ----------------------------------------------------------------------
     * Bubble Sort Algorithm from DSA_PRO Resource
    */
    private int[] Approach_1(int[] nums) {
        if (nums.length == 1) {
            return nums;
        }

        boolean isSwappedOnce = false;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    swap(j, j + 1, nums);
                    isSwappedOnce = true;
                }
            }
            if (!isSwappedOnce) {
                break;
            }
        }

        showResult(nums);

        return nums;
    }

    // Approach_2: Using Counting Sort Algorithm (Similar to Counting Sort) TC = 0(2n) and  and SC = 0(1)
    // 0(2n) = 0(n) when counting occurances of 0,1,2 + 0(n) when input the values based on counting
    // Outcome: ACCEPTED
    /*
     ---------------------------------------------------------------------- NOTE ----------------------------------------------------------------------
     * If the number length is 1 no need perform the operation, just show it.
     * In this approach, first we have to count the number of 0's 1's and 1's in the array.
     * Then, modify the array by filling it up with our counting values one after another. Starting from the smaller ones first (i.e., 0 > 1 > 2)
    */

    /*
     ---------------------------------------------------------------------- Algorithm ----------------------------------------------------------------------
     * Counting Sort Algorithm from DSA_PRO Resource
    */
    private void Approach_2(int[] nums) {

        if (nums.length == 1) {
            showResult(nums);
        }

        int countZeroes = 0;
        int countOnes = 0;
        int countTwos = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                countZeroes++;
            } else if (nums[i] == 1) {
                countOnes++;
            } else {
                countTwos++;
            }
        }
        for (int i = 0; i <= nums.length; i++) {
            if (countZeroes > 0) {
                nums[i] = 0;
                countZeroes--;
            } else if (countOnes > 0) {
                nums[i] = 1;
                countOnes--;
            } else if (countTwos > 0) {
                nums[i] = 2;
                countTwos--;
            }
        }
        showResult(nums);

    }

    // Approach_3: Using Dutch National Flag Algorithm (Similar to Counting Sort) TC = 0(n) and SC = 0(1)
    // Using Pointers
    /*
     ---------------------------------------------------------------------- NOTE ----------------------------------------------------------------------
     * we take three pointers low,mid,high... mid is the pointer with which we have to implement some logics, and it is the pointer which will be traversed in the array
     * here, we check some conditions:
      - if we found mid-pointer value == 0 then  swap the low with mid. and increase the value of low  to 1, as on the leftmost side, we have placed 0 which is fixed. move the mid-pointer also for further traversing.
      - if we found mid-pointer value == 1 don't need any swap and just increment the mid-pointer to 1...as in this range we want to fix it's position.
      - if we found mid-pointer value == 2 swap the mid-value with high value. just decrease the high value to 1 as in the rightmost side we have placed 2 which is fixed. But, don't increase the value of mid-pointer as after swapping we have placed the previous value of high index which might not be 1 all the time it can be 0 or 2 and for these 0 and 2 we have condition. If we increase the value of mid-pointer and value is 0 or 2, it will be skipped as we have to check the conditions of these two value and place them to their respective position. But, if we get 1 to that mid-position then also don't need to increase the mid-pointer as in the next check when it checks with 1 and the mid-pointer will be increased perfectly.
     * at last in the sorted array, the scenarios are
      - num[0.. low -1 ] = 0
      - num[low..high ] = 1
      - num[high+1.. n -1 ] = 2
      - the 0's 1's and 2's are filled with above positions
    */

    private void Approach_3(int[] nums) {
        int low = 0;
        int mid = 0;
        int high = nums.length - 1;

        while (mid <= high) {
            if (nums[mid] == 0) {
                swap(low, mid, nums);
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                mid++;
            } else {
                swap(mid, high, nums);
                high--;
            }
        }
        showResult(nums);
    }

    private void swap(int firstIndex, int secondIndex, int nums[]) {
        //with using temp variable
//        int temp = nums[firstIndex];
//        nums[firstIndex] = nums[secondIndex];
//        nums[secondIndex] = temp;

        //without using temp variable
        nums[firstIndex] = nums[firstIndex] + nums[secondIndex];
        nums[secondIndex] = nums[firstIndex] - nums[secondIndex];
        nums[firstIndex] = nums[firstIndex] - nums[secondIndex];
    }

    private void showResult(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]);
            if (i != nums.length - 1) {
                System.out.print(" ");
            }

        }
    }

    // Driver Class (Must be excluded in the online judge submission)
    public static class Driver_SortAnArrayOf01s02s03s {
        public static void main(String[] args) {
            int nums[] = {2, 0, 2, 1, 1, 0};
//        // int nums[] = {2,0,1};
            SortAnArrayOf0s1s2s sol = new SortAnArrayOf0s1s2s();
            sol.sortColors(nums);

        }
    }
}

// Conclusion: Approach_3 is more optimal as here, TC(N) and SC(1) respectively.
// FUTURE PLAN: Write about your upcoming approaches on this problem from many resources.