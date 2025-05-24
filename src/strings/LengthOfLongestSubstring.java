package strings;

import java.util.Arrays;

/**
 * Problem: Longest Substring Without Repeating Characters
 *
 * Given a string s, find the length of the longest substring
 * without repeating characters.
 *
 * Constraints:
 * - 0 <= s.length <= 5 * 10^4
 * - s consists of English letters, digits, symbols and spaces.
 *
 * This implementation uses a fixed-size array for ASCII characters
 * to improve lookup performance over a HashMap.
 */
public class LengthOfLongestSubstring {

    /**
     * Returns the length of the longest substring without repeating characters.
     *
     * @param s The input string
     * @return The length of the longest substring with all unique characters
     */
    public int lengthOfLongestSubstring(String s) {
        int lengthS = s.length();
        if (lengthS <= 1)
            return lengthS;

        int start = 0;
        int maxLen = 0;
        int[] charIndex = new int[256];  // Assuming ASCII
        Arrays.fill(charIndex, -1);

        charIndex[s.charAt(0)] = 0;

        for (int i = 1; i < s.length(); i++) {
            if (charIndex[s.charAt(i)] >= start) {
                start = charIndex[s.charAt(i)] + 1;
            }
            charIndex[s.charAt(i)] = i;
            maxLen = Math.max(maxLen, i - start + 1);
        }

        return maxLen;
    }

    public static void main(String[] args) {
        LengthOfLongestSubstring solution = new LengthOfLongestSubstring();

        String input = "abcabcbb";
        int result = solution.lengthOfLongestSubstring(input);

        System.out.println("Input: \"" + input + "\"");
        System.out.println("Longest length of substring without repeating characters: " + result);
        // Expected Output: 3 ("abc")



        // ✅ Edge case: Empty string
        System.out.println("Test 2: " + solution.lengthOfLongestSubstring(""));
        // Expected: 0

        // ✅ Edge case: Single character
        System.out.println("Test 3: " + solution.lengthOfLongestSubstring("a"));
        // Expected: 1

        // ✅ Edge case: All unique characters
        System.out.println("Test 4: " + solution.lengthOfLongestSubstring("abcdef"));
        // Expected: 6

        // ✅ Edge case: All same characters
        System.out.println("Test 5: " + solution.lengthOfLongestSubstring("aaaaaa"));
        // Expected: 1

        // ✅ Edge case: String with spaces and symbols
        System.out.println("Test 6: " + solution.lengthOfLongestSubstring("a b!c@d#e$f%"));
        // Expected: 10

        // ✅ Edge case: Longest substring at the end
        System.out.println("Test 7: " + solution.lengthOfLongestSubstring("bbbbbabcde"));
        // Expected: 5 ("abcde")

        // ✅ Edge case: Repeating pattern
        System.out.println("Test 8: " + solution.lengthOfLongestSubstring("abababab"));
        // Expected: 2 ("ab")
    }
}
