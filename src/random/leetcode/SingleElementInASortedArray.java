package random.leetcode;

//Note : This Problem is same as "SINGLE NUMBER" Problem
// Replace class name with "Solution" when submit it to LeetCode
class SingleElementInASortedArray {
    public int singleNonDuplicate(int[] nums) {
        int res = 0;
        for (int i=0;i<nums.length;i++){
            res = res ^ nums[i];
        }
        return res;
    }
}

