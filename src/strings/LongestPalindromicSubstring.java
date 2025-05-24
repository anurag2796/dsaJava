package strings;

/**
 * Question:
 * Given a string s, return the longest palindromic substring in s.
 *
 * A palindrome is a string that reads the same forward and backward.
 * The input string is assumed to have at least one character.
 */

public class LongestPalindromicSubstring {

    /**
     * Finds the longest palindromic substring by expanding around each character.
     *
     * @param s Input string
     * @return Longest palindromic substring
     */
    public String longestPalindrome(String s) {
        if(s.isEmpty() || s.length() == 1){
            return s;
        }
        String max = s.substring(0, 1);
        int length = s.length();
        for(int i =0; i<length; i++){
            String temp;
            int left= i-1, right = i+1;
            while(left>=0 && right<length && s.charAt(left) == s.charAt(right)){
                    temp = s.substring(left, right+1);
                    if(temp.length()> max.length()){
                        max = temp;
                    }

                left--; right++;
            }
            left = i; right =i+1;
            while(left>=0 && right<length && s.charAt(left) == s.charAt(right)){
                    temp = s.substring(left, right+1);
                    if(temp.length()> max.length()){
                        max = temp;
                    }
                left--; right++;
            }

        }
        return max;

    }

    public static void main(String[] args) {
        LongestPalindromicSubstring solution = new LongestPalindromicSubstring();

        String input = "babad";
        String result = solution.longestPalindrome(input);

        System.out.println("Input: " + input);
        System.out.println("Longest Palindromic Substring: " + result);
        // Output: "bab" or "aba" (both are valid)
        // ✅ Edge case: Empty string
        System.out.println("Test 2: " + solution.longestPalindrome(""));
        // Expected: ""

        // ✅ Edge case: Single character
        System.out.println("Test 3: " + solution.longestPalindrome("a"));
        // Expected: "a"

        // ✅ Edge case: All same characters
        System.out.println("Test 4: " + solution.longestPalindrome("aaaaa"));
        // Expected: "aaaaa"

        // ✅ Edge case: All unique characters
        System.out.println("Test 5: " + solution.longestPalindrome("abcde"));
        // Expected: any single character

        // ✅ Edge case: Palindrome at the start
        System.out.println("Test 6: " + solution.longestPalindrome("abacdfgdcaba"));
        // Expected: "aba"

        // ✅ Edge case: Palindrome at the end
        System.out.println("Test 7: " + solution.longestPalindrome("cbbd"));
        // Expected: "bb"

        // ✅ Edge case: Entire string is a palindrome
        System.out.println("Test 8: " + solution.longestPalindrome("racecar"));
        // Expected: "racecar"

        // ✅ Edge case: Palindrome in the middle
        System.out.println("Test 9: " + solution.longestPalindrome("abcddcbaefg"));
        // Expected: "abcddcba"

        // ✅ Edge case: String with spaces and symbols
        System.out.println("Test 10: " + solution.longestPalindrome("a!b@b!a"));
        // Expected: "a!b@b!a"
    }
}
