package blind75.striver.array;

enum Approach {
    FIRST_APPROACH,
    SECOND_APPROACH,
    THIRD_APPROACH,
    FOURTH_APPROACH
}

class Solution {
    // Input the approach you want to execute.
    private static final Approach approach = Approach.THIRD_APPROACH;

    public int[] productExceptSelf(int[] nums) {
        if (approach.equals(Approach.FIRST_APPROACH)) {
            return Approach_1(nums);
        } else if (approach.equals(Approach.SECOND_APPROACH)) {
            return Approach_2(nums);
        } else if (approach.equals(Approach.THIRD_APPROACH)) {
            return Approach_3(nums);
        } else if (approach.equals(Approach.FOURTH_APPROACH)) {
            return Approach_4(nums);
        }
        return null;
    }

    // Approach 1: Bruteforce Approach with double loops (TC:O(n2) SC: 0(n))
    // Outcome: TLE
    /*
     ---------------------------------------------------------------------- NOTE ----------------------------------------------------------------------
     * find the product of all the elements (except self element -> i!=j) and store it into "product" variable using single double loop
     * now then store the prduct of each element(except self element) on "temp" array and reset the "product" variable
    */
    private int[] Approach_1(int[] nums) {
        int product = 1;
        int[] productsExceptSelf = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i != j) {
                    product = product * nums[j];
                }
            }
            productsExceptSelf[i] = product;
            product = 1;
        }
        return productsExceptSelf;
    }


    // Approach 2: with division operator and single loop (TC:O(n) SC: 0(1))
    // Outcome: ACCEPTED with 2 ms Runtime
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

    // Approach 3: without division operation and single loop (TC:O(n) SC: 0(N))
    // Outcome: ACCEPTED with 1 ms Runtime
    /*
     ---------------------------------------------------------------------- NOTE ----------------------------------------------------------------------
     * find the product of each element (prefix) from the left side (except itself) and store it into "productsExceptSelf" array using single loop
     * for the first element product should be 1 as there is no prefix element of it
     * reset the product as
     * find the product of each element (suffix) from the right side (except itself)
     * Then like before you not only store it into "productsExceptSelf" array using single loop but also have to multiply with the existing value of "productsExceptSelf" because we have to show our result only with the output array, and we can't use separate arrays for this.
     * Example with Steps:
       1. input array = 1[0],2[1],3[2],4[3]  where, numbers outside square bracket represents value and numbers inside square bracket (e.g., 0,1,2,3) represents index of array.
       2. productsExceptSelf array = 1(-defVal)[0], (1*1)[1], (1*1*2)[2] ,  (1*1*2*3)[3] i.e; [1,1,2,6] (result after the execution of 1st loop) (prefix product of each item except itself) -> forward loop
       3. productsExceptSelf array = 1*(2*3*4*1)[0], 1*(3*4*1)[1], 2*(4*1)[2] ,  6*(1-defVal)[3] i.e;, [24, 12, 8, 6](result after the execution of 1st loop) (suffix product * prefix product of each item except itself) -> reverse loop

    */
    private int[] Approach_3(int[] nums) {
        int product = 1;
        int[] productsExceptSelf = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            productsExceptSelf[i] = product;
            product = product * nums[i];
        }
        product = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            productsExceptSelf[i] = productsExceptSelf[i] * product;
            product = product * nums[i];
        }
        return productsExceptSelf;
    }

    // Approach 4: without division operation and single loop but using extra arrays (TC:O(n) SC: 0(N))
    // Outcome: ACCEPTED with 2 ms runtime
    /*
     ---------------------------------------------------------------------- NOTE ----------------------------------------------------------------------
     * find the product of each element (prefix) from the left side (except itself) and store it into "prefixProductsExceptSelf" array using single loop
     * for the first element product should be 1 as there is no prefix element of it
     * reset the product as
     * find the product of each element (suffix) from the right side (except itself)
     * find the product of each element (suffix) from the right side (except itself) and store it into "suffixProductsExceptSelf" array using single loop
     * Example with Steps:
       same like third approach but here we have used separate arrays for prefix, suffix and result

    */
    private int[] Approach_4(int[] nums) {
        int product = 1;
        int[] resultantProductsExceptSelf = new int[nums.length];
        int[] prefixProductsExceptSelf = new int[nums.length];
        int[] suffixProductsExceptSelf = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            prefixProductsExceptSelf[i] = product;
            product = product * nums[i];
        }
        product = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            suffixProductsExceptSelf[i] = product;
            product = product * nums[i];
        }

        for (int i = 0; i < nums.length; i++) {
            resultantProductsExceptSelf[i] = prefixProductsExceptSelf[i] * suffixProductsExceptSelf[i];
        }
        return resultantProductsExceptSelf;
    }
}

// Conclusion: Approach-2 is more efficient with O(1) SC and O(N) TC. But if division operation is not allowed then Approach-3 is more efficient with a good runtime (1 ms) than others
// FUTURE PLAN: In the future, try to implement more approaches (i.e., prefix-postfix reference from neet_code channel or other approaches), INSHAALLAH

//Driver Class (Must be excluded in the online judge submission)
class Driver {
    public static void main(String[] args) {
         int nums[] = {1, 2, 3, 4};
        // int nums[] = {-1, 1, 0, -3, 3};
        // int nums[] = {0, 0};
        // int nums[] = {0, 1};
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