package blind150.neet_code_150.array;
// Replace class name with "Solution" when submit it to LeetCode
class BestTimeToBuyAndSellStockII {

    //Define Approaches
    enum Approach {
        FIRST_APPROACH,
        SECOND_APPROACH,
        THIRD_APPROACH,
    }

    // Input the approach you want to execute.
    private static final Approach approach = Approach.FIRST_APPROACH;


    // Maintain the actual method name provided by LeetCode to avoid any error during submission time
    public int maxProfit(int[] your_inputs) {
        if (approach.equals(Approach.FIRST_APPROACH)) {
            return Approach_1(your_inputs);
        }
//        else if (approach.equals(Approach.SECOND_APPROACH)) {
//            return Approach_Your_Approach_Number(your_inputs);
//        } else if (approach.equals(Approach.THIRD_APPROACH)) {
//            return Approach_Your_Approach_Number(your_inputs);
//        }
        return 0;
    }

    // Approach_1:Using Array, TC -> O(N), SC -> O(1)
    // Outcome: ACCEPTED
    /*
     ---------------------------------------------------------------------- NOTE ----------------------------------------------------------------------
     * Make a short note on your approach
    */
       //we can find the maximum profit by subtract local minima with local maxima in each iteration and add them
       // local minima = previous value > local minima < next value
       // local maxima = previous value < local maxima > next value

      // but instead of this, we can solve this problem easily with the following approach.


    /*
     ---------------------------------------------------------------------- Algorithm ----------------------------------------------------------------------
     * Write an algorithm on your approach.
    */
    private int Approach_1(int[] prices) {
        // Code starts from here.
        int maxProfit = 0;
        //if previous stock price in minimum then next stock.. then buy this stock in minimum amount and sell this on maximum amount and add sum in each iteration, and at last we can get MAX profit by applying this approach.
        for(int i = 0;i<prices.length-1;i++) {
            if(prices[i]<prices[i+1]) {
                maxProfit += prices[i+1] - prices[i];
            }
        }
        return maxProfit;
    }

    // Driver Class (Must be excluded in the online judge submission)
    public static class Driver {
        public static void main(String[] args) {
            // Code starts from here.
            BestTimeToBuyAndSellStockII bestTimeToBuyAndSellStockII = new BestTimeToBuyAndSellStockII();
            int res = bestTimeToBuyAndSellStockII.Approach_1(new int[]{7,1,5,3,6,4});
            System.out.println(res);
        }
    }
}

// Conclusion: Approach 1 is optimal.
// FUTURE PLAN: I will write other approaches on this problem.
