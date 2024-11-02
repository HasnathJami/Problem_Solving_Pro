package random.leetcode.binary_search;

// Replace class name with "Solution" when submitting it to LeetCode
// Same as maximum book allocation
class CapacityToShipPackagesWithinDDays {

    // Define Approaches
    enum Approach {
        FIRST_APPROACH,
        SECOND_APPROACH,
        THIRD_APPROACH,
    }

    // Input the approach you want to execute.
    private static final Approach approach = Approach.FIRST_APPROACH;

    // Maintain the actual method name provided by LeetCode to avoid any error during submission time
    public int shipWithinDays(int[] weights, int days) {
        if (approach.equals(Approach.FIRST_APPROACH)) {
            return Approach_1(weights, days);
        }
        // Add other approaches as needed
        return 0;
    }

    // Approach_1: Using Binary Search, TC -> O(n log(sum(weights) - max(weights))), SC -> O(1)
    private int Approach_1(int[] weights, int days) {
        // Define the range of capacities
        int low = maxOfWeights(weights); // Minimum capacity is the heaviest package
        int high = sumOfWeights(weights); // Maximum capacity is the sum of all packages
        int res = high;

        // Binary search for the minimum feasible capacity
        while (low <= high) {
            int mid = (low + high) / 2;

            // Check if this mid capacity is feasible
            if (isFeasible(weights, days, mid)) {
                res = mid;    // Store the feasible capacity
                high = mid - 1; // Try for a smaller capacity
            } else {
                low = mid + 1; // Increase the capacity range
            }
        }

        return res;
    }

    // Helper method to check if it’s possible to ship within the given max weight capacity
    private boolean isFeasible(int[] weights, int days, int maxWeight) {
        int daysCount = 1;
        int currentWeight = 0;

        for (int weight : weights) {
            if (currentWeight + weight > maxWeight) {
                daysCount++;
                currentWeight = weight; // Start a new day with this package
                if (daysCount > days) {
                    return false; // Too many days required
                }
            } else {
                currentWeight += weight;
            }
        }
        return true;
    }

    // Helper function to get the sum of all elements in the array
    private int sumOfWeights(int[] weights) {
        int sum = 0;
        for (int weight : weights) {
            sum += weight;
        }
        return sum;
    }

    // Helper function to get the maximum element in the array
    private int maxOfWeights(int[] weights) {
        int max = weights[0];
        for (int weight : weights) {
            if (weight > max) {
                max = weight;
            }
        }
        return max;
    }

    // Driver Class (Must be excluded in the online judge submission)
    public static class Driver {
        public static void main(String[] args) {
            CapacityToShipPackagesWithinDDays capacityToShipPackagesWithinDDays = new CapacityToShipPackagesWithinDDays();
            int res = capacityToShipPackagesWithinDDays.shipWithinDays(new int[]{3, 2, 2, 4, 1, 4}, 3);
            System.out.println(res); // Expected output should be the minimum feasible capacity
        }
    }
}

// Conclusion: Compare approaches and note the most efficient one.
// FUTURE PLAN: Add and optimize alternative approaches as needed.
