package arrays;

import java.util.HashMap;

/**
 * Problem: Two Sum
 *
 * Given an array of integers nums and an integer target,
 * return indices of the two numbers such that they add up to target.
 *
 * You may assume that each input would have exactly one solution,
 * and you may not use the same element twice.
 *
 * You can return the answer in any order.
 */
public class TwoSums {

    /**
     * Returns indices of the two numbers such that they add up to target.
     *
     * @param nums   Array of integers
     * @param target Target sum
     * @return int[] Array of two indices
     */
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();  // number -> index

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }

            map.put(nums[i], i);
        }

        // Problem guarantees one solution, but return empty array as fallback
        return new int[0];
    }

    public static void main(String[] args) {
        TwoSums sol = new TwoSums();

        int[] nums = {2, 7, 11, 15};
        int target = 9;

        int[] result = sol.twoSum(nums, target);

        System.out.println("Indices: [" + result[0] + ", " + result[1] + "]");
        // Expected output: Indices: [0, 1]
    }
}
