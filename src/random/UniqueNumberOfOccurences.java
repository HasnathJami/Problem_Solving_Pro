package random;

import java.util.HashMap;
import java.util.HashSet;

// Using Hashmap to store, value with it's occurrences
// Using Hashset to add the value of occurrences
// Only unique values are stored in hashset so it will store the unique value of occurances
// check hashmap size equals or not with hashset size.. if it equals that's mean all the value of occurances are unique..as hashset stores all the hm occurrence values if all the values of the hashmap are unique else it will remove the duplicate value
public class UniqueNumberOfOccurences {
    public boolean uniqueOccurrences(int[] nums) {
        HashMap<Integer, Integer> hm = new HashMap();
        HashSet<Integer> hs = new HashSet();
        for (int i = 0; i < nums.length; i++) {
            hm.put(nums[i], hm.getOrDefault(nums[i], 0) + 1);
        }
        for(int value : hm.values()) {
            hs.add(value);
        }
//        for (int i = 0; i < nums.length; i++) {
//            hs.add(hm.get(nums[i]));
//        }
        if (hs.size() == hm.size()) {
            return true;
        } else {
            return false;
        }
    }


    public static void main(String[] args) {
        UniqueNumberOfOccurences uniqueNumberOfOccurances = new UniqueNumberOfOccurences();
        boolean res = uniqueNumberOfOccurances.uniqueOccurrences(new int[]{1, 2, 2, 1, 1, 3});
  //      boolean res = uniqueNumberOfOccurances.uniqueOccurrences(new int[]{1,2});
        System.out.println(res);
    }
}
