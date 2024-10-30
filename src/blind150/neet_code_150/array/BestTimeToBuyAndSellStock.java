package blind150.neet_code_150.array;

class BestTimeToBuyAndSellStock {

    //Define Approaches
    enum Approach {
        FIRST_APPROACH,
        SECOND_APPROACH,
        THIRD_APPROACH,
    }

    // Input the approach you want to execute.
    private static final Approach approach = Approach.FIRST_APPROACH;


    // Maintain the actual method name provided by LeetCode to avoid any error during submission time
    public int maxProfit(int[] nums) {
        if (approach.equals(Approach.FIRST_APPROACH)) {
            return Approach_1(nums);
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
      // we can solve this problem easily.
      // we are trying to sell every stock here, and calculate profit by min price of the stock in the past
      // minPrice means minimum price of the stock when we are trying to by it
      // so, we are subtracting the value to find our profit and find the maxProfit among them.
    /*
     ---------------------------------------------------------------------- Algorithm ----------------------------------------------------------------------
     * Write an algorithm on your approach.
    */
    private int Approach_1(int[] prices) {
        // Code starts from here.
        int minPrice = Integer.MAX_VALUE;
        int profit;
        int maxProfit = Integer.MIN_VALUE;

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            }
            // stock selling price - stock min price in the past
            profit = prices[i] - minPrice;

            if (profit > maxProfit) {
                maxProfit = profit;
            }
        }
        return maxProfit;

    }

    // Driver Class (Must be excluded in the online judge submission)
    public static class Driver {
        public static void main(String[] args) {
            // Code starts from here.
            BestTimeToBuyAndSellStock bestTimeToBuyAndSellStock = new BestTimeToBuyAndSellStock();
            int res = bestTimeToBuyAndSellStock.Approach_1(new int[]{7, 1, 5, 3, 6, 4});
            System.out.println(res);
        }
    }
}

// Conclusion: Approach 1 is optimal.
// FUTURE PLAN: I will write other approaches on this problem.

