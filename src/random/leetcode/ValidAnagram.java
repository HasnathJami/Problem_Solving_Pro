// package name (Must be excluded in the online judge submission)
package random.leetcode;


import java.util.Arrays;
import java.util.HashMap;

// Replace class name with "Solution" when submit it to LeetCode
class ValidAnagram {

    //Define Approaches
    enum Approach {
        FIRST_APPROACH,
        SECOND_APPROACH,
        THIRD_APPROACH,
        FOURTH_APPROACH
    }

    // Input the approach you want to execute.
    private static final Approach approach = Approach.FIRST_APPROACH;


    // Maintain the actual method name provided by LeetCode to avoid any error during submission time
    public Boolean isAnagram(String s, String t) {
        if (approach.equals(Approach.FIRST_APPROACH)) {
            return Approach_1(s, t);
        } else if (approach.equals(Approach.SECOND_APPROACH)) {
            return Approach_2(s, t);
        } else if (approach.equals(Approach.THIRD_APPROACH)) {
            return Approach_3(s, t);
        } else if (approach.equals(Approach.FOURTH_APPROACH)) {
            return Approach_4(s, t);
        }
        return null;
    }

    // Approach_1: Bruteforce Approach with TC:O(n^2) SC:O(1)
    // Outcome: TLE
    /*
     ---------------------------------------------------------------------- NOTE ----------------------------------------------------------------------
     * Make a short note on your approach
    */

    /*
     ---------------------------------------------------------------------- Algorithm ----------------------------------------------------------------------
     * Write an algorithm on your approach.
     -> No Need
    */
    private Boolean Approach_1(String s, String t) {
        // Code starts from here.
        Boolean areCharactersSame = false;
        if (s.length() != t.length()) {
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < t.length(); j++) {
                if (s.charAt(i) == t.charAt(j)) {
                    areCharactersSame = true;
                    break;
                } else {
                    areCharactersSame = false;
                }
            }
            if (areCharactersSame == false) {
                return false;
            }
        }
        return true;
    }

    // Approach_2: Sorting Approach with TC:O(nlogn) SC:O(n)
    // Outcome: ACCEPTED
    /*
     ---------------------------------------------------------------------- NOTE ----------------------------------------------------------------------
     * Make a short note on your approach
    */

    /*
     ---------------------------------------------------------------------- Algorithm ----------------------------------------------------------------------
     * Write an algorithm on your approach.
     -> No Need
    */
    private Boolean Approach_2(String s, String t) {
        // Code starts from here.
        Boolean areCharactersSame = false;
        if (s.length() != t.length()) {
            return false;
        }

        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();

        Arrays.sort(sArray);
        Arrays.sort(tArray);

        return Arrays.equals(sArray, tArray);
    }

    // Approach_3: Frequency Counting Approach (HashMap) with TC:O(n) SC:O(n)
    // Outcome: ACCEPTED
    /*
     ---------------------------------------------------------------------- NOTE ----------------------------------------------------------------------
     * Make a short note on your approach
     1. If a fixed-size array (e.g., of size 128 for ASCII characters) were used instead of a HashMap, the space complexity would be 𝑂(1)
      because the size of the array is constant and does not depend on the length of the strings.
     2. Since a HashMap is used, the space complexity scales with the number of unique characters in the input strings, leading to 𝑂(𝑛).
    */

    /*
     ---------------------------------------------------------------------- Algorithm ----------------------------------------------------------------------
     * Write an algorithm on your approach.
     -> No Need
    */

    /**
     * Checks if two strings are anagrams of each other.
     *
     * @param s the first string
     * @param t the second string
     * @return true if the strings are anagrams, false otherwise
     */
    private Boolean Approach_3(String s, String t) {
        // If the lengths of the strings are different, they cannot be anagrams.
        if (s.length() != t.length()) {
            return false;
        }

        // Create a HashMap to store character counts from string `s`.
        HashMap<Character, Integer> characterCountMap = new HashMap<>();

        // Count the frequency of each character in string `s`.
        for (int i = 0; i < s.length(); i++) {
            Character ch = s.charAt(i);
            // Update the character count: increment if already present, otherwise add with count 1.
            characterCountMap.put(ch, characterCountMap.getOrDefault(ch, 0) + 1);
        }

        // Verify that each character in string `t` is present in the HashMap with the correct count.
        for (Character ch : t.toCharArray()) {
            // If a character from `t` is not found in the HashMap, the strings are not anagrams.
            if (!characterCountMap.containsKey(ch) || characterCountMap.get(ch) == 0) {
                return false;
            }
            // Decrement the count for the character to reflect its occurrence in `t`.
            characterCountMap.put(ch, characterCountMap.get(ch) - 1);
        }

        // If all character counts are zero, the strings are anagrams.
        return true;
    }


    // Approach_4: Frequency Counting Approach (Array) with TC:O(n) SC:O(128) => O(1) because it does not grow with the size of the input.
    // Outcome: ACCEPTED
    /*
     ---------------------------------------------------------------------- NOTE ----------------------------------------------------------------------
     * Make a short note on your approach
    /*

     ---------------------------------------------------------------------- Algorithm ----------------------------------------------------------------------
     * Write an algorithm on your approach.
     -> No Need
    */
    private Boolean Approach_4(String s, String t) {
        // Check if the lengths of the two strings are different.
        // If they are, they cannot be anagrams.
        if (s.length() != t.length()) {
            return false;
        }

        // Create an array to count occurrences of characters.
        // Assuming ASCII character set with 128 possible characters.
        int[] characterCount = new int[128];

        // Traverse through each character in both strings.
        // Increment the count for characters in string `s`
        // and decrement the count for characters in string `t`.
        for (int i = 0; i < s.length(); i++) {
            // Increment count for character in `s`
            characterCount[s.charAt(i)]++;
            // Decrement count for character in `t`
            characterCount[t.charAt(i)]--;
        }

        // Check if all counts are zero.
        // If any count is not zero, the strings are not anagrams.
        for (int count : characterCount) {
            if (count != 0) {
                return false;
            }
        }

        // If all counts are zero, the strings are anagrams.
        return true;
    }


    // Driver Class (Must be excluded in the online judge submission)
    public static class Driver {
        public static void main(String[] args) {
            // Code starts from here.
            ValidAnagram vAnagram = new ValidAnagram();

            String firstValue = "rat";
            String secondValue = "car";

            Boolean result = vAnagram.isAnagram(firstValue, secondValue);

            System.out.println(result);
        }
    }
}

// Conclusion: Approach_4 is more optimal as here, TC(N) and SC(1) respectively.
// FUTURE PLAN: Write about your upcoming approaches on this problem from many resources.
