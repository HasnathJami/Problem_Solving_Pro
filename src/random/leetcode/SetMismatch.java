package random.leetcode;

// Note: The concept of the problem is Similar to 'Missing Number' and 'Single Number III'
class SetMismatch {

    // Using Counting Array
    public int[] findErrorNums(int[] nums) {
        int countArray[] = new int[nums.length + 1];
        int resArray[] = new int[2];
        //   Arrays.fill(resArray, 0);

        int missingNumber = 0;
        int repeatingNumber = 0;
        for (int i = 0; i < nums.length; i++) {
            countArray[nums[i]]++;
        }
        for (int i = 1; i <= nums.length; i++) {
            if (countArray[i] == 0) {
                resArray[1] = i;
//                missingNumber = i;
            } else if (countArray[i] > 1) {
                resArray[0] = i;
//                repeatingNumber = i;
            }
        }
//        return new int[]{repeatingNumber, missingNumber};
        return resArray;
    }


    // Using Bit Manipulation
//     public int[] findErrorNums(int[] nums) {
//         int resArray[] = new int[2];
// //        int fullXor = 0;
//         int resXor = 0;
// //        for (int i = 0; i < nums.length; i++) {
// //            fullXor = fullXor ^ nums[i];
// //        }
// //        for (int i = 1; i <= nums.length; i++) {
// //            resXor = i ^ fullXor;
// //        }
//         // OR, we can use single loop to perform the both operations ( full Xor + Find Missing Number) without using dual loop
//         for(int i=0;i<nums.length;i++) {
//             resXor = resXor ^ nums[i] ^ (i+1);
//         }
//         int rightMostSetBit = resXor & -resXor;
//         int _resXor = resXor; //store the main result to temp variable for manipulation


//         for (int i = 0; i < nums.length; i++) {
//             // for duplicate number
//             if ((rightMostSetBit & nums[i]) > 0) {
//                 _resXor ^= nums[i];
//             }
//             //for missing number
//             if (((i + 1) & rightMostSetBit) > 0) {
//                 _resXor ^= (i + 1);
//             }
//         }

//         resArray[0] = _resXor;
//         resArray[1] = _resXor ^ resXor;

//         // for maintaining order accroding to output
//         for(int i = 0;i<nums.length;i++) {
//             if(resArray[1] == nums[i]) {
//                resArray[1] = _resXor;
//                resArray[0] = _resXor ^ resXor;
//             }
//         }

//         return resArray;
//     }
}