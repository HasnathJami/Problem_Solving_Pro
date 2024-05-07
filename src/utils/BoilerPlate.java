package utils;

//Define Approaches
enum Approach {
    FIRST_APPROACH,
    SECOND_APPROACH,
    THIRD_APPROACH,
}

class Solution {
    // Input the approach you want to execute.
    private static final Approach approach = Approach.SECOND_APPROACH;

    public int[] your_method_name(int[] your_inputs) {
        if (approach.equals(Approach.FIRST_APPROACH)) {
            return Approach_Your_Approach_Number(your_inputs);
        } else if (approach.equals(Approach.SECOND_APPROACH)) {
            return Approach_Your_Approach_Number(your_inputs);
        } else if (approach.equals(Approach.THIRD_APPROACH)) {
            return Approach_Your_Approach_Number(your_inputs);
        }
        return null;
    }

    // Approach_Your_Approach_Number: Approach Name with Time and Space Complexity
    // Outcome: Outcome of your solution (i.e., ACCEPTED, TLE, FAILED, COMPILATION ERROR, RUNTIME ERROR)
    /*
     ---------------------------------------------------------------------- NOTE ----------------------------------------------------------------------
     * Make a short note on your approach
    */

    /*
     ---------------------------------------------------------------------- Algorithm ----------------------------------------------------------------------
     * Write an algorithm on your approach.
    */
    private int[] Approach_Your_Approach_Number(int[] your_inputs) {
        // Code starts from here.
        return your_inputs;
    }
}

// Conclusion: Compare your approaches and report the best one according to your findings.
// FUTURE PLAN: Write about your upcoming approaches on this problem.

// Driver Class (Must be excluded in the online judge submission)
class Driver {
    public static void main(String[] args) {
        // Code starts from here.
    }
}