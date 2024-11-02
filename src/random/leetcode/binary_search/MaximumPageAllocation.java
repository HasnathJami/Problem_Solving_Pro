package random.leetcode.binary_search;

// Replace class name with "Solution" when submit it to LeetCode
class MaximumPageAllocation {

    //Define Approaches
    enum Approach {
        FIRST_APPROACH,
        SECOND_APPROACH,
        THIRD_APPROACH,
    }

    // Input the approach you want to execute.
    private static final Approach approach = Approach.FIRST_APPROACH;


    // Maintain the actual method name provided by LeetCode to avoid any error during submission time
    public int maxPageAllocation(int[] pages, int students) {
        if (approach.equals(Approach.FIRST_APPROACH)) {
            return Approach_1(pages, students);
        }
//        else if (approach.equals(Approach.SECOND_APPROACH)) {
//            return Approach_Your_Approach_Number(your_inputs);
//        }
//        else if (approach.equals(Approach.THIRD_APPROACH)) {
//            return Approach_Your_Approach_Number(your_inputs);
//        }
        return 0;
    }

    // Approach_1: Using Binary Search, TC -> O(nlogn), SC->O(1)
    // Outcome: ACCEPTED
    /*
     ---------------------------------------------------------------------- NOTE ----------------------------------------------------------------------
     * Make a short note on your approach
     //Already written below
    */

    /*
     ---------------------------------------------------------------------- Algorithm ----------------------------------------------------------------------
     * Write an algorithm on your approach.
    */
    private int Approach_1(int[] pages, int students) {
        // Code starts from here.
        if (pages.length < students) return -1; // as, every student must have to assign 1 page

        // we have to define the range low to high
        int low = maxOfPages(pages); // low will be max value of pages //in the case of pages.length == students..every students will allocate single books. so maximum pages will be allocated with the student with max value which is minimized
        int high = sumOfPages(pages); // high will be the sum of all pages // in the case of student no = 1. all the page value will be assigned to the single student which is minimized
        int res = 0;

        // here , we have to use normal binary search process
        while (low <= high) {
            int mid = (low + high) / 2;

            // here, we have to check if this is possible or not
            if (isFeasible(pages, students, mid)) {
                //in the last step, when, low> high and loop breaks, the result will be on mid(which will be the previous value before low>high)
                res = mid;
                // result is possible in ths mid-range so discard the right side after the mid by setting high = mid-1
                high = mid -1;
            } else {
                // result is not possible in ths mid-range so discard the left side before the mid by setting  low = mid + 1,
                // the result will be within right side
                low = mid + 1;
            }


            /*
             * On some approaches,  */
//            if (studentCount(pages, students, mid) > students) {
//                low = mid + 1;
//            } else {
//                high = mid - 1;
//            }

        }

        // or return low (which will be our result also), in the last iteration low will be pointed to our result
        // and high will be pointed to result - 1
     //   return low;
        return res;
    }

    //I mean to say that, here we have checked that in our mid-value range can be distributed the pages among the students.
    // if the student count > total number of students(in our input), that's mean we can't get our result, so we have to increase our mid-range
    // for the case if mid = 45 ..we have to allocate each pages with the students of page.length which is not possible because number of students < pages(len)..
    //it's the case when mid value comes so much left (so much min)
    // we have find our result right side then by binary search
    private boolean isFeasible(int[] pages, int students, int maxPages) {
        int studentCount = 1;
        int sum = 0;
        for (int i = 0; i < pages.length; i++) {
            if (sum + pages[i] <= maxPages) {
                sum += pages[i];
            } else {
                studentCount++;
                sum = pages[i];

                if (studentCount > students) {
                    return false;
                }
            }
        }
        return true;
    }

//    private int studentCount(int[] pages, int students, int maxPages) {
//        int studentCount = 1;
//        int sum = 0;
//        for (int i = 0; i < pages.length; i++) {
//            if (sum + pages[i] <= maxPages) {
//                sum += pages[i];
//            } else {
//                studentCount++;
//                sum = pages[i];
//            }
//        }
//        return studentCount;
//    }

    private int sumOfPages(int[] pages) {
        int sum = 0;
        for (int i = 0; i < pages.length; i++) {
            sum += pages[i];
        }
        return sum;
    }

    private int maxOfPages(int[] pages) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < pages.length; i++) {
            if (pages[i] > max) {
                max = pages[i];
            }
        }
        return max;
    }

    // Driver Class (Must be excluded in the online judge submission)
    public static class Driver {
        public static void main(String[] args) {
            // Code starts from here.
            MaximumPageAllocation maximumPageAllocation = new MaximumPageAllocation();
            int res = maximumPageAllocation.maxPageAllocation(new int[]{12, 34, 67, 90}, 2);
            System.out.println(res);
        }
    }
}

// Conclusion: Compare your approaches and report the best one according to your findings.
// FUTURE PLAN: Write about your upcoming approaches on this problem.

