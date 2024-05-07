package blind75.striver;

enum Approach {
    FIRST_APPROACH,
    SECOND_APPROACH,
    THIRD_APPROACH,
}

class Solution {
    // Input the approach you want to execute.
    private static final Approach approach = Approach.SECOND_APPROACH;

    public int[] productExceptSelf(int[] nums) {
        if (approach == Approach.FIRST_APPROACH) {
            return Approach_1(nums);
        } else if (approach == Approach.SECOND_APPROACH) {
            return Approach_2(nums);
        } else if (approach == Approach.THIRD_APPROACH) {
            return Approach_2(nums);
        }
        return null;
    }

    //blind75.striver.Approach 1: Bruteforce with double loops and  division operator (TC:O(n2) SC: 0(n))
    /*
     ---------------------------------------------------------------------- NOTE ----------------------------------------------------------------------
     * find the product of all the elements (except zero) and store it into "productWithOutZero" variable using single loop
     * count the number of zeroes on the given input array
     * now check the conditions:
     * 1. if there is a single zero in the given input array : That's mean the index in which there is a zero will be filled with non-zero product and other's will be filled with 0's
     * 2. if there is more than one zero in the given input array : That's means whole result array will be filled with zero's.
     * 3. if there is not even a single zero in the given input array : it's simple. Divide each element with the non-zero product.
    */
    private int[] Approach_1(int[] nums) {
        return nums;
    }


    // blind75.striver.Approach 2: with division operator and single loop (TC:O(n) SC: 0(1))
    /*
     ---------------------------------------------------------------------- NOTE ----------------------------------------------------------------------
     * find the product of all the elements (except zero) and store it into "productWithOutZero" variable using single loop
     * count the number of zeroes on the given input array
     * now check the conditions:
     * 1. if there is a single zero in the given input array : That's mean the index in which there is a zero will be filled with non-zero product and other's will be filled with 0's
     * 2. if there is more than one zero in the given input array : That's means whole result array will be filled with zero's.
     * 3. if there is not even a single zero in the given input array : it's simple. Divide each element with the non-zero product.
    */
    private int[] Approach_2(int[] nums) {
        int zeroCount = 0;
        int productWithOutZero = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeroCount++;
            } else {
                productWithOutZero = productWithOutZero * nums[i];
            }

        }

        for (int i = 0; i < nums.length; i++) {
            if (zeroCount == 1) {
                if (nums[i] == 0) {
                    nums[i] = productWithOutZero;
                } else {
                    nums[i] = 0;
                }
            } else if (zeroCount >= 1) {
                nums[i] = 0;
            } else {
                nums[i] = productWithOutZero / nums[i];
            }
        }
        return nums;
    }
}

//blind75.striver.Driver Class (Must be excluded in the online judge submission)
class Driver {
    public static void main(String[] args) {
        // int nums[] = {1, 2, 3, 4};
        int nums[] = {-1, 1, 0, -3, 3};
        //  int nums[] = {0, 0};
        Solution sol = new Solution();
        int arr[] = sol.productExceptSelf(nums);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i != arr.length - 1) {
                System.out.print(" ");
            }

        }

    }
}